package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IntegranteDao;
import negocio.Integrante;


public class IntegranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String operacao;

    public IntegranteController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		
		id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("integrante", IntegranteDao.obterPorId(id));
		
		request.getRequestDispatcher("integranteDetalhe.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integrante integrante = null;
		
		switch (operacao) {
		case "Incluir":			
			integrante = obterIntegrante(request, response);
			IntegranteDao.incluir(integrante);
			break;

		case "Alterar":
			integrante = obterIntegrante(request, response);
			integrante.setId(id);
			IntegranteDao.alterar(integrante);
			break;

		case "Excluir":		
			IntegranteDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", IntegranteDao.obterLista());
		
		request.getRequestDispatcher("integranteLista.jsp").forward(request, response);	
		
	}
	
	
	
	private Integrante obterIntegrante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integrante integrante = new Integrante();
		integrante.setNome(request.getParameter("nome"));
		integrante.setSobrenome(request.getParameter("sobrenome"));
		integrante.setAnoNascimento(Integer.valueOf(request.getParameter("anoNascimento")));
		integrante.setEstado(request.getParameter("estado"));
		integrante.setCidade(request.getParameter("cidade"));
		integrante.setGenero("F".equals(request.getParameter("genero")));		
		integrante.setEmail(request.getParameter("email"));
		integrante.setSenha(Float.valueOf(request.getParameter("senha")));
		
		Calendar dtData = Calendar.getInstance();    		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        try {
        	Date data = (Date)df.parse(request.getParameter("DataCadastro"));            
            dtData.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}         		
        integrante.setDataCadastro(dtData);
	
		return integrante;
	}
}
