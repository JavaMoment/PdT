package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.entities.Modalidad;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;


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
	@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
	@Column(name="ID_EVENTO")
	private long idEvento;

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

	@Column(name="DESC_LOCALIZACION")
	private String localizacion;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_TIPO_EVENTO", nullable=false)
	private TiposEvento tiposEvento;
	
	@NotNull
	@Column(name="TITULO")
	private String titulo;
	

	//bi-directional many-to-one association to Modalidad
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MODALIDAD", nullable=false)
	private Modalidad modalidad;

	// bi-directional many-to-one association to Estado
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_STATUS_EVENTO", nullable=false)
	private Estado statusEvento;

	@Column(name = "ACTIVO")
	private byte activo;
	
	// bi-directional many-to-one association to TutorEvento
	@OneToMany(mappedBy = "evento", fetch = FetchType.EAGER)
	private List<TutorEvento> tutorEventos;
	
	@Transient
	private boolean active;

	@OneToMany(mappedBy="evento", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Reclamo> reclamos;
	
	// Constructor con parámetros para inicializar todas las propiedades de Evento
	public Evento(String titulo, TiposEvento tiposEvento, Date fechaHoraInicio, Date fechaHoraFinal, Modalidad modalidad,
			Itr itr, String localizacion, Estado statusEvento, byte activo) {
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

	public Evento () {
		
		
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

	public Estado getstatusEvento() {
		return this.statusEvento;
	}

	public void setstatusEvento(Estado statusEvento) {
		this.statusEvento = statusEvento;
	}
	
	public String getActivo() {
		return activo == 1 ? "Activo" : "Inactivo";
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public boolean isActive() {
		return activo == 1;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
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
		return "Evento [idEvento=" + idEvento + ", fechaHoraFinal=" + fechaHoraFinal + ", fechaHoraInicio="
				+ fechaHoraInicio + ", idItr=" + itr.getNombre() + ", localizacion=" + localizacion + ", tipoEvento=" + tiposEvento
				+ ", titulo=" + titulo + ", modalidad=" + modalidad + ", estado=" + statusEvento + ", activo=" + activo + "]";
	}

}
