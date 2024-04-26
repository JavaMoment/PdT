package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STATUS_RECLAMO")
public class StatusReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_STATUS")
	private long idStatus;
	
	@Column(name="NOMBRE", unique=true)
	private String nombre;
	
	@OneToMany(mappedBy="statusReclamo", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Reclamo> reclamos;

	public long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
	@Override
	public boolean equals(Object other) {
		StatusReclamo otherSR = (StatusReclamo) other;
	    return this.getNombre().equals(otherSR.getNombre());
	}
}
