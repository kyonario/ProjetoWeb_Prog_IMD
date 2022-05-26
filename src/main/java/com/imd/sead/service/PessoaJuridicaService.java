package com.imd.sead.service;


import org.springframework.stereotype.Service;

import com.imd.sead.model.PessoaJuridica;
import com.imd.sead.repository.PessoaJuridicaRepository;
import com.imd.sead.service.generic.AbstractBaseEntityService;

@Service
public class PessoaJuridicaService extends AbstractBaseEntityService<PessoaJuridica, PessoaJuridicaRepository>{
	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
		super(repository);
		
	}

}