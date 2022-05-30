package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Audited
@AuditTable(value = "PESSOA_JURIDICA_AUDIT")
@Table(name = "PESSOA_JURIDICA")
@NoArgsConstructor
public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "SITUACAO_FUNCIONAMENTO")
    private Boolean situacaoFuncionamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "pj", cascade = CascadeType.ALL)
    private Set<Vinculo> vinculos;
    

    public PessoaJuridica(String nome, String email, String cnpj, Boolean situacaoFuncionamento) {
        super(nome, email);
        this.cnpj = cnpj;
        this.situacaoFuncionamento = situacaoFuncionamento;
    }
    
    // Para Quando quisermos acessar as pessoas físicas com matricula em uma pessoa juridica
    public List<PessoaFisica> Getvinculos(){
    	List<PessoaFisica> lista = new ArrayList<>();
    	for (Vinculo x : vinculos) {
    		lista.add(x.getPf());
    	}
    	return lista;
    }

//    @Override
// public String toString() {
//    return "PessoaJuridica [id=" + id + "]";
// }





}