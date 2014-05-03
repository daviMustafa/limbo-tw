package br.com.limbo.persistence;

import java.util.List;

import br.com.limbo.domain.Usuario;

public interface UsuarioDAO {

	void salvar(Usuario usuario);
	List<Usuario> procurar(String filtro);
	
}
