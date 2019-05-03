package com.byhi.fics.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.byhi.fics.domain.Rendszer;
@Service
public interface RendszerService {
	Collection<Rendszer> findAll();

	Rendszer findById(Long long1);

	void addRendszer(Rendszer rendszer);

	void deleteRendszer(Long long1);

	void updateRendszer(Rendszer rendszer);
}
