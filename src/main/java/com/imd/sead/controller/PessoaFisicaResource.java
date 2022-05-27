package com.imd.sead.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	PessoaFisicaService service;

	/*EndPoint: Cadastrar PessoaFisica*/
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody PessoaFisica obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	
	/*EndPoint: buscar pessoa fisica*/
	@GetMapping(value = "/{id}")
	public PessoaFisica find(@PathVariable Long id){
	//obj.setId(id);
		
		Optional<PessoaFisica> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PessoaFisica.class.getName()));
		
				
	}
	
	/*EndPoint: Deletar pessoa fisica*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*EndPoint: Atualizar pessoa fisica*/
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaFisica> update(@PathVariable Long id, @RequestBody PessoaFisica objIn){
							
//		Optional<PessoaFisica> objUpdate = service.update(id, objIn);
		return service.findById(id)	
				.map(record -> {
					service.saveAndFlush(objIn);
					return ResponseEntity.ok(objIn);
				}).orElse(ResponseEntity.notFound().build());
		
//		return ResponseEntity.ok().body(objUpdate);
		
	}
	
	
}
