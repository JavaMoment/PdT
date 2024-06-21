package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Immutable;


/**
 * The persistent class for the RECLAMOS_COUNT_BY_ESTUDIANTE database table.
 * 
 */
@Entity
@Table(name="RECLAMOS_COUNT_BY_ESTUDIANTE")
@NamedQuery(name="ReclamosCountByEstudiante.findAll", query="SELECT r FROM ReclamosCountByEstudiante r")
@Immutable
public class ReclamosCountByEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ANIO")
	private String anio;

	@Column(name="CANT_RECLAMOS")
	private Integer cantReclamos;

	@Column(name="FECHA_CREACION")
	private String fechaCreacion;

	@Id
	@Column(name="ID_ESTUDIANTE")
	private Long idEstudiante;

	@Column(name="MES")
	private String mes;

	public String getAnio() {
		return this.anio;
	}

	public Integer getCantReclamos() {
		return this.cantReclamos;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public Long getIdEstudiante() {
		return this.idEstudiante;
	}

	public String getMes() {
		return this.mes;
	}

	@Override
	public String toString() {
		return "ReclamosCountByEstudiante [" + (anio != null ? "anio=" + anio + ", " : "")
				+ (cantReclamos != null ? "cantReclamos=" + cantReclamos + ", " : "")
				+ (fechaCreacion != null ? "fechaCreacion=" + fechaCreacion + ", " : "")
				+ (idEstudiante != null ? "idEstudiante=" + idEstudiante + ", " : "")
				+ (mes != null ? "mes=" + mes : "") + "]";
	}

}