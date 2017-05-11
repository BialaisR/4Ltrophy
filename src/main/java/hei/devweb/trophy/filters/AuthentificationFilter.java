package hei.devweb.trophy.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Filtre permettant d'empêcher l'accès aux pages administrateur si on n'est pas connecté en tant que tel


@WebFilter("/AuthentificationFilter")
public class AuthentificationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String identifiant = (String) httpRequest.getSession().getAttribute("adminConnecte");
		if (identifiant == null || "".equals(identifiant)) {
			System.out.println("Il faut être connecté pour accéder à cette page !");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("../connexion");   // si on essaie d'accéder à une page admin, on arrive sur connexion
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
	}



}


