package com.byhi.fics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.byhi.fics.domain.Modul;
import com.byhi.fics.service.ModulServiceImpl;
import com.byhi.fics.service.RendszerServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/modul")
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
	
	@GetMapping("/{rendszerId}")
	public Modul getModul(@PathVariable String rendszerId) {	
		return modulServiceImpl.findById(new Long(Integer.valueOf(rendszerId)));
	}
	
	@PostMapping("/{rendszerId}")
	void addModul(@PathVariable String rendszerId, @RequestBody Modul modul) {
		modulServiceImpl.addModul(modul, this.rendszerService.findById(new Long(Integer.valueOf(rendszerId))));
	}

	@DeleteMapping("/{modulId}")
	void deleteModul(@PathVariable String modulId) {
		modulServiceImpl.deleteModul(new Long(Integer.valueOf(modulId)));
	}

	
	@PutMapping("/{rendszerId}")
	void updateModul(@PathVariable String rendszerId,@RequestBody Modul modul) {
		modulServiceImpl.updateModul(modul, this.rendszerService.findById(new Long(Integer.valueOf(rendszerId))));
	}
}
