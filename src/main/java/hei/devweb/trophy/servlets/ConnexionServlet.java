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
import javax.swing.JOptionPane;

import hei.devweb.trophy.crypt.Cryptage;


@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,String> adminAutorise;
	
	/* private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}     */
	
	@Override
	public void init() throws ServletException {
		adminAutorise=new HashMap<>();
		adminAutorise.put("admin@hei.fr", "fbab60f46fa060f86b599e190e77411eec5570fe1f8cfc61:5099dd695c24be2ea2cf6bbc1222ccacebfb26085469a68f");
				
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAdminConnecte = (String) request.getSession().getAttribute("adminConnecte");
		if (idAdminConnecte == null || "".equals(idAdminConnecte)) {
			//msgbox("Mot de passe ou identifiant incorrect(s)");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/connexion.html");
			view.forward(request, response);
			
		} else {
			response.sendRedirect("admin/accueil");
		}
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiantSaisi = request.getParameter("email");
		String motDePasseSaisi = request.getParameter("key");
		try {
			if(adminAutorise.containsKey(identifiantSaisi) && Cryptage.validerMotDePasse(motDePasseSaisi, adminAutorise.get(identifiantSaisi)))
			{
				request.getSession().setAttribute("adminConnecte",identifiantSaisi);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			response.sendRedirect("connexion");
	}
}