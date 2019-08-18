package testesDao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.LiderDao;
import negocio.Lider;

public class TesteLiderDao {
	public static void main(String[] args) {
		Calendar dataPublic = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
        try {
            Date data = (Date)df.parse("27/11/2018");            
            dataPublic.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
        Lider lider = new Lider();
		lider.setNome("hahahahahahahhaha");
		lider.setSobrenome("Lider_Teacher");
		lider.setAnoNascimento(2000);
		lider.setEstado("RJ");
		lider.setCidade("Rio de Janeiro");
		lider.setGenero(false);
		lider.setEmail("thamyres.silva@live.com");
		lider.setSenha(27612);
		lider.setInvocador(null);
		lider.setDataCadastro(dataPublic);
		
		LiderDao.incluir(lider);
		
		List<Lider> lista = LiderDao.obterLista();
		
		for (Lider lider2 : lista) {
			lider2.exibir();
		}
	}
}
