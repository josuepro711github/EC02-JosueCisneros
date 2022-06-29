package com.ec02.josue.cisneros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec02.josue.cisneros.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
}
