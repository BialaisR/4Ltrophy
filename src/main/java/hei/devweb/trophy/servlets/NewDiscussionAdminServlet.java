package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.trophy.services.SujetService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/admin/newdiscussion") // mapping de la servlet (url)
public class NewDiscussionAdminServlet extends AbstractGenericServlet{
	
	
	private static final long serialVersionUID = 7319632053290138313L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setCharacterEncoding("UTF-8");
			TemplateEngine templateEngine = this.createTemplateEngine(req);
			WebContext context = new WebContext(req, resp, getServletContext());
			context.setVariable("sujet",SujetService.getInstance().listSujet()); // on utilise la methode listSujet
			
			templateEngine.process("newdiscussionAdmin", context, resp.getWriter()); // page html associée
			
			
		}
		

		

	}

