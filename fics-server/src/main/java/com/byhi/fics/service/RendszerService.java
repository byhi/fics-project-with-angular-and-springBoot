package com.byhi.fics.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.byhi.fics.domain.Rendszer;
@Service
public interface RendszerService {
	Collection<Rendszer> findAll();
}
