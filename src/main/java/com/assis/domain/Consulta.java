package com.assis.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Anamnese anamnese; 
	
	@NotNull(message = "animal_id não pode ser nulo")
	private Integer animal_id;
	
	@NotNull(message = "Data não pode ser nulo")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String date;
	
	@NotNull(message = "Observações não pode ser nulo")
	private String observacoes;
	
	@NotNull(message = "Queixa não pode ser nulo")
	private String queixa;
	
	@NotNull(message = "Histórico não pode ser nulo")
	private String historico; 

}
