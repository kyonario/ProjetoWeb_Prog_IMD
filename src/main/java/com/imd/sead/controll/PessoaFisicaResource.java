package com.imd.sead.controll;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imd.sead.model.PessoaFisica;
import com.imd.sead.service.PessoaFisicaService;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaResource {

	@Autowired
	PessoaFisicaService pessoafisicaservice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody PessoaFisica obj) {
		obj = pessoafisicaservice.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody PessoaFisica obj, @PathVariable Long id){
		//obj.setId(id);
		pessoafisicaservice.update(id, obj);
		
		return pessoafisicaservice.(obj);
		
	}
	
	
	
}
