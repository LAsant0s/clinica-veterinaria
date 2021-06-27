package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Exame;
import com.assis.exceptions.ExameNotFoundException;
import com.assis.repository.ExameRepository;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repo;

	public List<Exame> allExames() {
		return repo.findAll();
	}
	
	public Exame newExame(Exame exame) {
		return repo.save(exame);
	}
	
	public Exame updateExameById(Integer id, Exame exame) {
		Exame entityId = repo.findById(id).orElseThrow(() -> new ExameNotFoundException(id));
		exame.setId(entityId.getId());
		return repo.save(exame);
	}
	
	public Exame findExameById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new ExameNotFoundException(id));
	}
	
	public void deleteExameById(Integer id) {
		repo.deleteById(id);
	}
	
}



