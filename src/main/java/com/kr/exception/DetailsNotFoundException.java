package com.kr.exception;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DetailsNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	




	
	

}
