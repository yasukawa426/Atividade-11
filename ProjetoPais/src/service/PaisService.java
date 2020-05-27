package service;
import java.util.List;

import dao.PaisesDAO;
import model.Paises;

public class PaisService {



		PaisesDAO dao = new PaisesDAO();
		
		public int criar (Paises pais) {
			return dao.criar(pais);
		}
		
		public void atualizar (Paises pais) {
		    dao.atualizar(pais);
		}
		
		public void excluir (int id) {
			dao.excluir(id);
		}
		
		public Paises carregar (int id) {
			return dao.carregar(id);
		}
		public Paises menorArea() {
			return dao.menorArea();
	}
		public Paises maiorPopulacao() {
			return dao.maiorPopulacao();
		}
		public Paises[] vetorPaises() {
			return dao.vetorPaises();
		}
		public List <Paises> listar(){
			return dao.listar();		
		}
}
