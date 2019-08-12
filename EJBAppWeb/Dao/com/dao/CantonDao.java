package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Canton;

@Local
public interface CantonDao {
	public Canton buscar(Canton c);
	public String grabar(Canton c);
	public String actualizar(Canton c);
	public String eliminar(Canton c);
	public List <Canton> listar(int id);
	public Canton buscarporId(int id);
}
