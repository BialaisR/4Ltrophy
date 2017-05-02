package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.SujetService;


@WebServlet("/envoyernouveausujet")
public class EnvoyerNouveauSujetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomSujet = request.getParameter("nomSujet");

		SujetService.getInstance().addSujet(null, nomSujet, null, null, null, null);
	}

}