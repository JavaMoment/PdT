package com.models;

import java.io.Serializable;

public class ReclamosCount implements Serializable {
	private static final long serialVersionUID = 13922419318740660L;
	
	private String fechaCreacion;
	private Integer cantReclamos;
	
	public ReclamosCount(String fechaCreacion, Long cantReclamos) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.cantReclamos = cantReclamos.intValue();
	}
	
	public ReclamosCount(String fechaCreacion, Integer cantReclamos) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.cantReclamos = cantReclamos;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getCantReclamos() {
		return cantReclamos;
	}
	public void setCantReclamos(Integer cantReclamos) {
		this.cantReclamos = cantReclamos;
	}

	@Override
	public String toString() {
		return "ReclamosCount [" + (fechaCreacion != null ? "fechaCreacion=" + fechaCreacion + ", " : "")
				+ (cantReclamos != null ? "cantReclamos=" + cantReclamos : "") + "]";
	}

}
