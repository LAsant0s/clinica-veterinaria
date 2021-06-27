package com.assis.exceptions;

public class AnamneseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnamneseNotFoundException(Integer id) {
		super("Anamnese de Id " + id + " não encontrado.");
	}

}
