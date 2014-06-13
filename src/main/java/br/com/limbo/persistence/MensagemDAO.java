package br.com.limbo.persistence;

import java.util.List;

import br.com.limbo.domain.Mensagem;

public interface MensagemDAO {
	
	void salvar(Mensagem mensagem);
	
	void atualizar(Mensagem mensagem);
	
	List<Mensagem> listar();
	
	Mensagem buscarPorId(Integer id);
	
}
