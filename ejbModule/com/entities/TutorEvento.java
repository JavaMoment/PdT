package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TUTOR_EVENTO database table.
 * 
 */
@Entity
@Table(name="TUTOR_EVENTO")
@NamedQuery(name="TutorEvento.findAll", query="SELECT t FROM TutorEvento t")
public class TutorEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TutorEventoPK id;

	public TutorEvento(TutorEventoPK id) {
		super();
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_EVENTO", insertable = false, updatable = false)
	private Evento evento;

	public TutorEvento() {
	}

	public TutorEventoPK getId() {
		return this.id;
	}

	public void setId(TutorEventoPK id) {
		this.id = id;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "TutorEvento [id=" + id + ", evento=" + evento + "]";
	}

}