package br.com.limbo.persistence;

import java.util.List;

import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.exception.UsuarioNaoEncontradoException;

public interface UsuarioDAO {

	void salvar(Usuario usuario);

	List<Usuario> procurar(String filtro);

	Usuario porEmailESenha(String email, String senha) throws UsuarioNaoEncontradoException ;
	
}
