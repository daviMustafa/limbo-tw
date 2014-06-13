package br.com.limbo.persistence.factory;

import br.com.limbo.persistence.MensagemDAO;
import br.com.limbo.persistence.MensagemMemoriaDAO;

public class MensagemDAOFactory {
	
	public static MensagemDAO getDao(){
		return new MensagemMemoriaDAO();
	} 
	
}
