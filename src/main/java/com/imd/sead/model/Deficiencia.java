package com.imd.sead.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class Deficiencia implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "ID")
	private Integer id;
	@Column(name = "TIPO_DEFICIENCIA")
	private String tipoDeficiencia;
	@Column(name = "LAUDO_MEDICO")
	private String laudoMedico;
	@ManyToOne
	@JoinColumn(name="ID_PESSOA_FISICA")
	private PessoaFisica pessoaFisica;
	
	
	@Override
	public String toString() {
		return "Deficiencia [id=" + id + "]";
	}
	

}
