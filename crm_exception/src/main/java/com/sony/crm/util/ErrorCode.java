package com.sony.crm.util;

public enum ErrorCode {
INVALID_CHARACTER(221, "Invalid character not allowed "),
SYSTEM_ERROR(400, "System error , please contact system admin"),
SUCCESS(200, "Success")	;
private final int errorCode;
private final String errorDescription;
private ErrorCode(int errorCode, String errorDescription)
{
	this.errorCode= errorCode;
	this.errorDescription=errorDescription;
}
public int getErrorCode() {
	return errorCode;
}
public String getErrorDescription() {
	return errorDescription;
}

}
