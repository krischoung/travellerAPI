package com.traveller.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity		
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	public String nome;
	
	public String sobrenome;
	
	public Date dtNascimento;
	
	public String cpf;
	
	@Column(unique=true)
	public String email;
	
	@Column(nullable = false)
	public String senha;

	
}
