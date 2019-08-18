package negocio;

import auxiliar.Constante;
import interfaces.IExibido;

public class Invocador implements IExibido {
	private int id;
	private String nick;
	private String servidor;
	private String posicaoPrimaria;
	private String posicaoSecundaria;
	private String elo;
	private String diasSemana;
	private Busca busca;	
	
	public Invocador() {
		
	}		

	public Invocador(int id, String nick, String servidor, String posicaoPrimaria, String posicaoSecundaria, String elo,
			String diasSemana, Busca busca) {
		this.id = id;
		this.nick = nick;
		this.servidor = servidor;
		this.posicaoPrimaria = posicaoPrimaria;
		this.posicaoSecundaria = posicaoSecundaria;
		this.elo = elo;
		this.diasSemana = diasSemana;
		this.busca = busca;
	}

	public void exibir() {
		System.out.println("\n~ CONTA DO LEAGUE OF LEGENDS ~");
		System.out.printf("Nome de Invocador: %s\n"
					+ "Servidor: %s\n"
					+ "Possui elo: %s\n"
					+ "Elo: %s\n"
					+ "Posicao Primaria: %s\n"
					+ "Posicao Secundaria: %s\n"
					+ "Dias da Semana que costuma jogar: %s\n\n",
					nick,
					servidor,
					(definirElo() ? "Sim" : "Unranked"),
					elo,
					posicaoPrimaria,
					posicaoSecundaria,
					diasSemana);		
		if (busca != null) {			
			busca.exibir();
		}
	}	
	
	private boolean definirElo() {
		
		boolean existe = false;
		
		for (String e : Constante.ELO) {
			if(e.equals(elo)) {
				return true;
			}
		}
		
		return existe;		
	}	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getPosicaoPrimaria() {
		return posicaoPrimaria;
	}

	public void setPosicaoPrimaria(String posicaoPrimaria) {
		this.posicaoPrimaria = posicaoPrimaria;
	}

	public String getPosicaoSecundaria() {
		return posicaoSecundaria;
	}

	public void setPosicaoSecundaria(String posicaoSecundaria) {
		this.posicaoSecundaria = posicaoSecundaria;
	}

	public String getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}

	public Busca getBusca() {
		return busca;
	}

	public void setBusca(Busca busca) {
		this.busca = busca;
	}

	public String getElo() {
		return elo;
	}


	public void setElo(String elo) {
		this.elo = elo;
	}		
}
