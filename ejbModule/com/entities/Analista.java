package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ANALISTAS database table.
 * 
 */
@Entity
@Table(name="ANALISTAS")
public class Analista implements Serializable {
	private static final long serialVersionUID = 1L; //Se utiliza para proporcionar un número de versión para la representación serializada de la clase Analista.

	@Id
	@SequenceGenerator(name="ANALISTAS_IDANALISTA_GENERATOR", sequenceName="analistas_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALISTAS_IDANALISTA_GENERATOR")
	@Column(name="ID_ANALISTA", unique=true, nullable=false, precision=38)
	private Long idAnalista;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="NOMBRE_USUARIO", nullable=false)
	private Usuario usuario;

	@OneToMany(mappedBy="analista", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Reclamo> reclamos;
	
	public Analista() {
	}
	
	public Analista(Usuario user) {
		this.usuario = user;
	}

	public Long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(Long idAnalista) {
		this.idAnalista = idAnalista;
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