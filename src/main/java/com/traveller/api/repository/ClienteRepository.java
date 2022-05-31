package com.traveller.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traveller.api.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByEmail(String email);
	
}
