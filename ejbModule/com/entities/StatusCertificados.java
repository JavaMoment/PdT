	package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: StatusCertificados
 *
 */
@Entity
@Table(name="STATUS_CERTIFICADOS")
public class StatusCertificados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATUS_CERTIFICADOS_IDSTATUS_GENERATOR", sequenceName="STAT_CERT_ID_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_CERTIFICADOS_IDSTATUS_GENERATOR")
	@Column(name="ID_STATUS", unique=true, nullable=false, precision=38)
	private Long idStatus;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombreAccion;

	public StatusCertificados() {
		super();
	}


	public Long getIdStatus() {
		return idStatus;
	}


	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}


	public String getStatus() {
		return nombreAccion;
	}


	public void setStatus(String status) {
		this.nombreAccion = status;
	}
   
}
