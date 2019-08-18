package dao;

import java.util.List;


public class AppDao {
	public static List<?> obterLista(String lista) {
			
			switch (lista) {
			case "buscaLista.jsp":
				return BuscaDao.obterLista();
			
			case "equipeLista.jsp":
				return EquipeDao.obterLista();
			
			case "integranteLista.jsp":
				return IntegranteDao.obterLista();
			
			case "invocadorLista.jsp":
				return InvocadorDao.obterLista();
			
			case "liderLista.jsp":
				return LiderDao.obterLista();
				
			default:
				break;
			}
			
			return null;
	}
}		
		

