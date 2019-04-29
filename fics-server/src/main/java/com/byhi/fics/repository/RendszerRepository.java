package com.byhi.fics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.byhi.fics.domain.Rendszer;

@Repository
public interface RendszerRepository extends CrudRepository<Rendszer, Long>, JpaRepository<Rendszer, Long> {
	 
}
