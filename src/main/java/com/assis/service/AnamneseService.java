package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Anamnese;
import com.assis.domain.Doenca;
import com.assis.exceptions.EntityNotFoundException;
import com.assis.exceptions.InvalidOperationException;
import com.assis.repository.AnamneseRepository;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repo;
	
	@Autowired
	private DoencasService dService; 

	public List<Anamnese> allAnamnese() {
		return repo.findAll();
	}
	
	public Anamnese newAnamnese(Anamnese anamnese) {
		return repo.save(anamnese);
	}
	
	public Anamnese updateAnamneseById(Integer id, Anamnese anamnese) {
		Anamnese entityId = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Anamnese", id));
		anamnese.setId(entityId.getId());
		return repo.save(anamnese);
	}
	
	public Anamnese findAnamneseById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new EntityNotFoundException("Anamnese", id));
	}
	
	public void deleteAnamneseById(Integer id) {
		repo.deleteById(id);
	}
	
	public Anamnese InsertNewDoenca(Integer idAnamnese, Integer idDoenca) {
		
		Anamnese targetAnamnese = repo.findById(idAnamnese).orElseThrow(() -> new EntityNotFoundException("Anamnese", idAnamnese));
		Doenca doenca = dService.findDoencaById(idDoenca);
		
		if(targetAnamnese.getDoencas().contains(doenca)) { 
			throw new InvalidOperationException("Não é possível adicionar a mesma doença mais de uma vez em uma anamnese.");
		}
			
		if(targetAnamnese.getDoencas().size() >= 5) {
			throw new InvalidOperationException("Não é possivel adicionar mais de 5 doenças em uma anamnese.");
		}
		targetAnamnese.getDoencas().add(doenca); 
		
		return updateAnamneseById(idAnamnese, targetAnamnese);
	}
	
}
