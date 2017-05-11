package hei.devweb.trophy.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/* Cette classe permet de définir les paramètres communs à toutes nos servlet :
 * comme ça, il nous suffir que chaque servlet "extends" celle ci pour
 * obtenir tous ces paramètres
 */
public abstract class AbstractGenericServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected TemplateEngine createTemplateEngine(HttpServletRequest request) {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());
		templateResolver.setPrefix("WEB-INF/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.addDialect(new Java8TimeDialect());
		templateEngine.setTemplateResolver(templateResolver);
		
		return templateEngine;
	}

}
