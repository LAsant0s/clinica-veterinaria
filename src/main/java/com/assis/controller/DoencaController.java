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

import com.assis.domain.Doenca;
import com.assis.service.DoencasService;

@RestController
@RequestMapping("/doencas")
public class DoencaController {
	
	@Autowired
	private DoencasService service;
	
	@GetMapping
	public List<Doenca> allDoencas() {
		return service.allDoencas(); 
	}
	
	@PostMapping("/newDoenca")
	public Doenca newDoenca(@Valid @RequestBody Doenca doencas) {
		return service.newDoenca(doencas);	
	}
	
	@GetMapping("/id={id}")
	public Doenca findDoenca(@PathVariable Integer id) throws Exception {
		return service.findDoencaById(id);
	}
	
	@PostMapping("/id={id}") 
	public Doenca updateDoenca(@Valid @RequestBody Doenca doencas, @PathVariable Integer id) {
		return service.updateDoencaById(id, doencas); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteDoenca(@PathVariable Integer id) {
		service.deleteDoencaById(id);
	}
	
}