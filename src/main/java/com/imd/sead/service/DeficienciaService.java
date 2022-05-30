package com.imd.sead.service;

import org.springframework.stereotype.Service;

import com.imd.sead.model.Deficiencia;
import com.imd.sead.repository.DeficienciaRepository;
import com.imd.sead.service.generic.AbstractBaseEntityService;

@Service
public class DeficienciaService extends AbstractBaseEntityService<Deficiencia, DeficienciaRepository>{
	public DeficienciaService(DeficienciaRepository repository) {
		super(repository);
		
	}

}