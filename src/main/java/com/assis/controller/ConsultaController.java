package com.assis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.assis.domain.Consulta;
import com.assis.service.ConsultaService;

@RestController
@RequestMapping("/consult")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public List<Consulta> allConsults() {
		return service.allConsults(); 
	}
	
	@PostMapping(value = {"/newConsult", "/newConsult/A={idAnamnsese}"})
	public Consulta newConsult(@Valid @RequestBody Consulta consulta, @PathVariable(required = false) Integer idAnamnsese) {
		return service.newConsult(consulta, idAnamnsese);	
	}
	
	@GetMapping("/id={id}")
	public Consulta findConsult(@PathVariable Integer id) {
		return service.findConsultById(id);
	}
	
	@PostMapping("/id={id}") 
	public Consulta updateConsult(@Valid @RequestBody Consulta consulta, @PathVariable Integer id) {
		return service.updateConsultById(id, consulta); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteConsult(@PathVariable Integer id) {
		service.deleteConsultById(id);
	}
	
}