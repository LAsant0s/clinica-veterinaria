package com.assis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	private Double peso;
	
	@NotNull(message = "Tipo não pode ser nulo")
	private Integer tipo;
	
	@NotNull(message = "Data de Nascimento não pode ser nulo")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String dataNascimento;
	
	@NotNull(message = "Data de cadastro não pode ser nulo")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String dataCadastro;
	
	@NotNull(message = "Estado não pode ser nulo")
	private Integer estado;
	
}
