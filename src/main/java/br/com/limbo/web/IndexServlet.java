package br.com.limbo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = { "/index" , "/" } )
public class IndexServlet extends HttpServlet{
	
	private static final long serialVersionUID = -8501209473195210205L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/index/home.jsp").forward(req, resp);
	}
	
}
