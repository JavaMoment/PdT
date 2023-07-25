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
	private long idEstudiante;

	@Column(name="ID_EVENTO", insertable=true, updatable=true)
	private long idEvento;

	public EstudianteEventoPK() {
	}

	public long getIdEstudiante() {
		return this.idEstudiante;
	}
	
	public void setIdEstudiante(long idEstudiante2) {
		this.idEstudiante = idEstudiante2;
	}
	
	public long getIdEvento() {
		return this.idEvento;
	}
	
	public void setIdEvento(long idEvento) {
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