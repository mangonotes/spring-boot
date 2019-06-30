package com.sony.crm.ui.dto;

public class BaseResponse<T> implements IBaseResponse<T> {
private T response;
private ResponseStatus status;
	@Override
	public T getResponse() {
		return response;
	}

	@Override
	public ResponseStatus getStatus() {
		
		return status;
	}

	public BaseResponse(T response) {
		super();
		this.response = response;
		this.status = new ResponseStatus();
	}

	public BaseResponse(T response, ResponseStatus status) {
		super();
		this.response = response;
		this.status = status;
	}
	
}
