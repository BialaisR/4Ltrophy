package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.UtilisateurService;



@WebServlet("/admin/send/user")
public class SendUserServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String mail = req.getParameter("mail");
		String photo = req.getParameter("photo");
		String classe = req.getParameter("classe");
		
		UtilisateurService.getInstance().addUtilisateur(null, nom, prenom, mail, photo, classe);
		
		 resp.sendRedirect("../equipage");
		
	}
	
}
