package com.imd.sead.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;

import com.imd.sead.model.generic.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Audited
@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends BaseEntity {

    @Column(name = "NOME", length = 50, nullable = false)
    String nome;
    @Column(name = "EMAIL", length = 50, nullable = false)
    String email;
}