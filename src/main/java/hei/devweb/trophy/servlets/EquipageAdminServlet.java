package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.trophy.services.EquipagesService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/admin/equipage") // mapping de la servlet (url)
public class EquipageAdminServlet extends AbstractGenericServlet{
	
	private static final long serialVersionUID = -3101071491815001778L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, getServletContext());
		context.setVariable("equipages",EquipagesService.getInstance().listEquipages()); // on utilise la methode listEquipages
		
		templateEngine.process("equipageAdmin", context, resp.getWriter()); // page html associée
		
	}

}
