package com.byhi.fics.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.ModulRepository;

@Service
public class ModulServiceImpl implements ModulService {

	private ModulRepository modulRepository;
	
	@Autowired
    public void getModulRepository(ModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }
	
	public Collection<Modul> findAll() {
		return modulRepository.findAll().stream()               
		        .collect(Collectors.toList());
	}

	public void addModul(Modul modul, Rendszer rendszer) {
		modul.setR_id(rendszer);
		this.modulRepository.save(modul);
		
	}

	public void deleteModul(Long id) {
		this.modulRepository.deleteById(id);			
	}

	public void updateModul(Modul modul) {
		this.modulRepository.save(modul);		
	}

	public Modul findById(Long r_id) {
		return this.modulRepository.findById(r_id).get();		
	}

	public void updateModul(Modul modul, Rendszer rendszer) {
		
		Modul m = this.modulRepository.findById(modul.getId()).get();
		
		if (rendszer.getId().equals(m.getR_id().getId())) {
			m.setName(modul.getName());
			m.setDesc(modul.getDesc());
			this.modulRepository.save(m);		
		} else {
			modul.setR_id(rendszer);
			this.modulRepository.save(modul);	
		}
	}
}
