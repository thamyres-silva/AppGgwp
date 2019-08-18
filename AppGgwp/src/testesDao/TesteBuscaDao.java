package testesDao;

import java.util.List;

import dao.BuscaDao;
import negocio.Busca;

public class TesteBuscaDao {
	public static void main(String[] args) {		
		
		Busca busca = new Busca ();
		busca.setNome("Erik");
		busca.setElo("Diamante");
		busca.setCidade("RJ");
		busca.setEquipe("150BPM");
		
		BuscaDao.incluir(busca);	
		
		List<Busca> lista = BuscaDao.obterLista();
		
		for (Busca busca2 : lista) {
			busca2.exibir();
		}		
	}
}
