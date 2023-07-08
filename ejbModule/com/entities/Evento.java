package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import com.entities.Modalidad;
import com.enums.TipoEvento;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="EVENTOS")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@JoinColumn(name="ID_MODALIDAD")
	private Modalidad modalidad;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;
	
	@Column(name="ACTIVO")
	private int activo;


	public Evento() {
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
	
	
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", fechaHoraFinal=" + fechaHoraFinal + ", fechaHoraInicio="
				+ fechaHoraInicio + ", idItr=" + itr.getNombre() + ", localizacion=" + localizacion + ", tipoEvento=" + tipoEvento
				+ ", titulo=" + titulo + ", modalidad=" + modalidad + ", estado=" + estado + ", activo=" + activo + "]";
	}

}
