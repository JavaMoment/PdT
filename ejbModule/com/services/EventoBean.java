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
//	@Override
//	public Evento createEvento(Evento evento) {
//		try {
//			// Primero persistimos los datos que vienen desde el cliente
//			super.getEntityManager().persist((super.getEntityManager().contains(evento) ? evento : super.getEntityManager().merge(evento)));
//			// Al persistirlos tenemos el id que genera la secuencia y hacemos el commit
//			// para guardar los cambios
//			super.getEntityManager().flush();
//			//super.getEntityManager().clear();
//			return evento;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("cai en el syso de createveneto");
//			return null;
//		}
//	}
	
	//este funciona pero me trae ids diferentes
	public Evento createEvento(Evento evento) {
		try {
			evento.setActivo(true);
			//super.getEntityManager().contains(evento)
			// Primero persistimos los datos que vienen desde el cliente
			super.getEntityManager().persist(super.getEntityManager().contains(evento) ? evento : super.getEntityManager().merge(evento));
			// Al persistirlos tenemos el id que genera la secuencia y hacemos el commit
			// para guardar los cambios
			super.getEntityManager().flush();
			TypedQuery<Evento> query = (TypedQuery<Evento>) super.getEntityManager()
					.createQuery("SELECT e FROM Evento e ORDER BY e.idEvento DESC", Evento.class);
			return query.getResultList().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cai en el syso de createvento");
			return null;
		}
	}
	
//	public Evento createEvento(Evento evento) {
//	    try {
//	        // Asegura que la entidad no esté ya manejada por el contexto de persistencia.
//	        if (!super.getEntityManager().contains(evento)) {
//	            evento = super.getEntityManager().merge(evento);
//	        }
//	        
//	        // Persiste y sincroniza con la base de datos.
//	        super.getEntityManager().persist(evento);
//	        super.getEntityManager().flush();
//	        super.getEntityManager().refresh(evento);
//
//	        // Retorna la entidad con el ID asignado.
//	        System.out.println("Evento creado con ID: " + evento.getIdEvento());
//	        return evento;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        System.out.println("Error en createEvento: " + e.getMessage());
//	        return null;
//	    }
//	}

//	public Evento createEvento(Evento evento) {
//	    try {
//	        // Asegura que la entidad no esté ya manejada por el contexto de persistencia.
//	        if (!super.getEntityManager().contains(evento)) {
//	            evento = super.getEntityManager().merge(evento);
//	        }
//
//	        // Persiste y sincroniza con la base de datos.
//	        super.getEntityManager().persist(evento);
//	        super.getEntityManager().flush();
//	        super.getEntityManager().refresh(evento);
//
//	        // Luego de la persistencia, recupera el último evento insertado para confirmar el ID
//	        Evento ultimoEvento = getLastInsertedEvento();
//	        if (ultimoEvento != null) {
//	            System.out.println("Último Evento creado con ID: " + ultimoEvento.getIdEvento());
//	            return ultimoEvento;
//	        } else {
//	            throw new IllegalStateException("No se pudo recuperar el último evento insertado.");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        System.out.println("Error en createEvento: " + e.getMessage());
//	        return null;
//	    }
//	}

	private Evento getLastInsertedEvento() {
	    List<Evento> eventos = super.getEntityManager().createQuery("SELECT e FROM Evento e ORDER BY e.idEvento DESC", Evento.class)
	                                .setMaxResults(1)
	                                .getResultList();
	    return eventos.isEmpty() ? null : eventos.get(0);
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
				eventoToUpdate.setActivo(false);
				
				int resultCode = update(eventoToUpdate);
				
				return resultCode == 0  ? 0 : -1;
			} catch(PersistenceException e) {
				return -1;
			}
		}
		
		public int activeEventBy(Long i) {
			try {
				Evento eventoToUpdate = selectById(i);
				eventoToUpdate.setActivo(true);
				
				int resultCode = update(eventoToUpdate);
				
				return resultCode == 0  ? 0 : -1;
			} catch(PersistenceException e) {
				return -1;
			}
		}
//	public int logicalDeleteBy(Long id) {
//	    try {
//	        Evento evento = super.getEntityManager().find(Evento.class, id);
//	        if (evento != null) {
//	            evento.setActivo((byte) 0);  // Desactivar el evento
//	            super.getEntityManager().merge(evento);  // Guardar cambios
//	            super.getEntityManager().flush();  // Sincronizar con la base de datos
//	            return 0;
//	        }
//	        return -1;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return -1;
//	    }
//	}
//
//	public int activeEventBy(Long id) {
//	    try {
//	        Evento evento = super.getEntityManager().find(Evento.class, id);
//	        if (evento != null) {
//	            evento.setActivo((byte) 1);  // Activar el evento
//	            super.getEntityManager().merge(evento);  // Guardar cambios
//	            super.getEntityManager().flush();  // Sincronizar con la base de datos
//	            return 0;
//	        }
//	        return -1;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return -1;
//	    }
//	}

	 
		
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
//	@Override
//	public int logicalDeleteByTitle(String title) {
//	    try {
//	        Evento eventoToUpdate = selectBy(title);  // Usamos el método selectBy para encontrar el evento por título
//	        if (eventoToUpdate == null) {
//	            return -1;  // No se encontró el evento
//	        }
//	        eventoToUpdate.setActivo((byte) 0);
//	        
//	        int resultCode = update(eventoToUpdate);  // Asume que existe un método update que actualiza un evento
//	        
//	        return resultCode == 0 ? 0 : -1;
//	    } catch(PersistenceException e) {
//	        return -1;  // Retorna -1 en caso de cualquier excepción de persistencia
//	    }
//	}
//
//	@Override
//	public int activeEventByTitle(String title) {
//	    try {
//	        Evento eventoToUpdate = selectBy(title);  // Igual que el método anterior, selecciona un evento por su título
//	        if (eventoToUpdate == null) {
//	            return -1;  // No se encontró el evento
//	        }
//	        eventoToUpdate.setActivo((byte) 1);
//	        
//	        int resultCode = update(eventoToUpdate);  // Asume que existe un método update que actualiza un evento
//	        
//	        return resultCode == 0 ? 0 : -1;
//	    } catch(PersistenceException e) {
//	        return -1;  // Manejo de errores
//	    }
//	}

//	@Override
//	public int update(Evento evento) {
//	    try {
//	        // Asegura que la entidad está manejada por el contexto de persistencia
//	        if (!super.getEntityManager().contains(evento)) {
//	            evento = super.getEntityManager().merge(evento);
//	        }
//	        
//	        // Sincroniza el estado del objeto con la base de datos
//	        super.getEntityManager().flush();
//	        
//	        return 0;  // Retorna 0 para indicar éxito
//	    } catch (PersistenceException e) {
//	        e.printStackTrace();
//	        return -1;  // Retorna -1 en caso de error
//	    }
//	}



}
