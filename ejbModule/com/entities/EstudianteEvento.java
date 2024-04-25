package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

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

	@ManyToOne
	@JoinColumn(name="id_asistencia", nullable=false)
	private Asistencia asistencia;

	@Column(name="CALIFICACION", nullable=true, precision=3, scale=2)
	private BigDecimal calificacion;
	
	@Transient
	private String nombreUsuario;

	public EstudianteEvento() {
	}

	public EstudianteEventoPK getId() {
		return this.id;
	}

	public void setId(EstudianteEventoPK id) {
		this.id = id;
	}

	public Asistencia getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}
	
	public long getIdEstudiante() {
		return this.id.getIdEstudiante(); 
	}
	
	public long getIdEvento() {
		return  this.id.getIdEvento();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public String toString() {
		return "EstudianteEvento [" + (asistencia != null ? "asistencia=" + asistencia + ", " : "") + "calificacion="
				+ calificacion + "]";
	}

}