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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private boolean hemograma;
	private boolean colesterol;
	private boolean fosforo;
	private boolean calcio;
	private boolean glicose; 
	private boolean magnesio; 
	private boolean ureia;
	private boolean potassio;
	
	@NotNull(message = "Ultrassonografia não pode ser nulo")
	private String ultrassonografia;
	@NotNull(message = "Radiografia não pode ser nulo")
	private String radiografia;
	@NotNull(message = "Date não pode ser nulo")
	private Date date;
}
