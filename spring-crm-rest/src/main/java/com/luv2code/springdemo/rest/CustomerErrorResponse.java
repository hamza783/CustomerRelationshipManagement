package com.luv2code.springdemo.rest;

public class CustomerErrorResponse {

	private int errorCode;
	private String message;
	private long timeStamp;
	
	public CustomerErrorResponse(int error, String message2, long time) {
		this.errorCode=error;
		this.message=message2;
		this.timeStamp=time;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
