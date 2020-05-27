package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paises;
import service.PaisService;

public class ListarPaisCommand implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaisService service = new PaisService();
		List<Paises> paises = service.listar();
		request.setAttribute("paises", paises);
		request.getRequestDispatcher("Home.jsp").
									forward(request, response);

	}

}
