package com.assis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.domain.Consulta;
import com.assis.exceptions.ConsultaNotFoundException;
import com.assis.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repo;

	public List<Consulta> allConsults() {
		return repo.findAll();
	}
	
	public Consulta newConsult(Consulta consulta) {
		return repo.save(consulta);
	}
	
	public Consulta updateConsultById(Integer id, Consulta consulta) {
		Consulta entityId = repo.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));
		consulta.setId(entityId.getId());
		return repo.save(consulta);
	}
	
	public Consulta findConsultById(Integer id) {
		return repo.findById(id).
				orElseThrow(() -> new ConsultaNotFoundException(id));
	}
	
	public void deleteConsultById(Integer id) {
		repo.deleteById(id);
	}
	
}
