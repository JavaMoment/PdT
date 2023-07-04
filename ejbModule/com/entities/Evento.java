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
public class Evento implements Serializable {
	
	
	
	public Evento() {
	}


	public Evento(String title, String type, Date startDate, Date endDate, String modality, String itr,
			String location) {
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTOS_IDEVENTO_GENERATOR", sequenceName="event_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTOS_IDEVENTO_GENERATOR")
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
	
	@Column(name="TITULO")
	private String titulo;
	
	//@Column(name="TIPO_EVENTO", nullable=false)
	//@Enumerated(EnumType.STRING)
	//private TipoEvento tipoEvento;
	
	//@Column(name="MODALIDAD", nullable=false)
	//@Enumerated(EnumType.STRING)
	//private Modalidad modalidad;

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
