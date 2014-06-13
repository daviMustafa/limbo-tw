package br.com.limbo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.limbo.domain.Mensagem;
import br.com.limbo.persistence.MensagemDAO;
import br.com.limbo.persistence.factory.MensagemDAOFactory;

/**
 * Servlet implementation class ListarMensagensServlet
 */
@WebServlet("/mensagem/listar")
public class ListarMensagensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarMensagensServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MensagemDAO mensagemDAO = MensagemDAOFactory.getDao();
		request.setAttribute("mensagens" ,mensagemDAO.listar() );
		request.getRequestDispatcher("/WEB-INF/jsp/mensagem/listar.jsp").forward(request, response);;
		
	}

}
