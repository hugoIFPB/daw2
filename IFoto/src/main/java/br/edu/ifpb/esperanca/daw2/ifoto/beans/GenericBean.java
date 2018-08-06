package br.edu.ifpb.esperanca.daw2.ifoto.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import br.edu.ifpb.esperanca.daw2.dao.DAO;
import br.edu.ifpb.esperanca.daw2.ifoto.entities.Identificavel;

public abstract class GenericBean<E extends Identificavel> implements Serializable{

	protected E entidade;
	
	protected Collection<E> entidades;
	
	public GenericBean() {
		init();
	}
	
	private void init() {
		entidade = newEntidade();
		entidades = getDAO().getAll();
	}
	
	public void remove(E entidade) {
		getDAO().remove(entidade);
		limpar(); 
	}

	
	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

	public Collection<E> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<E> entidades) {
		this.entidades = entidades;
	}

	
	public void save() {
		getDAO().save(entidade);
		limpar();
	}
	
	
	
	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}
	
	public void limpar() {
		entidades = getDAO().getAll();
		entidade = newEntidade();
	}
	
	protected abstract DAO<E> getDAO();
	
	protected abstract E newEntidade();
	
}
