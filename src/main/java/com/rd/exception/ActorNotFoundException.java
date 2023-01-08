package com.rd.exception;

public class ActorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ActorNotFoundException(String msg) {
		super(msg);
	}

}
