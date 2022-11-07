package com.image.exception;

public class FileStorageException extends Exception {

	public FileStorageException(String args) {
		super(args);
	}

	public FileStorageException(String args, Exception ex) {
		super(args, ex);
	}

}
