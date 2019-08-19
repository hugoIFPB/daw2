package br.edu.ifpb.esperanca.daw2.dao;

import java.util.List;

import br.edu.ifpb.esperanca.daw2.filtros.UsuarioFiltro;
import br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario;

/**
 * Classe utilizada para gerenciar objetos da entidade Usuario
 *
 **/
public class UsuarioDAO extends DAO<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

	public List<Usuario> findBy(UsuarioFiltro filtro) {
		return null;
	}
	
}
