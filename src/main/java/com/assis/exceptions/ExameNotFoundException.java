package com.assis.exceptions;

public class ExameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExameNotFoundException(Integer id) {
		super("Exame de Id " + id + " não encontrado.");
	}

}
