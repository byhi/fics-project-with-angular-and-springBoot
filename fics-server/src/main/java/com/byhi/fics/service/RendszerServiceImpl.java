package com.byhi.fics.service;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.RendszerRepository;

@Service
public class RendszerServiceImpl implements RendszerService {
	private RendszerRepository repository;
	@Autowired
    public void getRendszerRepository(RendszerRepository repository) {
        this.repository = repository;
    }

	public Collection<Rendszer> findAll() {	
		return repository.findAll().stream()               
		        .collect(Collectors.toList());
	}

	public void addRendszer(Rendszer rendszer) {
		this.repository.save(rendszer);
	} 

	public void deleteRendszer(Rendszer rendszer) {
		this.repository.delete(rendszer);
		
	}

	public void deleteRendszer(Long id) {
		this.repository.deleteById(id);		
	}

	public void updateRendszer(Rendszer rendszer) {
		this.repository.save(rendszer);
	}


	public Rendszer findById(Long id) {
		return repository.findById(id).get();
	}
	
}
