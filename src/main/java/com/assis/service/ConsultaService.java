package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Animal;
import com.assis.domain.Consulta;
import com.assis.exceptions.EntityNotFoundException;
import com.assis.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repo;
	
	@Autowired 
	private AnimalService aService; 

	public List<Consulta> allConsults() {
		return repo.findAll();
	}
	
	public Consulta newConsult(Consulta consulta) {
		Animal currentAnimal = aService.findAnimalById(consulta.getAnimal_id());
		Consulta newConsult = repo.save(consulta); 
		currentAnimal.getConsultas().add(consulta);
		aService.updateAnimalById(currentAnimal.getId(), currentAnimal); 
		return newConsult;
	}
	
	public Consulta updateConsultById(Integer id, Consulta consulta) {
		Consulta entityId = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta", id));
		consulta.setId(entityId.getId());
		return repo.save(consulta);
	}
	
	public Consulta findConsultById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new EntityNotFoundException("Consulta", id));
	}
	
	public void deleteConsultById(Integer id) {
		repo.deleteById(id);
	}
	
}
