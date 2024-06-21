package com.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the HT_EVENTO database table.
 * 
 */
@Entity
@Table(name="HT_EVENTO", schema="c##proyecto_dw")
@NamedQuery(name="HtEvento.findAll", query="SELECT h FROM HtEvento h")
public class HtEvento implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SK_EVENTO")
	private Long skEvento;

	@Column(name="CANT_EVENTOS")
	private Integer cantEventos;

	//bi-directional many-to-one association to DtItr
	@ManyToOne
	@JoinColumn(name="SK_ITR")
	private DtItr dtItr;

	//bi-directional many-to-one association to DtTiempo
	@ManyToOne
	@JoinColumn(name="SK_TIEMPO")
	private DtTiempo dtTiempo;

	public HtEvento() {
	}

	public Long getSkEvento() {
		return this.skEvento;
	}

	public void setSkEvento(Long skEvento) {
		this.skEvento = skEvento;
	}

	public Integer getCantEventos() {
		return this.cantEventos;
	}

	public void setCantEventos(Integer cantEventos) {
		this.cantEventos = cantEventos;
	}

	public DtItr getDtItr() {
		return this.dtItr;
	}

	public void setDtItr(DtItr dtItr) {
		this.dtItr = dtItr;
	}

	public DtTiempo getDtTiempo() {
		return this.dtTiempo;
	}

	public void setDtTiempo(DtTiempo dtTiempo) {
		this.dtTiempo = dtTiempo;
	}

}