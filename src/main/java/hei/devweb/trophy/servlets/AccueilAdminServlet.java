package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.trophy.services.ActualitesService;
import hei.devweb.trophy.services.EvenementsService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/admin/accueil") // mappage de la servlet (url)
public class AccueilAdminServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, getServletContext());
		context.setVariable("actualites",ActualitesService.getInstance().listActualites()); // on utilise la methode listActualites
		context.setVariable("evenements",EvenementsService.getInstance().listEvenements()); // on utilise la methode listEvenements
		
		templateEngine.process("accueilAdmin", context, resp.getWriter());    // page html associée
		
	}
	
	

	

}
