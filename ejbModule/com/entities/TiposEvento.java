package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the TIPOS_EVENTO database table.
 * 
 */
@Entity
@Table(name="TIPOS_EVENTO")
@NamedQuery(name="TiposEvento.findAll", query="SELECT t FROM TiposEvento t")
public class TiposEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_EVENTO", unique=true, nullable=false, precision=38)
	private long idTipoEvento;

	@Column(name = "NOMBRE", nullable=false, length=100)
	private String nombre;

	@OneToMany(mappedBy="tiposEvento", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Evento> eventos;
	
	public TiposEvento() {
	}

	public long getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}