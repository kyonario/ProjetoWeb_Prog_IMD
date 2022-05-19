package com.imd.sead.repository.generic;


import org.springframework.data.jpa.repository.JpaRepository;

import com.imd.sead.model.generic.AbstractBaseEntity;

public interface GenericRepository<E extends AbstractBaseEntity> extends JpaRepository<E, Long> {

}
