package com.techm.learning.exception;

public class LPException extends Exception {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String message;
	private Throwable cause;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrMsg() {
		return message;
	}
	public void setErrMsg(String message) {
		this.message = message;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	public LPException(String errorCode, String message, Throwable _ex ) {
		super(message, _ex);
		
		this.errorCode = errorCode;
		this.message = message;
		this.cause = _ex;
	}
	
	public LPException(String errorCode, String message) {
		this(errorCode, message, null);		
	}
}

