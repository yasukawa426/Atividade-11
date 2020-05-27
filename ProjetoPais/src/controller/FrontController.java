package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
@WebServlet(name="FrontController", urlPatterns= {"/index.jsp","/FrontController"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("command") == null) {
			try {
				
				request.setCharacterEncoding("UTF-8");
				Command comando = 
				(Command) Class.forName("command.ListarPaisCommand").newInstance();
				comando.executar(request, response);
			}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
				e.printStackTrace();
				throw new ServletException(e);
			}	
		}
		else {
			try {
				
				request.setCharacterEncoding("UTF-8");
				Command comando = 
				(Command) Class.forName("command." + request.getParameter("command")).newInstance();
				comando.executar(request, response);
			}catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
				e.printStackTrace();
				throw new ServletException(e);
			}	
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}

}
