package com.assis.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Exame> exames = new ArrayList<Exame>();
	
	@OneToMany
	private List<Consulta> consultas = new ArrayList<Consulta>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "Foto não pode ser nulo")
	private String foto;
	
	@NotNull(message = "Raça não pode ser nulo")
	private String raca;
	
	@NotNull(message = "Pelagem não pode ser nulo")
	private String pelagem;
	
	@NotNull(message = "Peso não pode ser nulo")
	private Integer peso;
	
	@NotNull(message = "Tipo não pode ser nulo")
	private Integer tipo;
	
	@NotNull(message = "Data de Nascimento não pode ser nulo")
	private Date dataNascimento;
	
	@NotNull(message = "Data de cadastro não pode ser nulo")
	private Date dataCadastro;
	
	@NotNull(message = "Estado não pode ser nulo")
	private Integer estado;
	
}
