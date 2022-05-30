package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imd.sead.model.generic.AbstractBaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DEFICIENCIA")
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Deficiencia extends AbstractBaseEntity implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "TIPO_DEFICIENCIA")
	private String tipoDeficiencia;
	@Column(name = "LAUDO_MEDICO")
	private String laudoMedico;
	@JsonIgnore
	@ManyToMany(mappedBy = "deficienciaPessoaFisicaList")
    private List<PessoaFisica> pessoaFisicaList = new ArrayList<PessoaFisica>();
	
	
	@Override
	public String toString() {
		return "Deficiencia [id=" + id + "]";
	}
	

}
