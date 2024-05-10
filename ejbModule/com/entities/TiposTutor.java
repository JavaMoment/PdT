package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the TIPOS_TUTOR database table.
 * 
 */
@Entity
@Table(name="TIPOS_TUTOR")
@NamedQuery(name="TiposTutor.findAll", query="SELECT t FROM TiposTutor t")
public class TiposTutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_TUTOR", unique=true, nullable=false, precision=38)
	private Long idTipoTutor;

	@Column(nullable=false, length=100)
	private String nombre;
	
	@OneToMany(mappedBy="rol", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Tutor> tutores;

	public TiposTutor() {
	}

	public Long getIdTipoTutor() {
		return this.idTipoTutor;
	}

	public void setIdTipoTutor(Long idTipoTutor) {
		this.idTipoTutor = idTipoTutor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	@Override
	public String toString() {
		return (nombre != null ? nombre : "");
	}
	
	@Override
	public boolean equals(Object obj) {
	    TiposTutor other = (TiposTutor) obj; 
		if (!nombre.equals(other.getNombre()))
	        return false;
	    return true;
	}

}