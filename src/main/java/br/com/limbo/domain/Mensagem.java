package br.com.limbo.domain;

import java.util.Date;

public class Mensagem {
	private Integer id;
	private Date dataPublicao;
	private String corpo;
	private Usuario autor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataPublicao() {
		return dataPublicao;
	}
	public void setDataPublicao(Date dataPublicao) {
		this.dataPublicao = dataPublicao;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
}
