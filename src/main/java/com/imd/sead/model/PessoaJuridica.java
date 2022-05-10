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
@AllArgsConstructor
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "RAZAO_SOCIAL")
    private String razao_social;
    @Column(name = "ORGAO_RG")
    private String orgaoRg;
    @Column(name = "DATA_ABERTURA")
    private Date dataAbertura;
    @Column(name = "SITUACAO_FUNCIONAMENTO")
    private Boolean situacaoFuncionamento;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pessoa pessoa;
	
    @Override
	public String toString() {
		return "PessoaJuridica [id=" + id + "]";
	}
    
    

}