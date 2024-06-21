package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DT_ITR database table.
 * 
 */
@Entity
@Table(name="DT_ITR", schema="c##proyecto_dw")
@NamedQuery(name="DtItr.findAll", query="SELECT d FROM DtItr d")
public class DtItr implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SK_ITR")
	private Long skItr;

	@Column(name="PK_ITR")
	private String pkItr;

	//bi-directional many-to-one association to HtEvento
	@OneToMany(mappedBy="dtItr", fetch=FetchType.EAGER)
	private List<HtEvento> htEventos;

	public DtItr() {
	}

	public Long getSkItr() {
		return this.skItr;
	}

	public void setSkItr(Long skItr) {
		this.skItr = skItr;
	}

	public String getPkItr() {
		return this.pkItr;
	}

	public void setPkItr(String pkItr) {
		this.pkItr = pkItr;
	}

	public List<HtEvento> getHtEventos() {
		return this.htEventos;
	}

	public void setHtEventos(List<HtEvento> htEventos) {
		this.htEventos = htEventos;
	}

	public HtEvento addHtEvento(HtEvento htEvento) {
		getHtEventos().add(htEvento);
		htEvento.setDtItr(this);

		return htEvento;
	}

	public HtEvento removeHtEvento(HtEvento htEvento) {
		getHtEventos().remove(htEvento);
		htEvento.setDtItr(null);

		return htEvento;
	}

	@Override
	public String toString() {
		return pkItr != null ? pkItr : "";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if(!(other instanceof DtItr)) return false;
		DtItr otherI = (DtItr) other;
		return this.getSkItr() == (otherI.getSkItr());
	}

}