package com.models;

import java.io.Serializable;

public class SemestreCount implements Serializable {
	private static final long serialVersionUID = 13922419318740660L;
	
	private Integer semestre;
	private Integer cantEventos;

	public SemestreCount(Integer semestre, Integer cantEventos) {
		super();
		this.semestre = semestre;
		this.cantEventos = cantEventos;
	}
	
	public SemestreCount(Integer semestre, Long cantEventos) {
		super();
		this.semestre = semestre;
		this.cantEventos = cantEventos.intValue();
	}
	
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getCantEventos() {
		return cantEventos;
	}
	public void setCantEventos(Integer cantEventos) {
		this.cantEventos = cantEventos;
	}

	@Override
	public String toString() {
		return "SemestreCount [" + (semestre != null ? "semestre=" + semestre + ", " : "")
				+ (cantEventos != null ? "cantEventos=" + cantEventos : "") + "]";
	}
}
