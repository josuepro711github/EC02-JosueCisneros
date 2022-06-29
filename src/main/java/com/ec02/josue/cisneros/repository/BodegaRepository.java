package com.ec02.josue.cisneros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec02.josue.cisneros.entity.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long>{
	
}
