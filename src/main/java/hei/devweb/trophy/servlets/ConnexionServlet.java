package hei.devweb.trophy.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */


@WebServlet("/connexion") // mapping de la servlet (url)
public class ConnexionServlet extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String,String> adminAutorise;	
	
	@Override
	public void init() throws ServletException {
		adminAutorise=new HashMap<>();
		adminAutorise.put("admin@hei.fr", "mdp"); // on défini les identifiants qui autorisent la connexion
				
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idadminConnecte = (String) request.getSession().getAttribute("adminConnecte");
		
		if (idadminConnecte == null || "".equals(idadminConnecte)) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/connexion.html");
			view.forward(request, response);
			
		} else {
			response.sendRedirect("admin/accueil"); // si la connexion est réussie, on arrive sur l'accueil de l'admin
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiantSaisi = request.getParameter("email");
		String motDePasseSaisi = request.getParameter("key");
			if(identifiantSaisi=="admin@hei.fr" && motDePasseSaisi=="mdp");
			{
				request.getSession().setAttribute("adminConnecte",identifiantSaisi);
			}
			
			response.sendRedirect("connexion"); // si la connexion n'est pas réussie, on retourne sur la page connexion
	
	}
}