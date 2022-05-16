package com.imd.sead.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "VINCULO")
@NoArgsConstructor
@AllArgsConstructor
public class Vinculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
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
}
