package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import hei.devweb.trophy.pojos.Utilisateur;
import hei.devweb.trophy.services.UtilisateurService;


@WebServlet("/addUtilisateur")
public class AddUtilisateur extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		String identifiant= req.getParameter("nomheros");
		String motDePasse = req.getParameter("identite_secrete");
		String nom = req.getParameter("groupe");
		String prenom= req.getParameter("franchise");
		String mail = req.getParameter("description");

		
		Utilisateur UtilisateurtoAdd = new Utilisateur();
		UtilisateurService.getInstance().addUtilisateur(UtilisateurtoAdd);
			
		resp.sendRedirect("Héros");

	}

}
