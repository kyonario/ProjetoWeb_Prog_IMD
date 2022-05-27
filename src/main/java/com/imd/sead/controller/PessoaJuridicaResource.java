package com.imd.sead.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.imd.sead.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.imd.sead.model.PessoaJuridica;
import com.imd.sead.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/pj")
public class PessoaJuridicaResource {

	@Autowired
	PessoaJuridicaService service;

	/*EndPoint: Cadastrar PessoaJuridica*/
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody PessoaJuridica obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	/*EndPoint: buscar PessoaJuridica*/
	@GetMapping(value = "/{id}")
	public PessoaJuridica find(@PathVariable Long id){
	//obj.setId(id);
		
		Optional<PessoaJuridica> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PessoaJuridica.class.getName()));

	}

	/*EndPoint: Buscar todos PessoaJuridica*/
	@GetMapping
	public ResponseEntity<List<PessoaJuridica>> listar(){
		List<PessoaJuridica> pessoaJuridicas = service.findAll();
		if(!pessoaJuridicas.isEmpty()){
			return new ResponseEntity<List<PessoaJuridica>>(pessoaJuridicas, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*EndPoint: Deletar PessoaJuridica*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*EndPoint: Atualizar PessoaJuridica*/
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaJuridica> update(@PathVariable Long id, @RequestBody PessoaJuridica objIn){
							
//		Optional<PessoaJuridica> objUpdate = service.update(id, objIn);
//		
//		return ResponseEntity.ok().body(objUpdate);	
		return service.findById(id)	
				.map(record -> {
					service.saveAndFlush(objIn);
					return ResponseEntity.ok(objIn);
				}).orElse(ResponseEntity.notFound().build());
		
		
	}
	
	
}
