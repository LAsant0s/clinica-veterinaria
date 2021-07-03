package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Animal;
import com.assis.domain.Exame;
import com.assis.exceptions.EntityNotFoundException;
import com.assis.repository.ExameRepository;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repo;
	
	@Autowired
	private AnimalService aService;

	public List<Exame> allExames() {
		return repo.findAll();
	}
	
	public Exame newExame(Exame exame) {
		Animal currentAnimal = aService.findAnimalById(exame.getAnimal_id());
		Exame newExam = repo.save(exame);
		currentAnimal.getExames().add(exame);
		aService.updateAnimalById(currentAnimal.getId(), currentAnimal); 
		return newExam;
	}
	
	public Exame updateExameById(Integer id, Exame exame) {
		Exame entityId = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Exame", id));
		exame.setId(entityId.getId());
		return repo.save(exame);
	}
	
	public Exame findExameById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new EntityNotFoundException("Exame", id));
	}
	
	
	public void deleteExameById(Integer id) {
		repo.deleteById(id);
	}
	
}



