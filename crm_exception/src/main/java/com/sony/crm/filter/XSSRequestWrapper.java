package com.sony.crm.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sony.crm.exception.InvalidCharacterException;
import com.sony.crm.util.ErrorCode;
import com.sony.crm.util.HtmlUtil;

public class XSSRequestWrapper  extends HttpServletRequestWrapper  {
	Logger logger = LoggerFactory.getLogger(XSSRequestWrapper.class);
	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	 @Override
	    public String[] getParameterValues(String parameter) {
	        String[] values = super.getParameterValues(parameter);

	        if (values == null) {
	            return null;
	        }

	        if (HtmlUtil.isHtmlArray.test(values))
	        {
	        	throw new InvalidCharacterException(ErrorCode.INVALID_CHARACTER);
	        }
	        return values;
	    }
	 @Override
	    public String getParameter(String parameter) {
	        String value = super.getParameter(parameter);
	        if (value == null) {
	            return null;
	        }
	       if (HtmlUtil.isHtmlString.test(value))
	       {
	    	   throw new InvalidCharacterException(ErrorCode.INVALID_CHARACTER);  
	       }
	        return value;
	    }

	    @Override
	    public String getHeader(String name) {
	        String value = super.getHeader(name);
	        if (value == null) {
	            return null;
	        }
	        if (HtmlUtil.isHtmlString.test(value))
		       {
		    	   throw new InvalidCharacterException(ErrorCode.INVALID_CHARACTER);  
		       }
		        return value;
	    }
}
