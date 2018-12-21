package org.apiRestv1.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<E, ID extends Serializable> {
	
	public void saveOrUpdate(E entity);
	public void remove(E entity);
	public E load(ID key);
	public List<E> getAll();
	
}
