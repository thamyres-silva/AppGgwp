package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EquipeDao;
import negocio.Equipe;


public class EquipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	private int id;
	private String operacao;
	
	
    public EquipeController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		operacao = request.getParameter("operacao");
		
		id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("equipe", EquipeDao.obterPorId(id));
		
		request.getRequestDispatcher("equipeDetalhe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Equipe equipe = null;
		
		switch (operacao) {
		case "Incluir":			
			equipe = obterEquipe(request, response);
			EquipeDao.incluir(equipe);
			break;

		case "Alterar":
			equipe = obterEquipe(request, response);
			equipe.setId(id);
			EquipeDao.alterar(equipe);
			break;

		case "Excluir":		
			EquipeDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", EquipeDao.obterLista());
		
		request.getRequestDispatcher("equipeLista.jsp").forward(request, response);
		
		
	}
	
	private Equipe obterEquipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Equipe e = new Equipe();
		e.setCriarEquipe("s".equals(request.getParameter("criarEquipe")));
		e.setNomeEquipe(request.getParameter("nomeEquipe"));
		
		return e;	
	}
}
