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

import com.assis.domain.Anamnese;
import com.assis.service.AnamneseService;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {
	
	@Autowired
	private AnamneseService service;
	
	@GetMapping
	public List<Anamnese> allAnamnese() {
		return service.allAnamnese(); 
	}
	
	@PostMapping("/newAnamnese")
	public Anamnese newAnamnese(@Valid @RequestBody Anamnese anamnese) {
		return service.newAnamnese(anamnese);	
	}
	
	@GetMapping("/id={id}")
	public Anamnese findAnamnese(@PathVariable Integer id) throws Exception {
		return service.findAnamneseById(id);
	}
	
	@PostMapping("/id={id}") 
	public Anamnese updateAnamnese(@Valid @RequestBody Anamnese anamnese, @PathVariable Integer id) {
		return service.updateAnamneseById(id, anamnese); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteAnamnese(@PathVariable Integer id) {
		service.deleteAnamneseById(id);
	}
	
}