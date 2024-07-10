package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.entities.Modalidad;

import java.util.Date;
import java.util.List;

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
//	@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq")
	@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
	@Column(name = "ID_EVENTO")
	private Long idEvento;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	@ManyToOne()
	@JoinColumn(name = "ID_ITR")
	private Itr itr;

	@Column(name = "DESC_LOCALIZACION")
	private String localizacion;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_EVENTO", nullable = false)
	private TiposEvento tiposEvento;

	@NotNull
	@Column(name = "TITULO")
	private String titulo;

	// bi-directional many-to-one association to Modalidad
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MODALIDAD", nullable = false)
	private Modalidad modalidad;

	// bi-directional many-to-one association to Estado
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_STATUS_EVENTO", nullable = false)
	private StatusEvento statusEvento;

	@Column(name = "ACTIVO", nullable = false, precision = 1)
	private Byte activo;

	// bi-directional many-to-one association to TutorEvento
	@OneToMany(mappedBy = "evento", fetch = FetchType.EAGER)
	private List<TutorEvento> tutorEventos;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reclamo> reclamos;

	// Constructor con parámetros para inicializar todas las propiedades de Evento
	public Evento(String titulo, TiposEvento tiposEvento, Date fechaHoraInicio, Date fechaHoraFinal,
			Modalidad modalidad, Itr itr, String localizacion, StatusEvento statusEvento, Byte activo) {
		this.titulo = titulo;
		this.tiposEvento = tiposEvento;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFinal = fechaHoraFinal;
		this.modalidad = modalidad;
		this.itr = itr;
		this.localizacion = localizacion;
		this.statusEvento = statusEvento;
		this.activo = activo;
	}

	public Evento() {

	}

	public Long getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Long idEvento) {
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

	public TiposEvento getTiposEvento() {
		return this.tiposEvento;
	}

	public void setTiposEvento(TiposEvento tiposEvento) {
		this.tiposEvento = tiposEvento;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Modalidad modalidade) {
		this.modalidad = modalidade;
	}

	public StatusEvento getstatusEvento() {
		return this.statusEvento;
	}

	public void setstatusEvento(StatusEvento statusEvento) {
		this.statusEvento = statusEvento;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo ? (byte) 1 : (byte) 0;
	}

	public Boolean getActivo() {
		return activo == 1;
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

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	@Override
	public String toString() {
		return this.titulo;
	}

	@Override
	public boolean equals(Object other) {
		Evento otherE = (Evento) other;
		return this.getIdEvento() == (otherE.getIdEvento());
	}

}
