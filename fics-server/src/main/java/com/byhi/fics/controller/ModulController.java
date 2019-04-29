package com.byhi.fics.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.service.ModulServiceImpl;
import com.byhi.fics.service.RendszerServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ModulController {

	private ModulServiceImpl modulServiceImpl;

	@Autowired
	public void getModulServiceImpl(ModulServiceImpl modulServiceImpl) {
		this.modulServiceImpl = modulServiceImpl;
	}

	private RendszerServiceImpl rendszerService;

	@Autowired
	public void getRendszerServiceImpl(RendszerServiceImpl rendszerService) {
		this.rendszerService = rendszerService;
	}

	@GetMapping("/modul/{rendszerId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Modul> getModuls(@PathVariable String rendszerId) {
		System.out.println("getModuls " + rendszerId);
		return rendszerService.findById(new Long(Integer.valueOf(rendszerId))).getModuls().stream()
				.collect(Collectors.toList());
	}

	@GetMapping("/modul/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Modul> getAllModul() {
		return modulServiceImpl.findAll().stream().collect(Collectors.toList());
	}

	@PostMapping("/modul/add")
	void addModul(@RequestBody Modul rendszer) {
		modulServiceImpl.addModul(rendszer);
	}

	@DeleteMapping("/modul/{rendszerId}")
	void deleteModul(@PathVariable String rendszerId) {
		modulServiceImpl.deleteModul(new Long(Integer.valueOf(rendszerId)));
	}

	@PostMapping("/modul/{id}}")
	void updateModul(@RequestBody Modul modul) {
		modulServiceImpl.updateModul(modul);
	}
}
