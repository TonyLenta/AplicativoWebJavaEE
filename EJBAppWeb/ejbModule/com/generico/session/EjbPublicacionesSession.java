package com.generico.session;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ejb.model.Publicaciones;
import com.generico.dao.ejbPublicacionesGenerico;

@Stateless(name="ejbPublicacionesSessionGenerico")
public class EjbPublicacionesSession implements GenericSession<Publicaciones>{

	public EjbPublicacionesSession() {
		super();
	}
	
	//Implementacion de los jpa desde el dao
	@EJB
	private ejbPublicacionesGenerico ejbPublicacionesGenerico;
	
	
	@Override
	public void save(Publicaciones entity) {
		ejbPublicacionesGenerico.save(entity);
		
	}

	@Override
	public void update(Publicaciones entity) {
		ejbPublicacionesGenerico.update(entity);
	}

	@Override
	public void find(Publicaciones entity) {
		ejbPublicacionesGenerico.find(entity);
		
	}

	@Override
	public Publicaciones findId(Integer entityId) {
		return ejbPublicacionesGenerico.findId(entityId);
		
	}

	@Override
	public void delete(Publicaciones entity) {
		ejbPublicacionesGenerico.delete(entity);
		
	}

	@Override
	public Iterable<Publicaciones> findAll() {	
		return ejbPublicacionesGenerico.findAll();
	}

}