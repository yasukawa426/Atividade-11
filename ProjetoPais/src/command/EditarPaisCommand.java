package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paises;
import service.PaisService;

public class EditarPaisCommand implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		Double pArea = Double.parseDouble(request.getParameter("area"));
		Long pPop = Long.parseLong(request.getParameter("populacao"));
		
		//instanciar o javabean
		Paises pais = new Paises(pId,pNome,pPop,pArea);
		PaisService sv = new PaisService();
		sv.atualizar(pais);
		request.getRequestDispatcher("EditarPais.jsp").forward(request, response);

	}

}
