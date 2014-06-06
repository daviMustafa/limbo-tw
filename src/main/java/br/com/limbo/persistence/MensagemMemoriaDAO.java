package br.com.limbo.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.limbo.domain.Mensagem;

public class MensagemMemoriaDAO implements MensagemDAO {

	private static List<Mensagem> mensagens = new ArrayList<>();
	
	@Override
	public void salvar(Mensagem mensagem) {
		mensagens.add(mensagem);
	}

}
