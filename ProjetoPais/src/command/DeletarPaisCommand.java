package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PaisService;

public class DeletarPaisCommand implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("deletId"));
		
		PaisService sv = new PaisService();
		sv.excluir(pId);
		request.getRequestDispatcher("View.jsp").forward(request, response);

	}

}
