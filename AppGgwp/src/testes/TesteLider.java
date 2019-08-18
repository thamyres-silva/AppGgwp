package testes;

import negocio.Busca;
import negocio.Invocador;
import negocio.Lider;

public class TesteLider {
	
	public static void main(String[] args) {					
		
		Busca busca = new Busca ();
		busca.setNome("thamyres");
		busca.setElo("Ouro");
		busca.setCidade("RJ");
		busca.setEquipe("150BPM");
		
		Invocador invocadorLider = new Invocador();
		invocadorLider.setNick("Teacher Amy");
		invocadorLider.setServidor("Brasil");
		invocadorLider.setPosicaoPrimaria("SUPP");
		invocadorLider.setPosicaoSecundaria("ADC");
		invocadorLider.setElo("Ouro");
		invocadorLider.setDiasSemana("Sabado");
		invocadorLider.setBusca(busca);		
		
		Lider lider = new Lider();			
		lider.setNome("Thamyres");
		lider.setSobrenome("Rodrigues");
		lider.setAnoNascimento(1993);
		lider.setEstado("RJ");
		lider.setCidade("Rio de Janeiro");
		lider.setGenero(true);
		lider.setEmail("thamyres.silva@live.com");
		lider.setSenha(12345);	
		lider.setInvocador(invocadorLider);
		lider.imprimirTipo();			
	}
}
