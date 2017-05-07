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

/* code en preparation pour l'import de photo
 * 
 * 
 * package hei.devweb.trophy.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

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
		File photo = req.getParameter("photo");
		String classe = req.getParameter("classe");
		
		String encodedphoto = encodeFileToBase64Binary(photo);
		
		


		UtilisateurService.getInstance().addUtilisateur(null, nom, prenom, mail, encodedphoto, classe);
		
		 resp.sendRedirect("../equipage");
		
	}
	
	private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
	
}


*/
