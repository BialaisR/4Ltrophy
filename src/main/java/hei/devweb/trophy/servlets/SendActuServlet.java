package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.trophy.pojos.Actualites;
import hei.devweb.trophy.services.ActualitesService;



@WebServlet("/send/actu")
public class SendActuServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titreActu = req.getParameter("titreActu");
		String actu = req.getParameter("actu");
		
		ActualitesService.getInstance().addActualites(null, titreActu, actu);
		
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, getServletContext());
		
		templateEngine.process("accueil", context, resp.getWriter());
		
	}
	
}
