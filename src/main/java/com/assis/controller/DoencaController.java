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

import com.assis.domain.Doencas;
import com.assis.service.DoencasService;

@RestController
@RequestMapping("/doencas")
public class DoencaController {
	
	@Autowired
	private DoencasService service;
	
	@GetMapping
	public List<Doencas> allDoencas() {
		return service.allDoencas(); 
	}
	
	@PostMapping("/newDoenca")
	public Doencas newDoenca(@Valid @RequestBody Doencas doencas) {
		return service.newDoenca(doencas);	
	}
	
	@GetMapping("/id={id}")
	public Doencas findDoenca(@PathVariable Integer id) throws Exception {
		return service.findDoencaById(id);
	}
	
	@PostMapping("/id={id}") 
	public Doencas updateDoenca(@Valid @RequestBody Doencas doencas, @PathVariable Integer id) {
		return service.updateDoencaById(id, doencas); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteDoenca(@PathVariable Integer id) {
		service.deleteDoencaById(id);
	}
	
}