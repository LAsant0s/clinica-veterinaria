package com.assis.exceptions;

public class AnimalNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnimalNotFoundException(Integer id) {
		super("Animal de Id " + id + " não encontrado.");
	}

}
