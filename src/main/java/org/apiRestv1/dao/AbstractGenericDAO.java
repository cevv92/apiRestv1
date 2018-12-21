package org.apiRestv1.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public abstract class AbstractGenericDAO<E, ID extends Serializable> implements IGenericDAO<E,ID>{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	@SuppressWarnings("unchecked")
	public AbstractGenericDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class<? extends E>) pt.getActualTypeArguments()[0];
		System.out.print("DAO NAME: "+ daoType.getSimpleName());
	}
	
	protected Session getCurrentSession() {
		return  sessionFactory.getCurrentSession();
	}
	
	public void saveOrUpdate(E entity) {
		getCurrentSession().saveOrUpdate(entity);
	}
	
	public void remove(E entity) {
		getCurrentSession().remove(entity);
	}
	
	public E load(ID key) {
		return (E) getCurrentSession().get(daoType, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> getAll(){
		return getCurrentSession().createQuery( "from " + daoType.getSimpleName() ).list();
		
	}
}
