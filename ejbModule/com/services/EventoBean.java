package com.services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Evento;
import com.entities.Tutor;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
public class EventoBean extends CRUDBean<Evento, Long> implements EventoBeanRemote {

	public EventoBean() {
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

			// Creamos una variable de apoyo para capturar el id maximo que seria el ultimo
			// en guardarse osea el de arriba
			int maxId = 0;

			// recorremos todos los registros que haya en la base de datos
			for (Evento aux : todos()) {

				// Obtenemos el id de cada items
				int idEvento = aux.getIdEvento();

				// Si es mayor a el maxId lo almacenamos ahí
				if (idEvento > maxId) {
					maxId = idEvento;
				}
			}

			// Creamos una entidad de apoyo que utilizamos para retornar el id ya que si
			// retornamos la otra entidad da negativo
			Evento oEventoProvisorio = new Evento();
			oEventoProvisorio.setIdEvento(maxId);

			return oEventoProvisorio;
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
	public int buscarId(String titulo) {
		try {
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e WHERE e.titulo = :titulo", Evento.class)
					.setParameter("titulo", titulo);
			return query.getResultList().get(0).getIdEvento();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
