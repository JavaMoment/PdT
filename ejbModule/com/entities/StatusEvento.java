package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the STATUS_EVENTO database table.
 * 
 */
@Entity
@Table(name="STATUS_EVENTO")
@NamedQuery(name="StatusEvento.findAll", query="SELECT s FROM StatusEvento s")
public class StatusEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STATUS", unique=true, nullable=false, precision=38)
	private Long idStatus;

	@Column(nullable=false, precision=1)
	private Byte activo;

	@Column(nullable=false, length=100)
	private String nombre;
	
	@OneToMany(mappedBy="statusEvento", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Evento> eventos; 

	public StatusEvento() {
	
	}
	
	public StatusEvento(String name) {
		this.nombre = name;
		this.activo = (byte) 1;
	}

	public Long getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public Boolean getActivo() {
		return activo == 1;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo ? (byte) 1 : (byte) 0;
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
	    StatusEvento other = (StatusEvento) obj; 
		if (!nombre.equals(other.getNombre()))
	        return false;
	    return true;
	}

}