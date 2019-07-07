package com.sony.crm.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sony.crm.exception.CustomOAuth2Exception;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOAuth2Exception> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7474639562217283901L;
	public CustomOauthExceptionSerializer() {
        super(CustomOAuth2Exception.class);
    }
	@Override
	public void serialize(CustomOAuth2Exception value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		gen.writeStartObject();
		gen.writeStringField("response", value.getResponse());
		gen.writeObjectField("status",value.getStatus());
		gen.writeEndObject();
		
	}

}
