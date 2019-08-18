package testes;

import negocio.Busca;
import negocio.Invocador;

public class TesteInvocador {
	public static void main(String[] args) {
				
		Busca busca = new Busca ();
		busca.setNome("thamyres");
		busca.setElo("Ouro");
		busca.setCidade("RJ");
		busca.setEquipe("150BPM");
		
		Invocador invocador = new Invocador();
		invocador.setNick("Teacher Amy");
		invocador.setServidor("Brasil");
		invocador.setPosicaoPrimaria("Suporte");
		invocador.setPosicaoSecundaria("Atirador");
		invocador.setElo("Ouro");
		invocador.setDiasSemana("Sábado");
		invocador.setBusca(busca);
		invocador.exibir();		
	}
}
