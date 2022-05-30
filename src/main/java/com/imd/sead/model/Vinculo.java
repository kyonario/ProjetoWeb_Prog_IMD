package com.imd.sead.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imd.sead.model.generic.AbstractBaseEntity;

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
	@ManyToOne
	@JoinColumn(name="ID_PESSOA_FISICA")
	private PessoaFisica pf;
	@ManyToOne
	@JoinColumn(name="ID_PESSOA_JURIDICA")
	private PessoaJuridica pj;
	
	
	public Vinculo(String matricula, Date dataNomeacao, Date dataPosse, Double salarioBase,
			Integer totalHorasTrabalhadas) {
		super();
		this.matricula = matricula;
		this.dataNomeacao = dataNomeacao;
		this.dataPosse = dataPosse;
		this.salarioBase = salarioBase;
		this.totalHorasTrabalhadas = totalHorasTrabalhadas;
	}
	
	

}