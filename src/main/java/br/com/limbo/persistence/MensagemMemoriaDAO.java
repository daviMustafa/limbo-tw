package br.com.limbo.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.limbo.domain.Mensagem;

public class MensagemMemoriaDAO implements MensagemDAO {

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	private static List<Mensagem> mensagens = new ArrayList<>();
	
	@Override
	public void salvar(Mensagem mensagem) {
		mensagem.setId( atomicInteger.incrementAndGet() );
		mensagens.add(mensagem);
	}

	@Override
	public List<Mensagem> listar() {
		return mensagens;
	}

	@Override
	public Mensagem buscarPorId(Integer id) {
		int index = mensagens.indexOf( new Mensagem(id) );
		return mensagens.get(index);
	}

	@Override
	public void atualizar(Mensagem mensagem) {
		int index = mensagens.indexOf(mensagem);
		mensagens.set( index , mensagem );
	}
	
	

}
