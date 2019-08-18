package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InvocadorDao;
import negocio.Invocador;



public class InvocadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	private int id;
	private String operacao;

    public InvocadorController() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		operacao = request.getParameter("operacao");
		
		id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("invocador", InvocadorDao.obterPorId(id));
		
		request.getRequestDispatcher("invocadorDetalhe.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Invocador invocador = null;
		
		switch (operacao) {
		case "Incluir":			
			invocador = obterInvocador(request, response);
			InvocadorDao.incluir(invocador);
			break;

		case "Alterar":
			invocador = obterInvocador(request, response);
			invocador.setId(id);
			InvocadorDao.alterar(invocador);
			break;

		case "Excluir":		
			InvocadorDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", InvocadorDao.obterLista());
		
		request.getRequestDispatcher("invocadorLista.jsp").forward(request, response);		
		
	}
	
	private Invocador obterInvocador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Invocador invocador = new Invocador();
		invocador.setNick(request.getParameter("nick"));
		invocador.setServidor(request.getParameter("servidor"));
		invocador.setPosicaoPrimaria(request.getParameter("posicaoPrimaria"));
		invocador.setPosicaoSecundaria(request.getParameter("posicaoSecundaria"));
		invocador.setElo(request.getParameter("elo"));
		invocador.setDiasSemana(request.getParameter("diasSemana"));		

		return invocador;
	}
}
