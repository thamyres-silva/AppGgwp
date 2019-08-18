package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Busca;

public class BuscaDao {
	
	public static List<Busca> obterLista(){
		String sql = "SELECT * FROM TBusca ORDER BY id";
		
		List<Busca> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Busca>();			
			ps = Conexao.obterConexao().prepareStatement(sql);			
			ResultSet rs = null;			
			rs = ps.executeQuery();			
			
			while(rs.next()){
				lista.add(
					new Busca(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("elo"), 							
							rs.getString("cidade"),
							rs.getString("equipe"))	 
						);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}	
	
	public static boolean incluir(Busca busca){
		
		String sql = "INSERT INTO TBusca(nome, elo, cidade, equipe) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, busca.getNome());
			ps.setString(2, busca.getElo());
			ps.setString(3, busca.getCidade());
			ps.setString(4, busca.getEquipe());			
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}		
	
	public static boolean excluir(int id){

		String sql = "DELETE FROM TBusca WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
	
	public static boolean alterar(Busca busca){
        String sql = "UPDATE TBusca SET nome = ?, elo = ?, cidade = ?, equipe = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.obterConexao().prepareStatement(sql);            
            ps.setString(1, busca.getNome());
            ps.setString(2, busca.getElo());
            ps.setString(3, busca.getCidade());
            ps.setString(4, busca.getEquipe());
            ps.setInt(5, busca.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public static Busca obterPorId(int id) {
		String sql = "SELECT * FROM TBusca WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Busca u = new Busca();
				
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setElo(rs.getString("elo"));
				u.setCidade(rs.getString("cidade"));
				u.setEquipe(rs.getString("equipe"));				
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
