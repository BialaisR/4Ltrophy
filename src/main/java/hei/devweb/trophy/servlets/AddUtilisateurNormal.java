package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.UtilisateurService;


@WebServlet("/addutilisateurnormal")
public class AddUtilisateurNormal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motDePasse");
		
		
		UtilisateurService.getInstance().addUtilisateur(identifiant, motdepasse, nom, prenom, email, null, null, null, null, null, null);
	}

}
