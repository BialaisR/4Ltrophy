package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.SujetService;

@WebServlet("/admin/delete/sujet") // mapping de la servlet (url)
public class DeleteSujetServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idSujet = Integer.parseInt(req.getParameter("idSujet"));
		SujetService.getInstance().addSujet(idSujet, null, null, null, null, null); // on supprime un sujet
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
}