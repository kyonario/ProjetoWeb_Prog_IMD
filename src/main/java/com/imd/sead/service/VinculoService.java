package com.imd.sead.service;

import org.springframework.stereotype.Service;

import com.imd.sead.model.Vinculo;
import com.imd.sead.repository.VinculoRepository;
import com.imd.sead.service.generic.AbstractBaseEntityService;


@Service
public class VinculoService extends AbstractBaseEntityService<Vinculo, VinculoRepository>{
	public VinculoService(VinculoRepository repository) {
		super(repository);
		
	}

}
