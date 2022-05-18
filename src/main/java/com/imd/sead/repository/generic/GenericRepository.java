package com.imd.sead.repository.generic;


import org.springframework.data.jpa.repository.JpaRepository;

import com.imd.sead.model.generic.BaseEntity;

public interface GenericRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

}
