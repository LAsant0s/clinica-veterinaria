package com.assis.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "animal_id não pode ser nulo")
	private Integer animal_id;
	
	@NotNull(message = "Data não pode ser nulo")
	private Date date;
	
	@NotNull(message = "Observações não pode ser nulo")
	private String observacoes;
	
	@NotNull(message = "Queixa não pode ser nulo")
	private String queixa;
	
	@NotNull(message = "Histórico não pode ser nulo")
	private String historico; 

}
