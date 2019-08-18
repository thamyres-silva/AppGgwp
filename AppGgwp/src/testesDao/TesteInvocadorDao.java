package testesDao;

import java.util.List;

import dao.InvocadorDao;
import negocio.Invocador;

public class TesteInvocadorDao {
	public static void main(String[] args) {
		
		Invocador invocador = new Invocador();
		invocador.setNick("Teacher");
		invocador.setServidor("CANADA");
		invocador.setPosicaoPrimaria("Suporte");
		invocador.setPosicaoSecundaria("Atirador");
		invocador.setElo("Ouro");
		invocador.setDiasSemana("Sábado");
		invocador.setBusca(null);		
		
		InvocadorDao.incluir(invocador);	
		
		List<Invocador> lista = InvocadorDao.obterLista();
		
		for (Invocador invocador2 : lista) {
			invocador2.exibir();

		}	
	}
}
