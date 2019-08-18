package testes;

import negocio.Busca;
import negocio.Integrante;
import negocio.Invocador;

public class TesteIntegrante {
	public static void main(String[] args) {	
		
		Busca busca = new Busca ();
		busca.setNome("thamyres");
		busca.setElo("Ouro");
		busca.setCidade("RJ");
		busca.setEquipe("150BPM");
		
		Invocador invocadorIntegrante = new Invocador();
		invocadorIntegrante.setNick("TamaGOD");
		invocadorIntegrante.setServidor("Brasil");
		invocadorIntegrante.setPosicaoPrimaria("MID");
		invocadorIntegrante.setPosicaoSecundaria("ADC");
		invocadorIntegrante.setElo("Ouro");
		invocadorIntegrante.setDiasSemana("Segunda");
		invocadorIntegrante.setBusca(busca);	
		
		Integrante integrante = new Integrante ();
		integrante.setNome("Leandro");
		integrante.setSobrenome("Pinto");
		integrante.setAnoNascimento(2000);
		integrante.setEstado("RJ");
		integrante.setCidade("Rio de Janeiro");
		integrante.setGenero(false);
		integrante.setEmail("lele.pinto@live.com");
		integrante.setSenha(27612);
		integrante.setInvocador(invocadorIntegrante);
		integrante.imprimirTipo();		
	}
}
