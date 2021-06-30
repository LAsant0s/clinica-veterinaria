package com.assis.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Exame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer animal_id; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "hemograma não pode ser nulo")
	private Boolean hemograma;
	
	@NotNull(message = "colesterol não pode ser nulo")
	private Boolean colesterol;
	
	@NotNull(message = "fosforo não pode ser nulo")
	private Boolean fosforo;
	
	@NotNull(message = "calcio não pode ser nulo")
	private Boolean calcio;
	
	@NotNull(message = "glicose não pode ser nulo")
	private Boolean glicose; 
	
	@NotNull(message = "magnesio não pode ser nulo")
	private Boolean magnesio;
	
	@NotNull(message = "ureia não pode ser nulo")
	private Boolean ureia;
	
	@NotNull(message = "potassio não pode ser nulo")
	private Boolean potassio;
	
	@NotNull(message = "Ultrassonografia não pode ser nulo")
	private String ultrassonografia;
	
	@NotNull(message = "Radiografia não pode ser nulo")
	private String radiografia;
	
	@NotNull(message = "Date não pode ser nulo")
	private Date date;
}
