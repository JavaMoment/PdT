package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	private Date fecNac;

	@Column(nullable=false, length=1)
	private char genero;

	@Column(name="ID_DEPARTAMENTO", nullable=false)
	private int idDepartamento;

	@Column(name="ID_ITR", nullable=false)
	private int idItr;

	@Column(name="ID_LOCALIDAD", nullable=false)
	private int idLocalidad;

	@Column(nullable=false, length=250)
	private String mail;

	@Column(nullable=false, length=50)
	private String nombre1;

	@Column(length=50)
	private String nombre2;

	@Column(length=9)
	private String telefono;

	//bi-directional many-to-one association to Analista
	/*@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Analista> analistas;

	//bi-directional many-to-one association to Estudiantes
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Tutores
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Tutor> tutores;*/

	public Usuario() {
	}

	public Usuario(String nombreUsuario, String apellido1, String apellido2, String contrasenia, String documento,
			Date fecNac, char genero, int idDepartamento, int idItr, int idLocalidad, String mail, String nombre1) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.contrasenia = contrasenia;
		this.documento = documento;
		this.fecNac = fecNac;
		this.genero = genero;
		this.idDepartamento = idDepartamento;
		this.idItr = idItr;
		this.idLocalidad = idLocalidad;
		this.mail = mail;
		this.nombre1 = nombre1;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public byte getActivo() {
		return this.activo;
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

	public Date getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public char getGenero() {
		return this.genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public int getIdItr() {
		return this.idItr;
	}

	public void setIdItr(int idItr) {
		this.idItr = idItr;
	}

	public int getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

/*	public List<Analista> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	public Analista addAnalista(Analista analista) {
		getAnalistas().add(analista);
		analista.setUsuario(this);

		return analista;
	}

	public Analista removeAnalista(Analista analista) {
		getAnalistas().remove(analista);
		analista.setUsuario(null);

		return analista;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setUsuario(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setUsuario(null);

		return estudiante;
	}

	public List<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public Tutor removeTutore(Tutor tutore) {
		getTutores().remove(tutore);
		tutore.setUsuario(null);
		
		return tutore;
	}

	public Tutor addTutore(Tutor tutore) {
		getTutores().add(tutore);
		tutore.setUsuario(this);

		return tutore;
	}*/
	
	@Override
	public String toString() {
		return "Usuario [" + (nombreUsuario != null ? "nombreUsuario=" + nombreUsuario + ", " : "") + "activo=" + activo
				+ ", " + (apellido1 != null ? "apellido1=" + apellido1 + ", " : "")
				+ (apellido2 != null ? "apellido2=" + apellido2 + ", " : "")
				+ (contrasenia != null ? "contrasenia=" + contrasenia + ", " : "")
				+ (documento != null ? "documento=" + documento + ", " : "")
				+ (fecNac != null ? "fecNac=" + fecNac + ", " : "") + "genero=" + genero + ", idDepartamento="
				+ idDepartamento + ", idItr=" + idItr + ", idLocalidad=" + idLocalidad + ", "
				+ (mail != null ? "mail=" + mail + ", " : "") + (nombre1 != null ? "nombre1=" + nombre1 + ", " : "")
				+ (nombre2 != null ? "nombre2=" + nombre2 + ", " : "")
				+ (telefono != null ? "telefono=" + telefono : "") + "]";
	}

}