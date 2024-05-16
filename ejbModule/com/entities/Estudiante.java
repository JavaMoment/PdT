package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ESTUDIANTES database table.
 * 
 */
@Entity
@Table(name="ESTUDIANTES")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTUDIANTES_IDESTUDIANTE_GENERATOR", sequenceName="estud_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTUDIANTES_IDESTUDIANTE_GENERATOR")
	@Column(name="ID_ESTUDIANTE", unique=true, nullable=false, precision=38)
	private Long idEstudiante;

	@Column(name="GENERACION", nullable=false, length=4)
	private String generacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="NOMBRE_USUARIO", nullable=false)
	private Usuario usuario;
	
	@OneToMany(mappedBy="estudiante", fetch=FetchType.EAGER)
	private List<Reclamo> reclamos;
	
	public Estudiante() {
	}
	
	public Estudiante(Usuario user) {
		this.usuario = user;
	}
	public Estudiante(Usuario user, String generacion) {
		this.usuario = user;
		this.generacion = generacion;
	}

	public Long getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

}