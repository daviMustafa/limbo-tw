package br.com.limbo.persistence;

import br.com.limbo.domain.Usuario;

public interface UsuarioDAO {

	void salvar(Usuario usuario);

	Usuario porEmailESenha(String email, String senha) throws UsuarioNaoEncontradoException ;
	
}
