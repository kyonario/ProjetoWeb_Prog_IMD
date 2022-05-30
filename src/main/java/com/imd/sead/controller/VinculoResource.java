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

import com.imd.sead.model.Vinculo;
import com.imd.sead.service.VinculoService;
import com.imd.sead.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/vinculo")
public class VinculoResource {

	@Autowired
	VinculoService service;

	/*EndPoint: Cadastrar Vinculo*/
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Vinculo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	/*EndPoint: buscar Vinculo*/
	@GetMapping(value = "/{id}")
	public Vinculo find(@PathVariable Long id){
	//obj.setId(id);
		
		Optional<Vinculo> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vinculo.class.getName()));

	}

	/*EndPoint: Buscar todos Vinculo*/
	@GetMapping
	public ResponseEntity<List<Vinculo>> listar(){
		List<Vinculo> vinculo = service.findAll();
		if(!vinculo.isEmpty()){
			return new ResponseEntity<List<Vinculo>>(vinculo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*EndPoint: Deletar Vinculo*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*EndPoint: Atualizar Vinculo*/
	@PutMapping(value = "/{id}")
	public ResponseEntity<Vinculo> update(@PathVariable Long id, @RequestBody Vinculo objIn){
							
		objIn.setId(id);
		return service.findById(id)	
				.map(record -> {
					service.saveAndFlush(objIn);
					return ResponseEntity.ok(objIn);
				}).orElse(ResponseEntity.notFound().build());
		
		
	}
}