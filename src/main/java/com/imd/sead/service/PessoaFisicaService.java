package com.imd.sead.service;

import org.springframework.stereotype.Service;

import com.imd.sead.model.PessoaFisica;
import com.imd.sead.repository.PessoaFisicaRepository;
import com.imd.sead.service.generic.AbstractBaseEntityService;

@Service
public class PessoaFisicaService extends AbstractBaseEntityService<PessoaFisica, PessoaFisicaRepository>{
	public PessoaFisicaService(PessoaFisicaRepository repository) {
		super(repository);
		
	}
	
	 public PessoaFisica saveAndFlush(PessoaFisica c){
	        return repository.saveAndFlush(c);
	    }

}
