package br.com.limbo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.limbo.domain.Usuario;
import br.com.limbo.persistence.UsuarioDAO;
import br.com.limbo.persistence.exception.UsuarioNaoEncontradoException;
import br.com.limbo.persistence.factory.UsuarioDAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getParameter("cadastradoComSucesso") != null){
			req.setAttribute("mensagem",	"Usuário cadastrado com sucesso.");
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		UsuarioDAO dao = UsuarioDAOFactory.getDao();
		try {
			Usuario usuario = dao.porEmailESenha( email , senha );
			HttpSession session = req.getSession(true);
			session.setAttribute("usuario", usuario);
			resp.sendRedirect( req.getContextPath() + "/index");
		} catch (UsuarioNaoEncontradoException e) {
			req.setAttribute("mensagem", "Usuário e/ou senha invalidos.");
			req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
		}
	}
	
}
