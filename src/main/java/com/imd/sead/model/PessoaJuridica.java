package com.imd.sead.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "PESSOA_JURIDICA")
@NoArgsConstructor
public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "SITUACAO_FUNCIONAMENTO")
    private Boolean situacaoFuncionamento;
    
    public PessoaJuridica(Integer id, String nome, String email, String cnpj, Boolean situacaoFuncionamento) {
		super(nome, email);
		this.id = id;
		this.cnpj = cnpj;
		this.situacaoFuncionamento = situacaoFuncionamento;
	}
	
    @Override
	public String toString() {
		return "PessoaJuridica [id=" + id + "]";
	}

	
    
    

}