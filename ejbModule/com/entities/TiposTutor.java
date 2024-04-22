package com.entities;

import java.io.Serializable;
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
	private long idTipoTutor;

	@Column(nullable=false, length=100)
	private String nombre;

	public TiposTutor() {
	}

	public long getIdTipoTutor() {
		return this.idTipoTutor;
	}

	public void setIdTipoTutor(long idTipoTutor) {
		this.idTipoTutor = idTipoTutor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}