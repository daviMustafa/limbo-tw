package br.com.limbo.web;

import generics.PreenchedorDeObjeto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

		req.getRequestDispatcher("/WEB-INF/jsp/usuario/cadastro.jsp").forward(
				req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PreenchedorDeObjeto preenchedor = new PreenchedorDeObjeto();
		
		Usuario usuario = preenchedor.preencher( Usuario.class, req );
		UsuarioDAO usuarioDAO = new UsuarioMemoriaDAO();

		Map<String, String> errorMap = isValid(usuario);
		req.setAttribute("errorMap",  errorMap );
		req.setAttribute("usuario" ,  usuario );
		
		if ( errorMap.isEmpty()  ) {
			usuarioDAO.salvar(usuario);
			req.setAttribute("msg",	"Usuário cadastrado com sucesso, seu merda!");
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/usuario/cadastro.jsp").forward(
				req, resp);
	}
	
	private Map<String, String> isValid( Usuario usuario ){
		Map<String,String> errorMap = new HashMap<String, String>();
		
		if (("").equals( usuario.getNickname() ) || usuario.getNickname() == null) {
			errorMap.put("nickname", "Nickname inválido" );
		}
		if ("".equals( usuario.getEmail() ) || usuario.getEmail() == null) {
			errorMap.put("email", "Email inválido" );
		}
		if ("".equals( usuario.getSenha() ) || usuario.getSenha() == null) {
			errorMap.put("senha", "Senha invalida" );
		}
		if ( usuario.getSenha() != null && ! usuario.getSenha().equals( usuario.getConfirmarSenha() ) ) {
			errorMap.put("confirmarSenha", "Confirmação de senha invalida" );
		}
		
		return errorMap;
	}
	
}
