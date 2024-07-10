package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Evento;
import com.entities.Tutor;

@Remote
public interface TutorBeanRemote extends CRUDRemote<Tutor, Long> {
    
    List<Tutor> selectByUsernames(List<String> nombresUsuarios);

    boolean asignarEventoTutor (Evento evento, Tutor tutor);

	Tutor selectUserBy(String username);

	Long buscarIdPorUsuario(String nombreUsuario);
  
}
