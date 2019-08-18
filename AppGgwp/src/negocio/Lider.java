package negocio;

import java.util.Calendar;

public class Lider extends Usuario {	
	
	public Lider() {
		
	}

	public Lider(int id, String nome, String sobrenome, int anoNascimento, String estado, String cidade, boolean genero,
			String email, float senha, Invocador invocador, Calendar dataCadastro) {
		super(id, nome, sobrenome, anoNascimento, estado, cidade, genero, email, senha, invocador, dataCadastro);
	}



	@Override
	public void imprimirTipo() {
		super.adicionarCabecalho();
		
		System.out.println(" - #Lider#");
		
		super.exibir();		
	}
}
