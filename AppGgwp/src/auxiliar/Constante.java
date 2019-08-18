package auxiliar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constante {
	public static final String VERSAO = "1.0.0";
	public static final String[] ELO = {"Bronze", "Prata", "Ouro", "Platina", "Diamante", "Mestre", "Desafiante"};
	
	public static String obterAnoNascimento(Date data){
		DateFormat anoNascimento = new SimpleDateFormat("yyyy");
		
		return anoNascimento.format(data);
		
	}
	
	public static String obterHoraFormatada(Date hora){
		DateFormat horaAtual = new SimpleDateFormat("HH:mm");
		
		return horaAtual.format(hora);
		
	}
	
	public static String obterDataHoraFormatada(Date data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
        return df.format(data);
	}	
}