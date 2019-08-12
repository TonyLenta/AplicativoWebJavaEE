package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Parroquia;

@Local
public interface ParroquiaSession {

	public Parroquia buscar(Parroquia pa);
	public String grabar(Parroquia pa);
	public String actualizar(Parroquia pa);
	public String eliminar(Parroquia pa);
	public List <Parroquia> listar(int id);
	public Parroquia buscarporId(int id);
}
