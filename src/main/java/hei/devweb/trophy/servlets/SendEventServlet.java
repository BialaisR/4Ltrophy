package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.ActualitesService;
import hei.devweb.trophy.services.EvenementsService;



@WebServlet("/admin/send/evenement")
public class SendEventServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dateEvent = req.getParameter("dateEvent");
		String event = req.getParameter("event");
		
		// ne fonctionne pas
		// EvenementsService.getInstance().addEvenements(null,dateEvent,event);
		
		resp.sendRedirect("../accueil");
		
	}
	
}
