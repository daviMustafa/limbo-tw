package br.com.limbo.web;

import java.io.IOException;
import java.util.Date;

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

@WebServlet("/mensagem/nova")
public class CadastroMensagemServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		String corpo = req.getParameter("corpo");
		if( corpo != null && !corpo.trim().isEmpty() ) {
			Mensagem msg = new Mensagem();
			msg.setCorpo(corpo);
			msg.setDataPublicao(new Date());
			HttpSession se = req.getSession();
			Usuario usuario = (Usuario)se.getAttribute("usuario");
			msg.setAutor(usuario);
			
			MensagemDAO dao = MensagemDAOFactory.getDao();		
			dao.salvar(msg);
			req.setAttribute("mensagem", "Mensagem postado com Sucesso!");
		}else{
			req.setAttribute("mensagem", "A Mensagem não pode ser vazia!");
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/mensagem/nova.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/mensagem/nova.jsp").forward(req, resp);
		
	}
}
