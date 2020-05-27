package filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;
import utils.Log;

@WebFilter("/*")
public class LogFilter implements Filter {
	FilterConfig filterConfig = null;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("logado");
		
		String comando = req.getParameter("command");
		if(comando == null) {
			comando = req.getRequestURI();
		}
		//criando um calendar com a data atual
		Calendar timestamp = Calendar.getInstance(); 
		String textoLog="";
		
		//pegando a url
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		
		
		
		if(usuario == null){
			System.out.println(comando);
			textoLog= String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL%tp] %s\n",timestamp, comando);
			
		} else {
			System.out.println(usuario.getEmail()+ " -> " +comando);
			textoLog= String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL%tp] %s -> %s\n",timestamp,usuario.getEmail(), comando);

		}
		synchronized(textoLog) {
			Log arqLog = new Log();
			arqLog.abrir(contextPath + File.separator + "log" + File.separator + Log.NOME);
			arqLog.escrever(textoLog);
			arqLog.fechar();
			/*
			 * arqLog.abrir(servletContext.getContextPath() + File.separator + "log" +
			 * File.separator + Log.NOME); arqLog.escrever(textoLog); arqLog.fechar();
			 */
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
