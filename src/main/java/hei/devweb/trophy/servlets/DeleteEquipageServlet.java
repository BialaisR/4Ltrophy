package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.EquipagesService;

@WebServlet("/admin/delete/equipage") // mapping de la servlet (url)
public class DeleteEquipageServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idEquipage = Integer.parseInt(req.getParameter("numeroEquipage"));
		EquipagesService.getInstance().addEquipages(idEquipage, null, null, null, null, null, null, null, null, null, null, null, null, null); // on supprime un equipage
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
}