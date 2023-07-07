package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.enums.Modalidad;
import com.enums.Status;
import com.enums.TipoEvento;

/**
 * The persistent class for the EVENTOS database table.
 * 
 */
@Entity
@Table(name = "EVENTOS")
@NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_ID_EVENTO", sequenceName = "SEQ_ID_EVENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_EVENTO")
	@Column(name = "ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	@ManyToOne
	@JoinColumn(name = "ID_ITR") // Nombre de la columna en la tabla "EVENTOS" que hace referencia a "ITR"
	private Itr itr;

	private String localizacion;

	@Enumerated(EnumType.STRING)
	private Modalidad modalidad;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_EVENTO")
	private TipoEvento tipoEvento;

	private String titulo;

	// bi-directional many-to-one association to TutorEvento
	@OneToMany(mappedBy = "evento", fetch = FetchType.EAGER)
	private List<TutorEvento> tutorEventos;

	public Evento() {
	}

	// Constructor con parámetros para inicializar todas las propiedades de Evento
	public Evento(String titulo, TipoEvento tipoEvento, Date fechaHoraInicio, Date fechaHoraFinal, Modalidad modalidad,
			Itr itr, String localizacion, Status status) {
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFinal = fechaHoraFinal;
		this.modalidad = modalidad;
		this.itr = itr;
		this.localizacion = localizacion;
		this.status = status;
	}

	public long getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaHoraFinal() {
		return this.fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<TutorEvento> getTutorEventos() {
		return this.tutorEventos;
	}

	public void setTutorEventos(List<TutorEvento> tutorEventos) {
		this.tutorEventos = tutorEventos;
	}

	public TutorEvento addTutorEvento(TutorEvento tutorEvento) {
		getTutorEventos().add(tutorEvento);
		tutorEvento.setEvento(this);

		return tutorEvento;
	}

	public TutorEvento removeTutorEvento(TutorEvento tutorEvento) {
		getTutorEventos().remove(tutorEvento);
		tutorEvento.setEvento(null);

		return tutorEvento;
	}

}