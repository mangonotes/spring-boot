package com.sony.crm.util;

import java.util.Arrays;
import java.util.function.Predicate;

import org.springframework.web.util.HtmlUtils;

public class HtmlUtil {
	public static Predicate<String> isHtmlString = inputString -> {
		if (!inputString.equals(HtmlUtils.htmlEscape(inputString))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	};
	public static Predicate<String[]> isHtmlArray = inputStringArray -> {
		return Arrays.stream(inputStringArray).anyMatch(isHtmlString);
	};
	


}
