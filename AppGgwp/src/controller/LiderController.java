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

import dao.LiderDao;
import negocio.Lider;



public class LiderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String operacao;

    public LiderController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		
		id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("lider", LiderDao.obterPorId(id));
		
		request.getRequestDispatcher("liderDetalhe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lider lider = null;
		
		switch (operacao) {
		case "Incluir":			
			lider = obterIntegrante(request, response);
			LiderDao.incluir(lider);
			break;

		case "Alterar":
			lider = obterIntegrante(request, response);
			lider.setId(id);
			LiderDao.alterar(lider);
			break;

		case "Excluir":		
			LiderDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", LiderDao.obterLista());
		
		request.getRequestDispatcher("liderLista.jsp").forward(request, response);	

	}
	
	private Lider obterIntegrante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lider lider = new Lider();
		lider.setNome(request.getParameter("nome"));
		lider.setSobrenome(request.getParameter("sobrenome"));
		lider.setAnoNascimento(Integer.valueOf(request.getParameter("anoNascimento")));
		lider.setEstado(request.getParameter("estado"));
		lider.setCidade(request.getParameter("cidade"));
		lider.setGenero("F".equals(request.getParameter("genero")));		
		lider.setEmail(request.getParameter("email"));
		lider.setSenha(Float.valueOf(request.getParameter("senha")));
		
		Calendar dtData = Calendar.getInstance();    		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        try {
        	Date data = (Date)df.parse(request.getParameter("DataCadastro"));            
            dtData.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}         		
        lider.setDataCadastro(dtData);
	
		return lider;				

	}
}
