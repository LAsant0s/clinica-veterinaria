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

import com.assis.domain.Exame;
import com.assis.service.ExameService;

@RestController
@RequestMapping("/exam")
public class ExameController {
	
	@Autowired
	private ExameService service;
	
	@GetMapping
	public List<Exame> allExames() {
		return service.allExames(); 
	}
	
	@PostMapping("/newExam")
	public Exame newExame(@Valid @RequestBody Exame exame) {
		return service.newExame(exame);	
	}
	
	@GetMapping("/id={id}")
	public Exame findExame(@PathVariable Integer id) throws Exception {
		return service.findExameById(id);
	}
	
	@PostMapping("/id={id}") 
	public Exame updateExame(@Valid @RequestBody Exame exame, @PathVariable Integer id) {
		return service.updateExameById(id, exame); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteExam(@PathVariable Integer id) {
		service.deleteExameById(id);
	}
	
}