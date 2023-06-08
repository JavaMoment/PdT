package com.entities;

import java.io.Serializable;
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
	@SequenceGenerator(name="ANALISTAS_IDANALISTA_GENERATOR", sequenceName="ANALISTAS_ID_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALISTAS_IDANALISTA_GENERATOR")
	@Column(name="ID_ANALISTA", unique=true, nullable=false, precision=38)
	private Long idAnalista;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="NOMBRE_USUARIO", nullable=false)
	private Usuario usuario;

	public Analista() {
	}

	public long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}