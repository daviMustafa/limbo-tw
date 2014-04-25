package br.com.limbo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.UsuarioDAO;
import br.com.limbo.persistence.UsuarioMemoriaDAO;

@WebServlet("/cadastro")
public class CadastroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -2802662546491660294L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jsp/usuario/cadastro.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioMemoriaDAO();

		usuario.setNickname(req.getParameter("nickname"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setSenha(req.getParameter("senha"));
		usuarioDAO.salvar(usuario);
		req.setAttribute("msg", "Usuário cadastrado com sucesso, seu merda!");
		req.getRequestDispatcher("/WEB-INF/jsp/usuario/cadastro.jsp").forward(req, resp);
		
	}
	
}
