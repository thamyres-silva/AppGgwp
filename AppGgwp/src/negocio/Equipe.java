package negocio;

import java.util.List;

import interfaces.IExibido;

public class Equipe implements IExibido {
	private int id;
	private boolean criarEquipe;	
	private String nomeEquipe;
	private List<Usuario> usuarios;
		
	public Equipe() {
		
	}

	public Equipe(int id, boolean criarEquipe, String nomeEquipe, List<Usuario> usuarios) {
		this.id = id;
		this.criarEquipe = criarEquipe;
		this.nomeEquipe = nomeEquipe;
		this.usuarios = usuarios;
	}

	public void exibir() {
		System.out.printf("Deseja criar uma equipe? %s\n"
				+ "Nome da Equipe: %s\n",
				criarEquipe ? "sim" : "nao\n\n",
				nomeEquipe);				
		
		if (usuarios != null) {
			exibirUsuario();
		}
		//exibirUsuario();		
	}

	private void exibirUsuario() {
		System.out.println("\n   Membros da equipe: ");
		for (Usuario usuario : usuarios) {
			usuario.exibir();
		}
	}
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCriarEquipe() {
		return criarEquipe;
	}

	public void setCriarEquipe(boolean criarEquipe) {
		this.criarEquipe = criarEquipe;
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
