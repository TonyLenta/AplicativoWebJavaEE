package com.generico.dao;

import javax.ejb.Stateless;
import com.ejb.model.Publicaciones;

@Stateless(name="ejbPublicacionesGenerico")
public class ejbPublicacionesGenerico extends GenericDao<Publicaciones>{

	public ejbPublicacionesGenerico() {
		super(Publicaciones.class);
	}
		
	public Iterable<Publicaciones> findAll(){
		return super.findAll();
	}
	public void delete(Publicaciones p) {
		super.delete(p);
	}
	public void save(Publicaciones p) {
		super.save(p);
	}
	public void update(Publicaciones p) {
		super.update(p);
	}
	public Publicaciones findId(Integer entityId) {
		return super.findId(entityId);
	}
	public Publicaciones find(Publicaciones p) {
		return super.find(p);
	}

}
