package com.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EVENTOS database table.
 * 
 */
@Entity
@Table(name="EVENTOS")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTOS_IDEVENTO_GENERATOR", sequenceName="EVENTOS_SEQ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTOS_IDEVENTO_GENERATOR")
	@Column(name="ID_EVENTO")
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_FINAL")
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_INICIO")
	private Date fechaHoraInicio;

	@Column
	private String localizacion;
	
	@Column
	private String titulo;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Modalidad modalidad;

	//bi-directional many-to-many association to Analista
	@ManyToMany
	@JoinTable(
		name="ANALISTA_EVENTO"
		, joinColumns={
			@JoinColumn(name="ID_EVENTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ANALISTA")
			}
	)
	private List<Analista> analistas;
	
	
	@ManyToMany
	@JoinTable(
		name="TUTOR_EVENTO"
		, joinColumns={
			@JoinColumn(name="ID_EVENTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_TUTOR")
			}
	)
	private List<Tutor> tutores;
	

		
	
	



}
