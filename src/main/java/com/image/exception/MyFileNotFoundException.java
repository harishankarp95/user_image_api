package com.image.exception;

public class MyFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyFileNotFoundException(String value) {
		super(value);
	}
}
