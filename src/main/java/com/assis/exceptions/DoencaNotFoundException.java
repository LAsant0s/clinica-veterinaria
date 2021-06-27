package com.assis.exceptions;

public class DoencaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoencaNotFoundException(Integer id) {
		super("Doenca de Id " + id + " não encontrado.");
	}

}
