package com.sony.crm.ui.dto;

public interface IBaseResponse  <T> {
	 T getResponse();
	 ResponseStatus getStatus();
	 
}
