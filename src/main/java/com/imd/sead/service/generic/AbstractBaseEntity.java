package com.imd.sead.service.generic;

import com.imd.sead.model.generic.BaseEntity;
import com.imd.sead.repository.generic.GenericRepository;

public abstract class AbstractBaseEntity<E extends BaseEntity, R extends GenericRepository<E>> implements GenericService<E>{

}
