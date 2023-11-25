package com.entities;

import java.io.Serializable;
import javax.persistence.*;



//import entities.Departamento;
//import entities.Usuario;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ITR database table.
 * 
 */
@Entity
public class Itr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ITR_IDITR_GENERATOR", sequenceName="itr_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITR_IDITR_GENERATOR")
	@Column(name="ID_ITR")
	private long idItr;


	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@OneToMany(mappedBy="itr")
	private List<Evento> eventos;
	
	@Column(nullable=false, precision=1)
	private byte activo;
	
	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="itr", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Departamento> departamentos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="itr", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Usuario> usuarios;
	
	@Transient
	private boolean active;

	public Itr() {
	}
	
	public Itr(String name) {
		this.nombre = name;
		this.activo = (byte) 1;
	}

	public long getIdItr() {
		return this.idItr;
	}

	public void setIdItr(long idItr) {
		this.idItr = idItr;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setItr(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setItr(null);

		return departamento;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
 
	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setItr(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setItr(null);

		return usuario;
	}

	public String getActivo() {
		return activo == 1 ? "Activo" : "Inactivo";
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public boolean isActive() {
		return activo == 1;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	@Override
	public String toString() {
		return this.nombre != null ? this.nombre : "";
	}
}
