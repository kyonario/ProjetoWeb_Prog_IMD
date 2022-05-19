package com.imd.sead.service.generic;

import java.util.List;
import java.util.Optional;

import com.imd.sead.model.generic.AbstractBaseEntity;

public interface GenericService <E extends AbstractBaseEntity>{
	List<E> findAll();
	E create(E entity);
	Optional<E> findById(Long id);
	Optional<E> update(Long id, E entity);
	Boolean delete(Long id);
}
