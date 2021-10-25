package com.caroline.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caroline.petshop.domain.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer>{
	
	

}
