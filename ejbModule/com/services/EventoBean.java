package com.services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Estudiante;
import com.entities.Evento;
import com.entities.Itr;
import com.entities.Tutor;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
public class EventoBean extends CRUDBean<Evento, Long> implements EventoBeanRemote {

	public EventoBean() {
		System.out.print("");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Evento> todos() {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e", Evento.class);
			return query.getResultList();

		} catch (PersistenceException e) {
			// Manejo de excepciones
			return Collections.emptyList();
		}
	}

	public Evento createEvento(Evento evento) {
		try {
			// Primero persistimos los datos que vienen desde el cliente
			super.getEntityManager().persist(evento);
			// Al persistirlos tenemos el id que genera la secuencia y hacemos el commit
			// para guardar los cambios
			super.getEntityManager().flush();
 
			return evento;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cai en el syso de createveneto");
			return null;
		}
	}

	@Override
	public Tutor tutorDelEvento(long id_tutor) {
		try {
			TypedQuery<Tutor> query = (TypedQuery<Tutor>) super.getEntityManager()
					.createQuery("SELECT t FROM Tutor t JOIN FETCH t.usuario WHERE t.idTutor = :id", Tutor.class)
					.setParameter("id", id_tutor);
			return query.getResultList().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public long buscarId(String titulo) {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e WHERE e.titulo = :titulo", Evento.class)
					.setParameter("titulo", titulo);
			return query.getResultList().get(0).getIdEvento();
		} catch (Exception e) {
			// TODO: handle exception
			return -1L;
		}
	}
	
	@Override
	public List<Evento> getEventosBy(long idEstudiante) {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e JOIN EstudianteEvento ee ON ee.id.idEvento = e.idEvento WHERE ee.id.idEstudiante = :idEstudiante", Evento.class)
					.setParameter("idEstudiante", idEstudiante);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Evento> selectEventosByTutor(long idTutor) {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e JOIN TutorEvento te ON te.id.idEvento = e.idEvento WHERE te.id.idTutor = :idTutor", Evento.class)
					.setParameter("idTutor", idTutor);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	//crear metodo para limpiar el evento
	
		public int logicalDeleteBy(Long i) {
			try {
				Evento eventoToUpdate = selectById(i);
				eventoToUpdate.setActivo((byte) 0);
				
				int resultCode = update(eventoToUpdate);
				
				return resultCode == 0  ? 0 : -1;
			} catch(PersistenceException e) {
				return -1;
			}
		}
		
		public int activeEventBy(Long i) {
			try {
				Evento eventoToUpdate = selectById(i);
				eventoToUpdate.setActivo((byte) 1);
				
				int resultCode = update(eventoToUpdate);
				
				return resultCode == 0  ? 0 : -1;
			} catch(PersistenceException e) {
				return -1;
			}
		}
		
	@Override
	public Evento selectBy(String title) {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e WHERE e.titulo =: title", Evento.class)
					.setParameter("title", title);
			return query.getSingleResult();
		} catch(Exception e) {
			return null;
		}
	}
}
