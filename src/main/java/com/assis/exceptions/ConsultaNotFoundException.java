package com.assis.exceptions;

public class ConsultaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConsultaNotFoundException(Integer id) {
		super("Consulta de Id " + id + " não encontrado.");
	}

}
