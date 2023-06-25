package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EVENTOS database table.
 * 
 */
@Entity
@Table(name="EVENTOS")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	
	
	public Evento(String title, String type, Date startDate, Date endDate, String modality, String itr,
			String location) {
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	//@Column(name="LOCALIZACION")
	//private String localizacion;
	@Column(name="ID_ITR")
	private java.math.BigDecimal idItr;

	@Column(name="ID_TIPO")
	private java.math.BigDecimal idTipo;

	private String localizacion;

	
	@Column(name="TIPO_EVENTO")
	private String tipoEvento;

	private String titulo;
	
	//@Column(name="TIPO_EVENTO", nullable=false)
	//@Enumerated(EnumType.STRING)
	//private TipoEvento tipoEvento;
	
	//@Column(name="MODALIDAD", nullable=false)
	//@Enumerated(EnumType.STRING)
	//private Modalidad modalidad;

	//bi-directional many-to-one association to Modalidad
	@ManyToOne
	@JoinColumn(name="ID_MODALIDAD")
	private Modalidad modalidad;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

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

	public java.math.BigDecimal getIdItr() {
		return this.idItr;
	}

	public void setIdItr(java.math.BigDecimal idItr) {
		this.idItr = idItr;
	}

	public java.math.BigDecimal getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(java.math.BigDecimal idTipo) {
		this.idTipo = idTipo;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Modalidad getModalidade() {
		return this.modalidad;
	}

	public void setModalidade(Modalidad modalidade) {
		this.modalidad = modalidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}