package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Anamnese;
import com.assis.exceptions.AnamneseNotFoundException;
import com.assis.exceptions.ExameNotFoundException;
import com.assis.repository.AnamneseRepository;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repo;

	public List<Anamnese> allAnamnese() {
		return repo.findAll();
	}
	
	public Anamnese newAnamnese(Anamnese anamnese) {
		return repo.save(anamnese);
	}
	
	public Anamnese updateAnamneseById(Integer id, Anamnese anamnese) {
		Anamnese entityId = repo.findById(id).orElseThrow(() -> new ExameNotFoundException(id));
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
	
}
