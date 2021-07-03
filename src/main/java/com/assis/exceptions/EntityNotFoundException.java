package com.assis.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String entity, Integer id) {
		super("Entidade " + entity + " de ID " + id + " não encontrada."); 
	}

}
