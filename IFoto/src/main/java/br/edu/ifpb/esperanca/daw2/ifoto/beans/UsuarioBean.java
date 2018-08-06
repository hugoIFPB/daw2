package br.edu.ifpb.esperanca.daw2.ifoto.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.esperanca.daw2.dao.DAO;
import br.edu.ifpb.esperanca.daw2.dao.UsuarioDAO;
import br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario;

@ViewScoped
@Named
public class UsuarioBean extends GenericBean<Usuario>{

	@Inject
	private UsuarioDAO dao;
	
	@Override
	protected Usuario newEntidade() {
		return new Usuario();
	}

	@Override
	protected DAO<Usuario> getDAO() {
		return dao;
	}
	
}
