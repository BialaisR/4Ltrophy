package hei.devweb.trophy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.devweb.trophy.services.MessageService;

@WebServlet("/admin/delete/message") // mapping de la servlet (url)
public class DeleteMessageServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3101071491815001778L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idMessage = Integer.parseInt(req.getParameter("idMessage"));
		MessageService.getInstance().addMessage(idMessage, null, null, idMessage); // on supprime un message
		
		resp.sendRedirect("../accueil"); // redirection vers l'accueil
		
	}
}
