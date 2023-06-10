package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.Tipo;

/**
 * Entity implementation class for Entity: Constancia
 *
 */
@Entity
@Table(name="CONSTANCIAS")
public class Constancia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="CONSTANCIAS_IDCONSTANCIA_GENERATOR", sequenceName="CONSTANCIAS_ID_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSTANCIAS_IDCONSTANCIA_GENERATOR")
	@Column(name="ID_CONSTANCIA", unique=true, nullable=false, precision=38)
	private Long idConstancia;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fecha_hora;
	
	@Column(nullable=false)
	private String detalle;
	
	
	@ManyToOne
	@JoinColumn(name="ID_ANALISTA",  nullable=false)
	private Analista analista;
	
	@ManyToOne
	@JoinColumn(name="ID_EVENTO",  nullable=false)
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE",  nullable=false)
	private Estudiante estudiante;
	

	public Constancia() {
		super();
	}

	public Long getIdConstancia() {
		return idConstancia;
	}

	public void setIdConstancia(Long idConstancia) {
		this.idConstancia = idConstancia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
   
}
