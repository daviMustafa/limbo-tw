package br.com.limbo.persistence;

import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.exception.UsuarioNaoEncontradoException;

public interface UsuarioDAO {

	void salvar(Usuario usuario);

	Usuario porEmailESenha(String email, String senha) throws UsuarioNaoEncontradoException ;
	
}
