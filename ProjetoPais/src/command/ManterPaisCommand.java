package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paises;
import service.PaisService;

public class ManterPaisCommand implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		Double pArea = Double.parseDouble(request.getParameter("area"));
		Long pPop = Long.parseLong(request.getParameter("populacao"));
		
		//instanciar o javabean
		Paises pais = new Paises();
		pais.setNome(pNome);
		pais.setArea(pArea);
		pais.setPopulacao(pPop);
		
		//instanciar o service
		PaisService ps = new PaisService();
		
		ps.criar(pais);
		
		List <Paises> paises = ps.listar();
		
		request.setAttribute("paises", paises);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);

	}

}
