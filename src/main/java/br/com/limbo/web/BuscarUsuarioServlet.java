package br.com.limbo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.limbo.persistence.UsuarioDAO;
import br.com.limbo.persistence.UsuarioMemoriaDAO;

@WebServlet("/buscar")
public class BuscarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/usuario/buscar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usuarioDao = new UsuarioMemoriaDAO();
		
		String filtro = request.getParameter("filtro");
		
		request.setAttribute("usuarios", usuarioDao.procurar(filtro));
		request.getRequestDispatcher("/WEB-INF/jsp/usuario/buscar.jsp").forward(request, response);
	}

}
