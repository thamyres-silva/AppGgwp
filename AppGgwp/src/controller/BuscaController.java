package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuscaDao;
import negocio.Busca;



public class BuscaController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
		
	private int id;
	private String operacao;

    public BuscaController() {    	
    
    }     
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		operacao = request.getParameter("operacao");
		
		id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("busca", BuscaDao.obterPorId(id));
		
		request.getRequestDispatcher("buscaDetalhe.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Busca busca = null;
		
		switch (operacao) {
		case "Incluir":			
			busca = obterBusca(request, response);
			BuscaDao.incluir(busca);
			break;

		case "Alterar":
			busca = obterBusca(request, response);
			busca.setId(id);
			BuscaDao.alterar(busca);
			break;

		case "Excluir":		
			BuscaDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", BuscaDao.obterLista());
		
		request.getRequestDispatcher("buscaLista.jsp").forward(request, response);

	}
	
	private Busca obterBusca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Busca busca = new Busca ();
		busca.setNome(request.getParameter("nome"));
		busca.setElo(request.getParameter("elo"));
		busca.setCidade(request.getParameter("cidade"));
		busca.setEquipe(request.getParameter("equipe"));
				
		return busca;	
	}		
}
