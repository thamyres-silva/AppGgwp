package testes;

import negocio.Busca;

public class TesteBusca {
	public static void main(String[] args) {
		
		Busca busca = new Busca ();
		busca.setNome("thamyres");
		busca.setElo("Ouro");
		busca.setCidade("RJ");
		busca.setEquipe("150BPM");
		busca.exibir();
		
	}
}
