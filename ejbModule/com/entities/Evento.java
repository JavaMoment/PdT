package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.enums.Modalidad;
import com.enums.Status;
import com.enums.TipoEvento;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EVENTOS")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EVENTOS_IDEVENTO_GENERATOR", sequenceName = "event_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTOS_IDEVENTO_GENERATOR")
	@Column(name = "ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	@Column(name = "LOCALIZACION", nullable = false)
	private String localizacion;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "TIPO_EVENTO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	@Column(name = "MODALIDAD", nullable = false)
	@Enumerated(EnumType.STRING)
	private Modalidad modalidad;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne()
	@JoinColumn(name = "ID_ITR", nullable = false)
	private Itr itr;

	@ManyToMany
	@JoinTable(name = "ANALISTA_EVENTO", joinColumns = { @JoinColumn(name = "ID_EVENTO") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_ANALISTA") })
	private List<Analista> analistas;

	@ManyToMany
	@JoinTable(name = "TUTOR_EVENTO", joinColumns = { @JoinColumn(name = "ID_EVENTO") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_TUTOR") })
	private List<Tutor> tutores;

	public Evento() {

	}

	// Constructor con parámetros para inicializar todas las propiedades de Evento
	public Evento(String titulo, TipoEvento tipoEvento, Date fechaHoraInicio, Date fechaHoraFinal,
			Modalidad modalidad, Itr itr, String localizacion, Status status) {
		super();
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFinal = fechaHoraFinal;
		this.modalidad = modalidad;
		this.itr = itr;
		this.localizacion = localizacion;
		this.status = status;
	}

	// Getters y setters para todas las propiedades

	public long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Analista> getAnalistas() {
		return analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", fechaHoraFinal=" + fechaHoraFinal + ", fechaHoraInicio="
				+ fechaHoraInicio + ", localizacion=" + localizacion + ", titulo=" + titulo + ", idItr=" + itr
				+ ", tipoEvento=" + tipoEvento + ", modalidad=" + modalidad + ", status=" + status + ", analistas="
				+ analistas + ", tutores=" + tutores + "]";
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Itr getItr() {
		return itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}
}
