package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.ActualitesService;

@WebServlet("/admin/delete/actu") // mapping de la servlet (url)
public class DeleteActuServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idActu = Integer.parseInt(req.getParameter("idActu"));
		ActualitesService.getInstance().addActualites(idActu, null, null); // on ajoute une nouvelle actualité
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
}
