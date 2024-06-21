package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DT_TIEMPO database table.
 * 
 */
@Entity
@Table(name="DT_TIEMPO", schema="c##proyecto_dw")
@NamedQuery(name="DtTiempo.findAll", query="SELECT d FROM DtTiempo d")
public class DtTiempo implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SK_TIEMPO")
	private Long skTiempo;

	@Column(name="anio")
	private Integer anio;

	@Column(name="mes")
	private Integer mes;

	@Column(name="PK_TIEMPO")
	private Integer pkTiempo;

	@Column(name="semestre")
	private Integer semestre;

	//bi-directional many-to-one association to HtEvento
	@OneToMany(mappedBy="dtTiempo", fetch=FetchType.EAGER)
	private List<HtEvento> htEventos;

	public DtTiempo() {
	}

	public Long getSkTiempo() {
		return this.skTiempo;
	}

	public void setSkTiempo(Long skTiempo) {
		this.skTiempo = skTiempo;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getPkTiempo() {
		return this.pkTiempo;
	}

	public void setPkTiempo(Integer pkTiempo) {
		this.pkTiempo = pkTiempo;
	}

	public Integer getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List<HtEvento> getHtEventos() {
		return this.htEventos;
	}

	public void setHtEventos(List<HtEvento> htEventos) {
		this.htEventos = htEventos;
	}

	public HtEvento addHtEvento(HtEvento htEvento) {
		getHtEventos().add(htEvento);
		htEvento.setDtTiempo(this);

		return htEvento;
	}

	public HtEvento removeHtEvento(HtEvento htEvento) {
		getHtEventos().remove(htEvento);
		htEvento.setDtTiempo(null);

		return htEvento;
	}

}