package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the DEPARTAMENTOS database table.
 * 
 */
@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTOS_IDDEPARTAMENTO_GENERATOR", sequenceName="DEPA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTOS_IDDEPARTAMENTO_GENERATOR")
	@Column(name="ID_DEPARTAMENTO")
	private Long idDepartamento;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ID_ITR", nullable=true)
	private Itr itr;

	@Column(name="nombre", nullable=false)
	private String nombre;

	//bi-directional many-to-one association to Localidad
	@OneToMany(mappedBy="departamento", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Localidad> localidades;

	public Departamento() {
	}

	public long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr Itr) {
		this.itr = Itr;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Localidad> getLocalidades() {
		return this.localidades;
	}

	public void setLocalidades(Set<Localidad> localidades) {
		this.localidades = localidades;
	}

	public Localidad addLocalidade(Localidad localidade) {
		getLocalidades().add(localidade);
		localidade.setDepartamento(this);

		return localidade;
	}

	public Localidad removeLocalidade(Localidad localidade) {
		getLocalidades().remove(localidade);
		localidade.setDepartamento(null);

		return localidade;
	}

	@Override
	public String toString() {
		return nombre != null ? nombre : "";
	}
	
	/*
	 * Comparator a traves del nombre de los departamentos (ya que son únicos)
	 * para complacer las operaciones del estilo .contains().
	 */
	@Override
	public boolean equals(Object other) {
		Departamento otherDepa = (Departamento) other;
	    return this.getNombre().equals(otherDepa.getNombre());
	}

}