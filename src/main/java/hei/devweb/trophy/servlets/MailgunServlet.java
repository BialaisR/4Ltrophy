package hei.devweb.trophy.servlets;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/* Les servlets permettent de relier notre back-end avec notre front-end 
 * et définissent les méthodes qui seront utilisées sur cette page
 */

/* Ce code est fourni par le site officiel de MailGun */

@SuppressWarnings("serial")
@WebServlet(name = "mailgun", value = "/contact/send/email") // mapping de la servlet (url)
public class MailgunServlet extends AbstractGenericServlet {

	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String prenomContact = req.getParameter("prenomContact");
    String nomContact = req.getParameter("nomContact");
    String mailContact = req.getParameter("mailContact");
    String messageContact = req.getParameter("messageContact");
   
    SendSimpleMessage(prenomContact, nomContact, mailContact, messageContact);
    resp.sendRedirect("../../contact");
  }

  public static ClientResponse SendSimpleMessage(String prenomContact, String nomContact, String mailContact, String messageContact) {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter(
	        "api","key-e419616c0bd414810748f5fc59636a35"));
	    WebResource webResource = client.resource(
	        "https://api.mailgun.net/v3/sandboxaae99410e2e74bbc9d80aaceac26cc8c.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "4L TROPHY : Message d'un contact <postmaster@sandboxaae99410e2e74bbc9d80aaceac26cc8c.mailgun.org>");
	    /*formData.add("to","hei.4l-trophy@hei.yncrea.fr"); */
	    formData.add("subject", "Envoyé par "+prenomContact+"  "+nomContact);
	    formData.add("text", "De : "+prenomContact+" "+nomContact+"\nAdresse mail : "+mailContact+"\n\nMessage :\n"+messageContact);
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	        post(ClientResponse.class, formData);
	}
}
