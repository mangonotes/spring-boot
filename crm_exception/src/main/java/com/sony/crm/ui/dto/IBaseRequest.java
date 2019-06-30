package com.sony.crm.ui.dto;

public interface IBaseRequest <T> {
	  void setRequest(T t);
	   T getRequest();
}
