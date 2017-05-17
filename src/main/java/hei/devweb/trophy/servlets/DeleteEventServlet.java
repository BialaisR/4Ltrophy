package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.EvenementsService;

@WebServlet("/admin/delete/event") // mapping de la servlet (url)
public class DeleteEventServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idEvent = Integer.parseInt(req.getParameter("idEvent"));
		EvenementsService.getInstance().addEvenements(idEvent, null, null); // on supprime un événement
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
}
