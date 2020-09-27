package com.paynet.wallet.dto;

import lombok.Data;

@Data
public class ApiResponseWithBody extends ApiResponse {
	 private Object data;
	 
	 public ApiResponseWithBody(boolean success, String message, Object data) {
		 super(success, message);
		 this.data = data;
	 }
	 
}
