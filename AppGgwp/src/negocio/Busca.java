package negocio;

import interfaces.IExibido;

public class Busca implements IExibido {
	private int id;
	private String nome;
	private String elo;
	private String cidade;
	private String equipe;
	
	public Busca() {
	}
			
	public Busca(int id, String nome, String elo, String cidade, String equipe) {
		this.id = id;
		this.nome = nome;
		this.elo = elo;
		this.cidade = cidade;
		this.equipe = equipe;
	}	

	public void exibir() {
		System.out.println("~ BUSCA ~");
		System.out.printf("Nome: %s\n"
				+ "Elo: %s\n"
				+ "Cidade: %s\n"
				+ "Equipe: %s\n\n"
				+ "_________________________________________\n",
				nome,
				elo,
				cidade,
				equipe);	
	}		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getElo() {
		return elo;
	}

	public void setElo(String elo) {
		this.elo = elo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}		
}
