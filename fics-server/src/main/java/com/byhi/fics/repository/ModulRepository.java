package com.byhi.fics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.byhi.fics.domain.Modul;

@Repository
public interface ModulRepository extends CrudRepository<Modul, Long>, JpaRepository<Modul, Long> {
	Optional<Modul> findById(Long id);
}
