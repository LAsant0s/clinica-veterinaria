package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Doenca;
import com.assis.exceptions.EntityNotFoundException;
import com.assis.repository.DoencasRepository;

@Service
public class DoencasService {

	@Autowired
	private DoencasRepository repo;

	public List<Doenca> allDoencas() {
		return repo.findAll();
	}
	
	public Doenca newDoenca(Doenca doencas) {
		return repo.save(doencas);
	}
	
	public Doenca updateDoencaById(Integer id, Doenca doencas) {
		Doenca entityId = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Doenca", id));
		doencas.setId(entityId.getId());
		return repo.save(doencas);
	}
	
	public Doenca findDoencaById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new EntityNotFoundException("Doenca", id));
	}
	
	public void deleteDoencaById(Integer id) {
		repo.deleteById(id);
	}
	
}
