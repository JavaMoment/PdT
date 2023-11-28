package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Itr.class, cascade = CascadeType.MERGE)
	@JoinColumn(name="ID_ITR", nullable=true)
	private Itr itr;

	@Column(name="nombre", nullable=false)
	private String nombre;

	//bi-directional many-to-one association to Localidad
	@OneToMany(mappedBy="departamento", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
	private List<Localidad> localidades;

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

	public List<Localidad> getLocalidades() {
		return this.localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
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

}