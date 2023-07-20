package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ESTUDIANTE_EVENTO database table.
 * 
 */
@Embeddable
public class EstudianteEventoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ESTUDIANTE", insertable=true, updatable=true)
	private int idEstudiante;

	@Column(name="ID_EVENTO", insertable=true, updatable=true)
	private int idEvento;

	public EstudianteEventoPK() {
	}

	public EstudianteEventoPK(long idEstudiante2, long idEvento2) {
		// TODO Auto-generated constructor stub
	}

	public long getIdEstudiante() {
		return this.idEstudiante;
	}
	
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public long getIdEvento() {
		return this.idEvento;
	}
	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstudianteEventoPK)) {
			return false;
		}
		EstudianteEventoPK castOther = (EstudianteEventoPK)other;
		return 
			(this.idEstudiante == castOther.idEstudiante)
			&& (this.idEvento == castOther.idEvento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idEstudiante ^ (this.idEstudiante >>> 32)));
		hash = hash * prime + ((int) (this.idEvento ^ (this.idEvento >>> 32)));
		
		return hash;
	}
	
	
}