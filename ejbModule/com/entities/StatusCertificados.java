	package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Status;

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
	
	@Column(name="nombre", nullable=false)
	@Enumerated(EnumType.STRING)
	private Status nombreAccion;
	
	
	public StatusCertificados() {
		super();
	}


	public Long getIdStatus() {
		return idStatus;
	}


	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}


	public Status getStatus() {
		return nombreAccion;
	}


	public void setStatus(Status status) {
		this.nombreAccion = status;
	}
   
}
