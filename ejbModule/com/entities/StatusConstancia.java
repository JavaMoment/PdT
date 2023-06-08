package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StatusConstancia
 *
 */
@Entity
@Table(name="STATUS_CONSTANCIA")
public class StatusConstancia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="STATUS_CONSTANCIA_IDSTATUS_GENERATOR", sequenceName="STATUS_ID_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_CONSTANCIA_IDSTATUS_GENERATOR")
	@Column(name="ID_STATUS", unique=true, nullable=false, precision=38)
	private Long idStatus;
	
	@ManyToMany
	@JoinTable(
		name="STATUS_CERTIFICADOS"
		, joinColumns={
			@JoinColumn(name="ID_STATUS")
			}
		, inverseJoinColumns={	
			@JoinColumn(name="ID_CONSTANCIA")
			}
		)
	private List<StatusCertificados> statusCertificados;

	public StatusConstancia() {
		super();
	}
   
}
