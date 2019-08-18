package testesDao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.IntegranteDao;
import negocio.Integrante;

public class TesteIntegranteDao {
	public static void main(String[] args) {
		

		Calendar dataPublic = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
        try {
            Date data = (Date)df.parse("27/11/2018");            
            dataPublic.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		Integrante integrante = new Integrante();
		integrante.setNome("Pedro");
		integrante.setSobrenome("LOL");
		integrante.setAnoNascimento(2000);
		integrante.setEstado("RJ");
		integrante.setCidade("Rio de Janeiro");
		integrante.setGenero(false);
		integrante.setEmail("pedro.noob@live.com");
		integrante.setSenha(27612);
		integrante.setInvocador(null);
		integrante.setDataCadastro(dataPublic);
		
		IntegranteDao.incluir(integrante);
		
		List<Integrante> lista = IntegranteDao.obterLista();
		
		for (Integrante integrante2 : lista) {
			integrante2.exibir();
		}
	}
}
