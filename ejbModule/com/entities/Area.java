package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AREAS database table.
 * 
 */
@Entity
@Table(name="AREAS")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREAS_IDAREA_GENERATOR", sequenceName="AREAS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREAS_IDAREA_GENERATOR")
	@Column(name="ID_AREA")
	private Long idArea;

	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;

	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	public Area() {
	}

	public Long getIdArea() {
		return this.idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre != null ? this.nombre : "";
	}

	@Override
	public boolean equals(Object obj) {
	    Area other = (Area) obj; 
		if (!nombre.equals(other.getNombre()))
	        return false;
	    return true;
	}
}