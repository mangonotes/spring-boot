package com.sony.crm.util;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.sony.crm.exception.InvalidCharacterException;

public class StringHtmlDeSerializer extends StringDeserializer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8956040653100737490L;

	@Override
	public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		Optional<String> value = Optional.of( super.deserialize(p, ctxt)).filter(val -> {
			return !HtmlUtil.isHtmlString.test(val);
			
		}); 
		
		value.orElseThrow(()->  new InvalidCharacterException(ErrorCode.INVALID_CHARACTER));
		return value.get();
	}
	
}