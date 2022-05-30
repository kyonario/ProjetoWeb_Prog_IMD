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

import com.imd.sead.model.Deficiencia;
import com.imd.sead.service.DeficienciaService;
import com.imd.sead.service.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("/deficiencia")
public class DeficienciaResource {

	@Autowired
	DeficienciaService service;

	/* EndPoint: Cadastrar Vinculo */
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Deficiencia obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* EndPoint: buscar Deficiencia */
	@GetMapping(value = "/{id}")
	public Deficiencia find(@PathVariable Long id) {
		// obj.setId(id);

		Optional<Deficiencia> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Deficiencia.class.getName()));

	}

	/* EndPoint: Buscar todos Vinculo */
	@GetMapping
	public ResponseEntity<List<Deficiencia>> listar() {
		List<Deficiencia> vinculo = service.findAll();
		if (!vinculo.isEmpty()) {
			return new ResponseEntity<List<Deficiencia>>(vinculo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/* EndPoint: Deletar Vinculo */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	/* EndPoint: Atualizar Vinculo */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Deficiencia> update(@PathVariable Long id, @RequestBody Deficiencia objIn) {
		objIn.setId(id);
		return service.findById(id).map(record -> {
			service.saveAndFlush(objIn);
			return ResponseEntity.ok(objIn);
		}).orElse(ResponseEntity.notFound().build());

	}
}