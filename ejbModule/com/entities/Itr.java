package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
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
	private Long idItr;


	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@OneToMany(mappedBy="itr")
	private List<Evento> eventos;
	
	@Column(nullable=false, precision=1)
	private Byte activo;
	
	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="itr", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Departamento> departamentos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="itr", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Usuario> usuarios;
	
	public Itr() {
	}
	
	public Itr(String name) {
		this.nombre = name;
		this.activo = (byte) 1;
	}

	public Itr(String name, List<Departamento> departamentos) {
		this.nombre = name;
		this.activo = (byte) 1;
		// Asegurarse que los departamentos estaran asociados unicamente con el itr instanciado
		departamentos.forEach(d -> d.setItr(this));
		this.departamentos = new HashSet<>(departamentos);
	}

	public Long getIdItr() {
		return this.idItr;
	}

	public void setIdItr(Long idItr) {
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
		if(departamentos != null) {
			// Listas temporales para poder utilizar el metodo '.contains()'
			// Por alguna razon no funciona con el contains de la clase Set 
			// (sera por el hasheo? el nodo se referencia por nombre de variable en el treeMap?)
			List<Departamento> tmp = departamentos.stream().toList();
			List<Departamento> selfTmp = this.departamentos.stream().toList();
			// Para cada elemento de la actual lista de departamentos asociados al ITR instanciado
			// Eliminar la asociacion por el lado del Departamento si este no se encuentra en la lista
			// de los nuevos departamentos asociados.
			this.departamentos.forEach(d -> {
				if(!tmp.contains(d)) {
					d.setItr(null);
				}
			});
			// A cada nuevo Departamento que va a estar asociado al ITR instanciado, settearle este ultimo
			// para establecer la relacion. A su vez adicionarlo a la lista de departamentos asociados
			// cuando esta lista se mande a BDD se rompera la asociacion (o no) entre ITR y departamento
			// y al selectear nuevamente se devolvera la lista correcta.
			// Si se manda con unicamente la lista de nuevos | estaticos, no se rompe la relacion en cascada 
			// por lo que tendrias que actualizar los departamentos que eliminas de la relacion antes de actualizar el ITR.
			departamentos.forEach(d -> {
				d.setItr(this);
				if(!selfTmp.contains(d)) this.departamentos.add(d);
			});			
		} else {
			this.departamentos.forEach(d -> d.setItr(null));
		}
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

	public Byte getActivo() {
		return activo;
	}

	public void setActivo(Byte activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return this.nombre != null ? this.nombre : "";
	}
	
	@Override
	public boolean equals(Object obj) {
	    Itr other = (Itr) obj; 
		if (!nombre.equals(other.getNombre()))
	        return false;
	    return true;
	}
}
