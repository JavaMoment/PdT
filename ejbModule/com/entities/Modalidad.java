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
		@GeneratedValue(strategy=GenerationType.IDENTITY)	
		@Column(name="ID_MODALIDAD")
		private Long idModalidad;

		@Column(name="NOMBRE", nullable=false)
		private String nombre;
		
		@Column(nullable=false, precision=1)
		private Byte activo;

		

		//bi-directional many-to-one association to Evento
		@OneToMany(mappedBy="modalidad", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
		private List<Evento> eventos;

		public Modalidad() {
		}

		public Modalidad(String name) {
			this.nombre = name;
			this.activo = (byte) 1;
		}
		public Long getIdModalidad() {
			return this.idModalidad;
		}

		public void setIdModalidad(Long idModalidad) {
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
		
		public Boolean getActivo() {
			return activo == 1;
		}
		public void setActivo(Boolean activo) {
			this.activo = activo ? (byte) 1 : (byte) 0;
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
