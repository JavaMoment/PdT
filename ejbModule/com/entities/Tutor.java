package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Roles;


/**
 * The persistent class for the TUTORES database table.
 * 
 */
@Entity
@Table(name="TUTORES")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TUTORES_IDTUTOR_GENERATOR", sequenceName="tutores_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TUTORES_IDTUTOR_GENERATOR")
	@Column(name="ID_TUTOR", unique=true, nullable=false, precision=38)
	private Long idTutor;

	@ManyToOne
	@JoinColumn(name="ID_AREA", nullable=false)
	private Area area;

	@Column(name="tipo", nullable=false, length=75)
	@Enumerated(EnumType.STRING)
	private Roles rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="NOMBRE_USUARIO", nullable=false)
	private Usuario usuario;

	public Tutor() {
	}
	
	public Tutor(Usuario user, Area area, Roles rol) {
		this.usuario = user;
		this.area = area;
		this.rol = rol;
	}

	public long getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}

	public Area getIdArea() {
		return area;
	}

	public void setIdArea(Area idArea) {
		this.area = idArea;
	}

	public Roles getTipo() {
		return this.rol;
	}

	public void setTipo(Roles tipo) {
		this.rol = tipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return usuario.getNombre1();
	}

}