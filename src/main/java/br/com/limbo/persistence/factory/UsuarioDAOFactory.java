package br.com.limbo.persistence.factory;

import br.com.limbo.persistence.UsuarioDAO;
import br.com.limbo.persistence.UsuarioMemoriaDAO;

public class UsuarioDAOFactory {
	
	public static UsuarioDAO getDao(){
		return new UsuarioMemoriaDAO();
	}
	
}
