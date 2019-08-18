package negocio;

import java.util.Calendar;


public abstract class Usuario {		
	private int id;
	private String nome;
	private String sobrenome;
	private int anoNascimento;	     
	private String estado;
	private String cidade;
	private boolean genero;
	private String email;
	private float senha;
	private Invocador invocador;	
	private Calendar dataCadastro;	

	
	public Usuario() {
		
	}

	public Usuario(int id, String nome, String sobrenome, int anoNascimento, String estado, String cidade,
			boolean genero, String email, float senha, Invocador invocador, Calendar dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.anoNascimento = anoNascimento;
		this.estado = estado;
		this.cidade = cidade;
		this.genero = genero;
		this.email = email;
		this.senha = senha;
		this.invocador = invocador;
		this.dataCadastro = dataCadastro;
	}

	public abstract void imprimirTipo();

	public void exibir() {		
        int idade = calcularMaiorIdade();        
		
		if (idade < 18){
			System.err.printf("Você não possui a idade mínima para realizar o cadastro\n");
		}
		else{
			System.out.println("\n~ CADASTRO PESSOAL ~");
					System.out.println("Siga os passos abaixo para realizar o cadastro:\n");
					System.out.printf("Nome: %s\n"
							+ "Sobrenome: %s\n"
							+ "Data de nascimento: %d\n"
							+ "Estado: %s\n"
							+ "Cidade: %s\n"
							+ "Genero: %s\n"
							+ "E-mail: %s\n"
							+ "Senha: %.0f\n"
							+ "Idade: %d\n",
							nome,
							sobrenome,
							anoNascimento,
							estado,
							cidade,
							genero ? "Feminino" : "Masculino",
							email,
							senha,
							idade);		
					
					if (invocador != null) {
					invocador.exibir();
					}
		}		
	}	
	
	protected final void adicionarCabecalho() {
		System.out.printf("#Usuário#");
	}
	
	private int calcularMaiorIdade() {	
        Calendar calendario = Calendar.getInstance();

        int ano_atual = calendario.get(Calendar.YEAR);
		
		return ano_atual - anoNascimento;		
	}			
			
	

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSenha() {
		return senha;
	}

	public void setSenha(float senha) {
		this.senha = senha;
	}

	public Invocador getInvocador() {
		return invocador;
	}

	public void setInvocador(Invocador invocador) {
		this.invocador = invocador;
	}		
}