package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Anamnese;
import com.assis.domain.Doenca;
import com.assis.exceptions.AnamneseNotFoundException;
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
		Anamnese entityId = repo.findById(id).orElseThrow(() -> new AnamneseNotFoundException(id));
		anamnese.setId(entityId.getId());
		return repo.save(anamnese);
	}
	
	public Anamnese findAnamneseById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new AnamneseNotFoundException(id));
	}
	
	public void deleteAnamneseById(Integer id) {
		repo.deleteById(id);
	}
	
	public Anamnese InsertNewDoenca(Integer idAnamnese, Integer idDoenca) {
		
		Anamnese targetAnamnese = repo.findById(idAnamnese).orElseThrow(() -> new AnamneseNotFoundException(idAnamnese));
		Doenca doenca = dService.findDoencaById(idDoenca);
	
		if(targetAnamnese.getDoencas().size() >= 5) {
			throw new InvalidOperationException("Não é possível adicionar mais doenças");
		}
		targetAnamnese.getDoencas().add(doenca); 
		
		return updateAnamneseById(idAnamnese, targetAnamnese);
	}
	
}
