package com.imd.sead.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PESSOA")
@NoArgsConstructor
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "EMAIL")
	private String email;	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private PessoaFisica pessoaFisica;
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private PessoaJuridica pessoaJuridica;
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + "]";
	}
	
	
}