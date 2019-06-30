package com.sony.crm.exception;

import com.sony.crm.util.ErrorCode;

public class InvalidCharacterException extends RuntimeException {
	private ErrorCode errorCode;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCharacterException() {
		super();
	}

	public InvalidCharacterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidCharacterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCharacterException(String message) {
		super(message);
	}

	public InvalidCharacterException(Throwable cause) {
		super(cause);
	}
	public InvalidCharacterException(ErrorCode errorCode)
	{
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	

}
