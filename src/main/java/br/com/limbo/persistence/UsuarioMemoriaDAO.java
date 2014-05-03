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

	@Override
	public List<Usuario> procurar(String filtro) {
		
		List<Usuario> filtroUsuario = new ArrayList<>();
		
		for(Usuario usuario: usuariosSalvos){
			if(usuario.getNickname().contains(filtro)){
				filtroUsuario.add(usuario);
			}
		}
		return filtroUsuario;
	}
	
	

}
