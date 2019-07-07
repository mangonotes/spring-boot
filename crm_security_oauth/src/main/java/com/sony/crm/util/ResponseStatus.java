package com.sony.crm.util;

public class ResponseStatus {
private  int code;
private  String message;
private  String error;
public ResponseStatus( String message) {
	this();
	this.message = message;
}
public ResponseStatus(ErrorCode code)
{
	this.code = code.getErrorCode();
	this.error = code.getErrorDescription();
}
public ResponseStatus(String error , int errorCode)
{
	this.error = error;
	this.code= errorCode;
}
public ResponseStatus()
{
	this.code=ErrorCode.SUCCESS.getErrorCode();
	this.error = ErrorCode.SUCCESS.getErrorDescription();
}
public int getCode() {
	return code;
}
public String getMessage() {
	return message;
}
public String getError() {
	return error;
}

}
