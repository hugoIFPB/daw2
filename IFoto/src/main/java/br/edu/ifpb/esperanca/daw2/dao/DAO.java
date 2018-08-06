package br.edu.ifpb.esperanca.daw2.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifpb.esperanca.daw2.ifoto.entities.Identificavel;

@ApplicationScoped
public abstract class DAO<E extends Identificavel> {

	@Inject
	private EntityManager em;

	private Class<E> classe;

	public DAO() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		classe = (Class<E>) parameterizedType.getActualTypeArguments()[0];
	}

	public void save(E obj) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(obj);
		transaction.commit();
	}

	public E update(E obj) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		E resultado = obj;
		resultado = em.merge(obj);
		transaction.commit();
		return resultado;
	}

	public void remove(E obj) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		obj = getByID(obj.getId());
		em.remove(obj);
		transaction.commit();
	}

	public E getByID(Long objId) {
		return em.find(classe, objId);
	}

	public List<E> getAll() {
		Query query = em.createQuery("from " + classe.getSimpleName());
		return query.getResultList();
	}

}
