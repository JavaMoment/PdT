package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the RECLAMOS database table.
 * 
 */
@Entity
@Table(name="RECLAMOS")
public class Reclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RECLAMO")
	private long idReclamo;
	
//	bi-directional many-to-one association to Analista
	@ManyToOne(optional=true, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_ANALISTA", nullable=true)
	private Analista analista;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="AUDIT_DATE", updatable=false)
	private Date auditDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIF_DATE", nullable=true)
	private Date modifDate;
	
	@Column(name="MODIF_USER", nullable=true)
	private String modifUser;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@Column(name="DETALLE", nullable=true)
	private String detalle;
	
	public Reclamo() {
	}
	
	public Reclamo(Estudiante estudiante, Evento evento, String titulo,
			String descripcion) {
		super();
		this.estudiante = estudiante;
		this.evento = evento;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	@PrePersist
	protected void onCreate() {
		this.auditDate= new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.modifDate = new Date();
	}

	public long getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(long idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Analista getAnalista() {
		return this.analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public StatusReclamo getStatusReclamo() {
		return statusReclamo;
	}

	public void setStatusReclamo(StatusReclamo statusReclamo) {
		this.statusReclamo = statusReclamo;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Date getModifDate() {
		return modifDate;
	}

	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}

	public String getModifUser() {
		return modifUser;
	}

	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}