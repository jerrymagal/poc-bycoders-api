package br.com.bycoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.entities.Cnab;
import br.com.bycoders.repository.CnabRepository;

@Service
public class CnabService {
	
	@Autowired
	private CnabRepository cnabRepository;

	public List<Cnab> listAll() {
		return cnabRepository.findAll();
	}
}
