package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.imd.sead.model.generic.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "ENDERECO")
@Audited
@AuditTable(value = "ENDERECO_AUDIT")
public class Endereco extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "UF")
    private String uf;
    @ManyToMany(mappedBy = "enderecoPessoaList")
    private List<PessoaFisica> pessoaFisicaList = new ArrayList<PessoaFisica>();
    @OneToOne(mappedBy = "endereco")
    private PessoaJuridica pessoaJuridica;
    
//	@Override
//	public String toString() {
//		return "Endereco [id=" + id + "]";
//	}
	
}
