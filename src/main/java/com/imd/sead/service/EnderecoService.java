package com.imd.sead.service;

import org.springframework.stereotype.Service;

import com.imd.sead.model.Endereco;
import com.imd.sead.repository.EnderecoRepository;
import com.imd.sead.service.generic.AbstractBaseEntityService;

@Service
public class EnderecoService extends AbstractBaseEntityService<Endereco, EnderecoRepository>{
	public EnderecoService(EnderecoRepository repository) {
		super(repository);
		
	}

}
