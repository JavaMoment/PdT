package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ESTUDIANTE_EVENTO database table.
 * 
 */
@Entity
@Table(name="ESTUDIANTE_EVENTO")
@NamedQuery(name="EstudianteEvento.findAll", query="SELECT e FROM EstudianteEvento e")
public class EstudianteEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstudianteEventoPK id;

	@Column(name="ASISTENCIA")
	private String asistencia;

	@Column(name="CALIFICACION")
	private int calificacion;

	public EstudianteEvento() {
	}

	public EstudianteEventoPK getId() {
		return this.id;
	}

	public void setId(EstudianteEventoPK id) {
		this.id = id;
	}

	public String getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public int getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}