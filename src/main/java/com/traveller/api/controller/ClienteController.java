package com.traveller.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.api.model.Cliente;
import com.traveller.api.repository.ClienteRepository;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Cliente adicionar(@RequestBody Cliente cliente) {
			return clienteRepository.save(cliente);
	}	

	@PostMapping(value="/localizar")
	private Cliente loaclizaCliente(@RequestBody Cliente cliente) {
		 Cliente res = clienteRepository.findByEmail(cliente.getEmail());
		 
		 if(res.senha.equals(cliente.getSenha())) {
			 return res;
		 }
		 return null;
	}
	
	@PutMapping
	private Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);		
	}
	
	@DeleteMapping
	private void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.deleteById(cliente.getId());
	}
}
