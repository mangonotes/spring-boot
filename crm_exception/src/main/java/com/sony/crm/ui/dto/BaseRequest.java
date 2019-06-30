package com.sony.crm.ui.dto;

public class BaseRequest<T> implements IBaseRequest<T> {
	private T request;
	public void setRequest(T t) {
		this.request=t;
		
	}
	public T getRequest() {
		return request;
	}


}
