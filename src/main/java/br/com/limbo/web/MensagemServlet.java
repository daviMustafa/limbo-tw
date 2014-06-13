package br.com.limbo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.limbo.domain.Mensagem;
import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.MensagemDAO;
import br.com.limbo.persistence.factory.MensagemDAOFactory;

/**
 * Servlet implementation class MensagemServlet
 */
@WebServlet("/mensagem")
public class MensagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MensagemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MensagemDAO mensagemDAO = MensagemDAOFactory.getDao();
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if ("curtir".equals( request.getParameter("acao") )) {
			String id = request.getParameter("id");
			Mensagem msg = mensagemDAO.buscarPorId( Integer.parseInt(id) );
			msg.getUsuarios().add(usuario);
			mensagemDAO.atualizar(msg);
		}
	}

}
