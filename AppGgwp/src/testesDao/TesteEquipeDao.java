package testesDao;

import java.util.List;

import dao.EquipeDao;
import negocio.Equipe;

public class TesteEquipeDao {
	public static void main(String[] args) {
		
		Equipe equipe = new Equipe();
		equipe.setNomeEquipe("TAMAGOD");
		equipe.setCriarEquipe(true);
		equipe.setUsuarios(null);
		
		EquipeDao.incluir(equipe);	
		
		List<Equipe> lista = EquipeDao.obterLista();
		
		for (Equipe equipe2 : lista) {
			equipe2.exibir();
		}
		
	}
}
