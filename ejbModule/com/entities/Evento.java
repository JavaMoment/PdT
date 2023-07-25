package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.entities.Modalidad;
import com.enums.TipoEvento;


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
	@Column(name="ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	@ManyToOne()
	@JoinColumn(name = "ID_ITR", nullable = false)
	private Itr itr;

  @Column(name="LOCALIZACION")
	private String localizacion;

	@Column(name="TIPO_EVENTO")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	@Column(name="TITULO")
	private String titulo;
	

	//bi-directional many-to-one association to Modalidad
	@ManyToOne
	@JoinColumn(name = "ID_MODALIDAD")
	private Modalidad modalidad;

	// bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	private Estado estado;

	@Column(name = "ACTIVO")
	private int activo;
	
	// bi-directional many-to-one association to TutorEvento
	@OneToMany(mappedBy = "evento", fetch = FetchType.EAGER)
	private List<TutorEvento> tutorEventos;


	// Constructor con parámetros para inicializar todas las propiedades de Evento
	public Evento(String titulo, TipoEvento tipoEvento, Date fechaHoraInicio, Date fechaHoraFinal, Modalidad modalidad,
			Itr itr, String localizacion, Estado estado, int activo) {
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFinal = fechaHoraFinal;
		this.modalidad = modalidad;
		this.itr = itr;
		this.localizacion = localizacion;
		this.estado = estado;
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

	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Modalidad modalidade) {
		this.modalidad = modalidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
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
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", fechaHoraFinal=" + fechaHoraFinal + ", fechaHoraInicio="
				+ fechaHoraInicio + ", idItr=" + itr.getNombre() + ", localizacion=" + localizacion + ", tipoEvento=" + tipoEvento
				+ ", titulo=" + titulo + ", modalidad=" + modalidad + ", estado=" + estado + ", activo=" + activo + "]";
	}

}
