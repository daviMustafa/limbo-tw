package br.com.limbo.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.exception.UsuarioNaoEncontradoException;

public class UsuarioMemoriaDAO implements UsuarioDAO {
	
	private static List<Usuario> usuariosSalvos = new ArrayList<>();

	@Override
	public void salvar(Usuario usuario) {
		usuariosSalvos.add(usuario);
	}

	@Override
	public Usuario porEmailESenha(String email, String senha) throws UsuarioNaoEncontradoException {
		for (Usuario usuario : usuariosSalvos) {
			if( usuario.getEmail().equals(email)  && usuario.getSenha().equals(senha) ){
				return usuario;
			}
		}
		throw new UsuarioNaoEncontradoException();
	}

}
