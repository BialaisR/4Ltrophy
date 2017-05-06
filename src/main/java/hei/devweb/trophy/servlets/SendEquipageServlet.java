package hei.devweb.trophy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.EquipagesService;



@WebServlet("/admin/send/equipage")
public class SendEquipageServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomEquipage = req.getParameter("nomEquipage");
		String identifParticipant1 = req.getParameter("identifParticipant1");
		String identifParticipant2 = req.getParameter("identifParticipant2");
		String descriptionEquipage = req.getParameter("descriptionEquipage");
		String photoEquipage = req.getParameter("photoEquipage");
		
		
		// Ne fonctionne pas
		EquipagesService.getInstance().addEquipages(null, nomEquipage,identifParticipant1,identifParticipant2,descriptionEquipage,photoEquipage);
		
		 resp.sendRedirect("../equipage");
		
	}
	
}
