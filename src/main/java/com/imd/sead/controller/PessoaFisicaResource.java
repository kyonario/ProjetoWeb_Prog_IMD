package com.imd.sead.controller;

import java.net.URI;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imd.sead.model.PessoaFisica;
import com.imd.sead.service.PessoaFisicaService;
import com.imd.sead.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaResource {

	@Autowired
	PessoaFisicaService pessoafisicaservice;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody PessoaFisica obj) {
		obj = pessoafisicaservice.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	
	@GetMapping(value = "/{id}")
	public PessoaFisica find(@PathVariable Long id){
	//obj.setId(id);
		
		Optional<PessoaFisica> obj = pessoafisicaservice.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PessoaFisica.class.getName()));
		
				
	}
	
	
	
}
