package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Doencas;
import com.assis.exceptions.AnamneseNotFoundException;
import com.assis.exceptions.DoencaNotFoundException;
import com.assis.repository.DoencasRepository;

@Service
public class DoencasService {

	@Autowired
	private DoencasRepository repo;

	public List<Doencas> allDoencas() {
		return repo.findAll();
	}
	
	public Doencas newDoenca(Doencas doencas) {
		return repo.save(doencas);
	}
	
	public Doencas updateDoencaById(Integer id, Doencas doencas) {
		Doencas entityId = repo.findById(id).orElseThrow(() -> new DoencaNotFoundException(id));
		doencas.setId(entityId.getId());
		return repo.save(doencas);
	}
	
	public Doencas findDoencaById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new AnamneseNotFoundException(id));
	}
	
	public void deleteDoencaById(Integer id) {
		repo.deleteById(id);
	}
	
}