package com.imd.sead.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import com.imd.sead.model.generic.AbstractBaseEntity;
import com.imd.sead.model.PessoaJuridica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "VINCULO")
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Vinculo extends AbstractBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "MATRICULA")
	private String matricula;
	@Column(name = "DATA_NOMEACAO")
	private Date dataNomeacao;
	@Column(name = "DATA_POSSE")
	private Date dataPosse;
	@Column(name = "SALARIO_BASE")
	private Double salarioBase;
	@Column(name = "TOTAL_HORAS_TRABALHADAS")
	private Integer totalHorasTrabalhadas;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PESSOA_FISICA")
	private PessoaFisica pessoaFisicaVinculo;
	
	@OneToOne
	@JoinColumn(name="ID_PESSOA_JURIDICA")
	private PessoaJuridica pessoaJuridica;

}