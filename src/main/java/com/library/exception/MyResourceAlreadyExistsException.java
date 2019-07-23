package com.library.exception;

public final class MyResourceAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyResourceAlreadyExistsException() {
		super();
	}

	public MyResourceAlreadyExistsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public MyResourceAlreadyExistsException(final String message) {
		super(message);
	}

	public MyResourceAlreadyExistsException(final Throwable cause) {
		super(cause);
	}

}