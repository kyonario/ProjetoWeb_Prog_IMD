package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "SITUACAO_FUNCIONAMENTO")
    private Boolean situacaoFuncionamento;
    @OneToOne
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "PESSOA_JURIDICA_VINCULO",
    		joinColumns = @JoinColumn(name  = "ID_PESSOA_JURIDICA"),
    		inverseJoinColumns = @JoinColumn(name = "ID_VINCULO"))
    private List<Vinculo> vinculoPessoaJuridica = new ArrayList<Vinculo>();
    
    
    public PessoaJuridica(String nome, String email, String cnpj, Boolean situacaoFuncionamento) {
		super(nome, email);
		this.cnpj = cnpj;
		this.situacaoFuncionamento = situacaoFuncionamento;
	}
	
//    @Override
//	public String toString() {
//		return "PessoaJuridica [id=" + id + "]";
//	}

	
    
    

}