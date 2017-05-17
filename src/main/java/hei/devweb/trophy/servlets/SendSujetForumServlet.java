package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.SujetService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/send/newdiscussion") // mapping de la servlet (url)
public class SendSujetForumServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomSujet = req.getParameter("nomSujet");
		//String  = req.getParameter("actu");
		SujetService.getInstance().addSujet(null, nomSujet, null, null, null, null); // on ajoute une nouvelle actualité
		
		resp.sendRedirect("../forum"); // redirection vers l'accueil
		
	}
	
}
