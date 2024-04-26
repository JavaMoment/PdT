package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ASISTENCIAS database table.
 * 
 */
@Entity
@Table(name="ASISTENCIAS")
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ASISTENCIA")
	private long idAsistencia;

	private String nombre;

	private BigDecimal valor;
	
	@OneToMany(mappedBy="asistencia", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<EstudianteEvento> estudiantesEventos;

	public Asistencia() {
	}
	
	public List<EstudianteEvento> getEstudiantesEventos() {
		return estudiantesEventos;
	}
	
	public void setEstudiantesEventos(List<EstudianteEvento> estudiantesEventos) {
		this.estudiantesEventos = estudiantesEventos;
	}

	public long getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}