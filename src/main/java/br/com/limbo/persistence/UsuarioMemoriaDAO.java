package br.com.limbo.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.limbo.domain.Usuario;

public class UsuarioMemoriaDAO implements UsuarioDAO {
	
	private static List<Usuario> usuariosSalvos = new ArrayList<>();

	@Override
	public void salvar(Usuario usuario) {
		usuariosSalvos.add(usuario);
	}

}
