package com.generico.session;

import com.ejb.model.Publicaciones;

public interface GenericSession <T> {
    
	public void save(T entity);
	
	public void update(T entity);
	
	public void find(T entity);

	public Publicaciones findId(Integer entityId);
	
	public void delete(T entity);
	
	public Iterable<T> findAll();

}
