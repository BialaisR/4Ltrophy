package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.ActualitesService;



@WebServlet("/admin/send/actu")
public class SendActuServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titreActu = req.getParameter("titreActu");
		String actu = req.getParameter("actu");
		
		// Ne fonctionne pas
		ActualitesService.getInstance().addActualites(null, titreActu, actu);
		
		resp.sendRedirect("../accueil");
		
	}
	
}
