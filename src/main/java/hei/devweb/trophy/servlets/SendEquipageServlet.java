package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.EquipagesService;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

@WebServlet("/admin/send/equipage") // mapping de la servlet (url)
public class SendEquipageServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomEquipage = req.getParameter("nomEquipage");
		String descriptionEquipage = req.getParameter("descriptionEquipage");
		String nom1 = req.getParameter("nom1");
		String nom2 = req.getParameter("nom2");
		String prenom1 = req.getParameter("prenom1");
		String prenom2 = req.getParameter("prenom2");
		String mail1 = req.getParameter("mail1");
		String mail2 = req.getParameter("mail2");
		String classe1 = req.getParameter("classe1");
		String classe2 = req.getParameter("classe2");
		String photo1 = req.getParameter("photo1");
		String photo2 = req.getParameter("photo2");
		String photoEquipage = req.getParameter("photoEquipage");
		
		EquipagesService.getInstance().addEquipages(null, nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1,
				mail2, classe1, classe2, photo1, photo2, photoEquipage);
		// on ajoute un nouvel équipage
		
		resp.sendRedirect("../equipage"); // redirection vers la page équipages
			
		
	}
	
}
