package com.imd.sead.service.generic;

import java.util.List;
import java.util.Optional;

import com.imd.sead.model.generic.AbstractBaseEntity;
import com.imd.sead.repository.generic.GenericRepository;

public abstract class AbstractBaseEntityService<E extends AbstractBaseEntity, R extends GenericRepository<E>>
		implements GenericService<E> {
	protected final R repository;

	public AbstractBaseEntityService(R repository) {
        this.repository = repository;
    }

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public E create(E entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<E> update(Long id, E entity) {
		entity.setId(id);
		return repository.findById(id).map(record -> {
			//E update = repository.save(entity);
			E update = repository.saveAndFlush(entity);	
			return update;
		});
	}

	@Override
	public Boolean delete(Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return true;
		}).orElse(false);
	}

}
