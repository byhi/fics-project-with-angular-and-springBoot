package com.byhi.fics.service;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;

public interface ModulService {

	Modul findById(Long long1);

	void deleteModul(Long long1);

	void updateModul(Modul modul, Rendszer findById);

	void addModul(Modul modul, Rendszer findById);

}
