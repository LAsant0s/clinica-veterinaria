package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Animal;
import com.assis.exceptions.AnimalNotFoundException;
import com.assis.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repo;

	public List<Animal> allAnimals() {
		return repo.findAll();
	}
	
	public Animal newAnimal(Animal animal) {
		return repo.save(animal);
	}
	
	public Animal updateAnimalById(Integer id, Animal animal) {
		Animal entityId = repo.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
		animal.setId(entityId.getId());
		return repo.save(animal);
	}
	
	public Animal findAnimalById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new AnimalNotFoundException(id));
	}
	
	public void deleteAnimalById(Integer id) {
		repo.deleteById(id);
	}
	
}
