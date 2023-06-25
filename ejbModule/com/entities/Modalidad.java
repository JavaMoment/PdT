package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MODALIDADES database table.
 * 
 */
@Entity
@Table(name="MODALIDADES")
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MODALIDAD")
	private long idModalidad;

	@Column(name="NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Evento
	//@OneToMany(mappedBy="modalidad")
	private List<Evento> eventos;

	public Modalidad() {
	}

	public long getIdModalidad() {
		return this.idModalidad;
	}

	public void setIdModalidad(long idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	/*public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setModalidad(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setModalidad(null);

		return evento;
	}*/

}