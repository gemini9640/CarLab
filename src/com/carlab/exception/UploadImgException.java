package com.carlab.exception;

public class UploadImgException extends Exception {
	private static final long serialVersionUID = 8669403950171336285L;
	private String message;  

	public UploadImgException() {
		super();
	}
 
	public UploadImgException(String message) {
		super(message);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
