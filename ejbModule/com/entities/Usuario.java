package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Roles;

import java.util.Date;
import java.util.Optional;
import java.util.Set;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NOMBRE_USUARIO", unique=true, nullable=false, length=100)
	private String nombreUsuario;

	@Column(nullable=false, precision=1)
	private byte activo;

	@Column(nullable=false, length=100)
	private String apellido1;

	@Column(nullable=false, length=100)
	private String apellido2;

	@Column(nullable=false, length=100)
	private String contrasenia;

	@Column(nullable=false, length=8)
	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_NAC", nullable=false)
	private Date fechaNacimiento;

	@Column(name="GENERO", nullable=false, length=1)
	private char genero;

	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO", nullable=false)
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name="ID_ITR", nullable=false)
	private Itr itr;
	
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD", nullable=false)
	private Localidad localidad;

	@Column(name="MAIL_INSTITUCIONAL", nullable=false, length=250)
	private String mailInstitucional;
	
	@Column(name="MAIL_PERSONAL", length=250, nullable=false)
	private String mailPersonal;

	@Column(nullable=false, length=50)
	private String nombre1;

	@Column(length=50, nullable = true)
	private String nombre2;

	@Column(length=9, nullable = true)
	private String telefono;

	//bi-directional many-to-one association to Analista
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	private Set<Analista> analistas;

	//bi-directional many-to-one association to Estudiantes
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	private Set<Estudiante> estudiantes;

	//bi-directional many-to-one association to Tutores
	
	// La anotación @OneToMany indica que esta entidad tiene una relación "uno a muchos" con la entidad "Tutor"
	// mappedBy="usuario" especifica que el campo "usuario" en la entidad "Tutor" es el propietario de la relación.
	// En otras palabras, "usuario" en la entidad "Tutor" mapea la relación hacia esta entidad.

	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	private Set<Tutor> tutores;

	@Transient
	private String tipoUsuario;
	
	@Transient
	private boolean active;

	public Usuario() {
	}

	public Usuario(String nombreUsuario, String apellido1, String apellido2, 
			String contrasenia, String documento, Date FechaNacimiento, 
			char genero, Departamento idDepartamento, Itr idItr, 
			Localidad idLocalidad, String mailInsti, String mailPers,
			String nombre1) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.contrasenia = contrasenia;
		this.documento = documento;
		this.fechaNacimiento = FechaNacimiento;
		this.genero = genero;
		this.departamento = idDepartamento;
		this.itr = idItr;
		this.localidad = idLocalidad;
		this.mailInstitucional = mailInsti;
		this.mailPersonal = mailPers;
		this.nombre1 = nombre1;
		
	}
	

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getActivo() {
		return this.activo == 1 ? "Activo" : "Inactivo";
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date FechaNacimiento) {
		this.fechaNacimiento = FechaNacimiento;
	}

	public char getGenero() {
		return this.genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento idDepartamento) {
		this.departamento = idDepartamento;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr idItr) {
		this.itr = idItr;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad idLocalidad) {
		this.localidad = idLocalidad;
	}

	public String getMailInstitucional() {
		return this.mailInstitucional;
	}

	public void setMailInstitucional(String mail) {
		this.mailInstitucional = mail;
	}

	public String getMailPersonal() {
		return mailPersonal;
	}

	public void setMailPersonal(String mailPersonal) {
		this.mailPersonal = mailPersonal;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	public boolean isValidUser(String passw) {
		return activo == 1 && contrasenia.equals(passw);
	}
	
	public String getTipoUsuario() {
		if(this.tipoUsuario != null) {
			return this.tipoUsuario;
		}
		if( analistas.stream().anyMatch(analista -> analista.getUsuario().getNombreUsuario().equals(nombreUsuario)) ) {
			this.tipoUsuario = "Analista";
		} else if ( estudiantes.stream().anyMatch(estudiante -> estudiante.getUsuario().getNombreUsuario().equals(nombreUsuario)) ) {
			this.tipoUsuario = "Estudiante";
		} else {
			this.tipoUsuario = "Tutor";
		}
		return this.tipoUsuario;
	}
	
	public String getGeneracion() {
		Optional<Estudiante> studentIfExists = estudiantes.stream().filter(estudiante -> estudiante.getUsuario().getNombreUsuario().equals(nombreUsuario)).findFirst();
		if(studentIfExists.isEmpty()) {
			return "";
		}
		String gen = studentIfExists.get().getGeneracion();
		return gen != null ? gen : "";
	}
	
	public Roles getRol() {
		Optional<Tutor> teacherIfExists = tutores.stream().filter(tutor -> tutor.getUsuario().getNombreUsuario().equals(nombreUsuario)).findFirst();
		if(teacherIfExists.isEmpty()) {
			return null;
		}
		Roles rol = teacherIfExists.get().getTipo();
		return rol;
	}
	
	public Area getArea() {
		Optional<Tutor> teacherIfExists = tutores.stream().filter(tutor -> tutor.getUsuario().getNombreUsuario().equals(nombreUsuario)).findFirst();
		if(teacherIfExists.isEmpty()) {
			return null;
		}
		Area area = teacherIfExists.get().getArea();
		return area;
	}
	
	public Set<Analista> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(Set<Analista> analistas) {
		this.analistas = analistas;
	}

	public Analista addAnalista(Analista analista) {
		if(analista == null) {
			return null;
		}
		getAnalistas().add(analista);
		analista.setUsuario(this);

		return analista;
	}

	public Analista removeAnalista(Analista analista) {
		if(analista == null) {
			return null;
		}
		getAnalistas().removeIf(a -> a.getUsuario().getNombreUsuario().equals(a.getUsuario().getNombreUsuario()));
		analista.setUsuario(null);

		return analista;
	}

	public Set<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		if(estudiante == null) {
			return null;
		}
		getEstudiantes().add(estudiante);
		estudiante.setUsuario(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		if(estudiante == null) {
			return null;
		}
		getEstudiantes().removeIf(e -> e.getUsuario().getNombreUsuario().equals(e.getUsuario().getNombreUsuario()));
		estudiante.setUsuario(null);

		return estudiante;
	}

	public Set<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(Set<Tutor> tutores) {
		this.tutores = tutores;
	}

	public Tutor removeTutor(Tutor tutor) {
		if(tutor == null) {
			return null;
		}
		getTutores().removeIf(t -> t.getUsuario().getNombreUsuario().equals(t.getUsuario().getNombreUsuario()));
		tutor.setUsuario(null);
		
		return tutor;
	}

	public Tutor addTutor(Tutor tutor) {
		if(tutor == null) {
			return null;
		}
		getTutores().add(tutor);
		tutor.setUsuario(this);

		return tutor;
	}
	
	public boolean isActive() {
		return activo == 1;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return nombreUsuario != null ? nombreUsuario : "";
	}

}