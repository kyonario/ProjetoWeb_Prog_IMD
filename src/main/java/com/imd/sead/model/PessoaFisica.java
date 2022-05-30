package com.imd.sead.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PESSOA_FISICA")
@NoArgsConstructor
@Audited
@JsonIgnoreProperties(value={ "pessoaEnd", "pessoaDefi" }, allowGetters= true)
public class PessoaFisica extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

       
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    @Column(name = "NOME_MAE")
    private String nomeMae;
    @Column(name = "NOME_PAI")
    private String nomePai;
    
    
//    @JsonProperty("pessoaEnd")
//    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "PESSOA_FISICA_ENDERECO", 
    		joinColumns = @JoinColumn(name="ID_PESSOA_FISICA"),
    		inverseJoinColumns =  @JoinColumn(name = "ID_ENDERECO"))
    private List<Endereco> enderecoPessoaFisicaList;
    
//    @JsonProperty("pessoaDefi")	
    @ManyToMany(cascade = CascadeType.ALL) //With Endereco
    @JoinTable(
    		name = "PESSOA_FISICA_DEFICIENCIA", 
    		joinColumns = @JoinColumn(name="ID_PESSOA_FISICA"),
    		inverseJoinColumns =  @JoinColumn(name = "ID_DEFICIENCIA"))
    private List<Deficiencia> deficienciaPessoaFisicaList;
    @JsonIgnore
    @OneToMany(mappedBy="pf", cascade=CascadeType.ALL)
    private Set<Vinculo> vinculos;
     
    
    public PessoaFisica(String nome, String email, String cpf, String rg, Date dataNascimento, String nomeMae,
			String nomePai) {
		super(nome, email);
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
	}
	
    
    @Override
	public String toString() {
		return "PessoaFisica [id=" + id + "]";
	}
	
	
	
}