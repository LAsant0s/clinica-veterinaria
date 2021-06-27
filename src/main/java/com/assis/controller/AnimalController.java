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

import com.assis.domain.Animal;
import com.assis.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	@GetMapping
	public List<Animal> allAnimals() {
		return service.allAnimals(); 
	}
	
	@PostMapping("/newAnimal")
	public Animal newAnimal(@Valid @RequestBody Animal animal) {
		return service.newAnimal(animal);	
	}
	
	@GetMapping("/id={id}")
	public Animal findAnimal(@PathVariable Integer id) throws Exception {
		return service.findAnimalById(id);
	}
	
	@PostMapping("/id={id}") 
	public Animal updateAnimal(@Valid @RequestBody Animal animal, @PathVariable Integer id) {
		return service.updateAnimalById(id, animal); 
	}
	
	@DeleteMapping("id={id}")
	public void deleteAnimal(@PathVariable Integer id) {
		service.deleteAnimalById(id);
	}
	
}