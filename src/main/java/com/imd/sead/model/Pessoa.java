package com.imd.sead.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import com.imd.sead.model.generic.AbstractBaseEntity;

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
public class Pessoa extends AbstractBaseEntity implements Serializable{

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=1, max=50, message="O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name = "NOME", length = 50, nullable = false)
    String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Column(name = "EMAIL", length = 50, nullable = false)
    String email;
}