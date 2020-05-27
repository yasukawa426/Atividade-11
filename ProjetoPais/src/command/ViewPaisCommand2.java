package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paises;
import service.PaisService;

public class ViewPaisCommand2 implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("id"));
		
		PaisService sv= new PaisService();
		Paises pais= new Paises();
		pais=sv.carregar(pId);
		
		
		request.setAttribute("pais", pais);
		request.getRequestDispatcher("View.jsp").forward(request, response);	

	}

}
