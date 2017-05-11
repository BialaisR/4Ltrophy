package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.ActualitesService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/admin/send/actu") // mapping de la servlet (url)
public class SendActuServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titreActu = req.getParameter("titreActu");
		String actu = req.getParameter("actu");
		ActualitesService.getInstance().addActualites(null, titreActu, actu); // on ajoute une nouvelle actualité
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
	
}
