package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TUTOR_EVENTO database table.
 * 
 */
@Embeddable
public class TutorEventoPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

//	@Column(name = "ID_TUTOR", insertable = false, updatable = false)
//	private long idTutor;
//
//	@Column(name = "ID_EVENTO", insertable = false, updatable = false)
//	private long idEvento;
	@Column(name = "ID_TUTOR")
	private long idTutor;

	@Column(name = "ID_EVENTO")
	private long idEvento;

	public TutorEventoPK() {
	}

	public TutorEventoPK(long idTutor, long idEvento) {
		super();
		this.idTutor = idTutor;
		this.idEvento = idEvento;
	}

	public long getIdTutor() {
		return this.idTutor;
	}

	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
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
		if (!(other instanceof TutorEventoPK)) {
			return false;
		}
		TutorEventoPK castOther = (TutorEventoPK) other;
		return (this.idTutor == castOther.idTutor) && (this.idEvento == castOther.idEvento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idTutor ^ (this.idTutor >>> 32)));
		hash = hash * prime + ((int) (this.idEvento ^ (this.idEvento >>> 32)));

		return hash;
	}

	@Override
	public String toString() {
		return "TutorEventoPK [idTutor=" + idTutor + ", idEvento=" + idEvento + "]";
	}
	
	
}