package com.imd.sead.service;

import org.springframework.stereotype.Service;

import com.imd.sead.model.PessoaFisica;
import com.imd.sead.repository.PessoaFisicaRepository;
import com.imd.sead.service.generic.AbstractBaseEntity;

@Service
public class PessoaFisicaService extends AbstractBaseEntity<PessoaFisica, PessoaFisicaRepository>{
	public PessoaFisicaService(PessoaFisicaRepository repository) {
		super(repository);
		
	}

}
