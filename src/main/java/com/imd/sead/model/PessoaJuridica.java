package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    @OneToMany(mappedBy="pessoaJuridica") //bidirectional with deficiencia
    private List<Vinculo> vinculo;
    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
          name = "PESSOA_JURIDICA_VINCULO",
          joinColumns = @JoinColumn(name  = "ID_PESSOA_JURIDICA"),
          inverseJoinColumns = @JoinColumn(name = "ID_VINCULO"))
    private List<Vinculo> vinculoPessoaJuridica = new ArrayList<Vinculo>();
 */

    public PessoaJuridica(String nome, String email, String cnpj, Boolean situacaoFuncionamento) {
        super(nome, email);
        this.cnpj = cnpj;
        this.situacaoFuncionamento = situacaoFuncionamento;
    }

//    @Override
// public String toString() {
//    return "PessoaJuridica [id=" + id + "]";
// }





}