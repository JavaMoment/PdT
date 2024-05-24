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

		@Column(name="NOMBRE")
		private String nombre;
		
		@Column(name="ACTIVO")
		private Integer activo;

		

		//bi-directional many-to-one association to Evento
		@OneToMany(mappedBy="modalidad", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
		private List<Evento> eventos;

		public Modalidad() {
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
		
		public Integer getActivo() {
			return activo;
		}

		public void setActivo(Integer activo) {
			this.activo = activo;
		}

		public String toString() {
			return nombre;
		}

	}
