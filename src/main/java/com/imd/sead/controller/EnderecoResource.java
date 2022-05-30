package com.imd.sead.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.imd.sead.model.Endereco;
import com.imd.sead.model.PessoaFisica;
import com.imd.sead.model.PessoaJuridica;
import com.imd.sead.service.EnderecoService;
import com.imd.sead.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

	@Autowired
	EnderecoService service;

	/*EndPoint: Cadastrar PessoaJuridica*/
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Endereco obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	
	/*EndPoint: buscar PessoaJuridica*/
	@GetMapping(value = "/{id}")
	public Endereco find(@PathVariable Long id){
	//obj.setId(id);
		
		Optional<Endereco> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
		
				
	}
	
	/*EndPoint: Buscar todos Endereco*/
	@GetMapping
	public ResponseEntity<List<Endereco>> listar(){
		List<Endereco> endereco = service.findAll();
		if(!endereco.isEmpty()){
			return new ResponseEntity<List<Endereco>>(endereco, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*EndPoint: Deletar PessoaJuridica*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco objIn){
							
		objIn.setId(id);
		return service.findById(id)	
				.map(record -> {
					service.saveAndFlush(objIn);
					return ResponseEntity.ok(objIn);
				}).orElse(ResponseEntity.notFound().build());
	
	
	}
}
