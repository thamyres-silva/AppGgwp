package testes;

import java.util.ArrayList;
import java.util.List;

import negocio.Busca;
import negocio.Equipe;
import negocio.Integrante;
import negocio.Invocador;
import negocio.Lider;
import negocio.Usuario;

public class TesteEquipe {
	public static void main(String[] args) {
		
		Busca buscaInvocadorLider = new Busca ();
		buscaInvocadorLider.setNome("thamyres");
		buscaInvocadorLider.setElo("Ouro");
		buscaInvocadorLider.setCidade("RJ");
		buscaInvocadorLider.setEquipe("150BPM");
		
		Invocador invocadorLider = new Invocador();
		invocadorLider.setNick("Teacher Amy");
		invocadorLider.setServidor("Brasil");
		invocadorLider.setPosicaoPrimaria("SUPP");
		invocadorLider.setPosicaoSecundaria("ADC");
		invocadorLider.setElo("Ouro");
		invocadorLider.setDiasSemana("Sabado");
		invocadorLider.setBusca(buscaInvocadorLider);		
		
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

		
		//
		
		Busca buscaInvocadorIntegrante = new Busca ();
		buscaInvocadorIntegrante.setNome("TAMAGOD");
		buscaInvocadorIntegrante.setElo("Ouro");
		buscaInvocadorIntegrante.setCidade("rj");
		buscaInvocadorIntegrante.setEquipe("150BPM");
		
		Invocador invocadorIntegrante = new Invocador();
		invocadorIntegrante.setNick("TamaGOD");
		invocadorIntegrante.setServidor("Brasil");
		invocadorIntegrante.setPosicaoPrimaria("MID");
		invocadorIntegrante.setPosicaoSecundaria("ADC");
		invocadorIntegrante.setElo("Ouro");
		invocadorIntegrante.setDiasSemana("Segunda");
		invocadorIntegrante.setBusca(buscaInvocadorIntegrante);	
		
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

		
		//

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(lider);
		usuarios.add(integrante);	
		
		Equipe equipe = new Equipe();
		equipe.setNomeEquipe("150BPM");
		equipe.setCriarEquipe(true);
		equipe.setUsuarios(usuarios);
		
		equipe.exibir();		
	}
}
