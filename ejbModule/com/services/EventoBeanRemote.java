package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Evento;
import com.entities.Tutor;

/**
 * Session Bean implementation class EventoBeanRemote
 */
@Remote
public interface EventoBeanRemote extends CRUDRemote<Evento, Long>{

	public Evento createEvento(Evento evento);
	public List<Evento> todos();
	public Tutor tutorDelEvento (long id_tutor);
	public long buscarId (String titulo);
	List<Evento> getEventosBy(long idEstudiante);
	List<Evento> selectEventosByTutor(long idTutor);
	int activeEventBy(Long i);
	int logicalDeleteBy(Long i);
	Evento selectBy(String name);
}
