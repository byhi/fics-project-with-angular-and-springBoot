package com.byhi.fics.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.service.RendszerService;
import com.byhi.fics.service.RendszerServiceImpl;

@RestController
public class RendszerController {
   
	private RendszerService rendszerService;

	@Autowired
	public void getRendszerServiceImpl(RendszerServiceImpl rendszerService) {
		this.rendszerService = rendszerService;
	}
	
	@GetMapping("/")
	public Collection<Rendszer> getAllRendszer() {		
		return rendszerService.findAll().stream().collect(Collectors.toList());
	}

	
	@GetMapping("/rendszer/{rendszerId}")
	public Rendszer getRendszer(@PathVariable String rendszerId) {
		return rendszerService.findById(new Long(Integer.valueOf(rendszerId)));
	}
	
	@PostMapping("/rendszer")
	void addRendszer(@RequestBody Rendszer rendszer) {
		rendszerService.addRendszer(rendszer);
	}

	@DeleteMapping("/rendszer/{rendszerId}")
	void deleteRendszer(@PathVariable String rendszerId) {
		rendszerService.deleteRendszer(new Long(Integer.valueOf(rendszerId)));
	}

	@PutMapping("/rendszer")
	void updateRendszer(@RequestBody Rendszer rendszer) {
		rendszerService.updateRendszer(rendszer);
	}
	
}
