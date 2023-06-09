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

	private String titulo;

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

	private List<Reclamo> reclamos;

	private List<Tutor> tutores;

	private List<Constancia> constancias;
/*
	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="evento")
	private List<Constancia> constancias;

	//bi-directional many-to-one association to EstudianteEvento
	@OneToMany(mappedBy="evento")
	private List<EstudianteEvento> estudianteEventos;

	//bi-directional many-to-one association to Justificacione
	@OneToMany(mappedBy="evento")
	private List<Justificaciones> justificaciones;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="evento")
	private List<Reclamo> reclamos;


	//bi-directional many-to-many association to Tutore
	@ManyToMany(mappedBy="eventos")
	private List<Tutor> tutores;
*/
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

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Analista> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	
	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public Constancia addConstancia(Constancia constancia) {
		getConstancias().add(constancia);
		constancia.setEvento(this);

		return constancia;
	}

	public Constancia removeConstancia(Constancia constancia) {
		getConstancias().remove(constancia);
		constancia.setEvento(null);

		return constancia;
	}
/*
	public List<EstudianteEvento> getEstudianteEventos() {
		return this.estudianteEventos;
	}

	public void setEstudianteEventos(List<EstudianteEvento> estudianteEventos) {
		this.estudianteEventos = estudianteEventos;
	}

	public EstudianteEvento addEstudianteEvento(EstudianteEvento estudianteEvento) {
		getEstudianteEventos().add(estudianteEvento);
		estudianteEvento.setEvento(this);

		return estudianteEvento;
	}

	public EstudianteEvento removeEstudianteEvento(EstudianteEvento estudianteEvento) {
		getEstudianteEventos().remove(estudianteEvento);
		estudianteEvento.setEvento(null);

		return estudianteEvento;
	}

	public List<Justificaciones> getJustificaciones() {
		return this.justificaciones;
	}

	public void setJustificaciones(List<Justificaciones> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public Justificacione addJustificacione(Justificacione justificacione) {
		getJustificaciones().add(justificacione);
		justificacione.setEvento(this);

		return justificacione;
	}

	public Justificacione removeJustificacione(Justificacione justificacione) {
		getJustificaciones().remove(justificacione);
		justificacione.setEvento(null);

		return justificacione;
	*/

	public List<Reclamo> getReclamos() {
		return this.reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Reclamo addReclamo(Reclamo reclamo) {
		getReclamos().add(reclamo);
		reclamo.setEvento(this);

		return reclamo;
	}

	public Reclamo removeReclamo(Reclamo reclamo) {
		getReclamos().remove(reclamo);
		reclamo.setEvento(null);

		return reclamo;
	}
	

	public List<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}


}
