package com.library.exception;

public final class FileStorageException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileStorageException() {
        super();
    }

    public FileStorageException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FileStorageException(final String message) {
        super(message);
    }

    public FileStorageException(final Throwable cause) {
        super(cause);
    }

}