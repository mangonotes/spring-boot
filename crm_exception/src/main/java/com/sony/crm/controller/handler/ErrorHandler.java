package com.sony.crm.controller.handler;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.sony.crm.exception.InvalidCharacterException;
import com.sony.crm.ui.dto.BaseResponse;
import com.sony.crm.ui.dto.ResponseStatus;
import com.sony.crm.util.ErrorCode;

@RestControllerAdvice
public class ErrorHandler {
	Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
	
	  MessageSource messageSource;
	@Autowired
	public ErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(InvalidCharacterException.class)
    public ResponseEntity<BaseResponse> handleContentNotAllowedException(InvalidCharacterException exception) {
		String message = Optional.of( messageSource.getMessage("error.code." + exception.getErrorCode().getErrorCode(), null,LocaleContextHolder.getLocale() ))
				.filter(predicate -> {
					return !predicate.equalsIgnoreCase("error.code." + exception.getErrorCode().getErrorCode());
				})
				.orElseGet( () -> exception.getErrorCode().getErrorDescription() );
		
		      ResponseStatus status = new ResponseStatus(message, exception.getErrorCode().getErrorCode());
        return new ResponseEntity<BaseResponse>(new BaseResponse(null, status), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(JsonMappingException.class)
	  public ResponseEntity<BaseResponse> handleContentJsonMappingExcception(JsonMappingException exception)
	{
		Optional<Throwable> rootCause = Stream.iterate(exception, Throwable::getCause)
                .filter(element -> element.getCause() == null)
                .findFirst().filter(e ->  (e instanceof InvalidCharacterException));
		if (rootCause.isPresent())
				{
			return handleContentNotAllowedException((InvalidCharacterException)rootCause.get());
				}
		ResponseStatus status = new ResponseStatus(ErrorCode.SYSTEM_ERROR);
        return new ResponseEntity<BaseResponse>(new BaseResponse(null, status), HttpStatus.BAD_REQUEST);
		
	}

}
