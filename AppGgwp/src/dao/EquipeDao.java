package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Equipe;

public class EquipeDao {

	public static List<Equipe> obterLista(){
		String sql = "SELECT * FROM TEquipe ORDER BY id";
		
		List<Equipe> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Equipe>();			
			ps = Conexao.obterConexao().prepareStatement(sql);			
			ResultSet rs = null;			
			rs = ps.executeQuery();			
			
			while(rs.next()){
				lista.add(
					new Equipe(
							rs.getInt("id"),
							rs.getBoolean("criarEquipe"),
							rs.getString("nomeEquipe"),
							null));
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}	
	
	public static boolean incluir(Equipe equipe){
		
		String sql = "INSERT INTO TEquipe(criarEquipe, nomeEquipe) VALUES (?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setBoolean(1, equipe.isCriarEquipe());
			ps.setString(2, equipe.getNomeEquipe());			
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean excluir(int id){

		String sql = "DELETE FROM TEquipe WHERE id = ?";
		
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
	
	public static boolean alterar(Equipe equipe){
        String sql = "UPDATE TEquipe SET criarEquipe = ?, nomeEquipe = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setBoolean(1, equipe.isCriarEquipe());
            ps.setString(2, equipe.getNomeEquipe());         
            ps.setInt(3, equipe.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public static Equipe obterPorId(int id) {
		String sql = "SELECT * FROM TEquipe WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Equipe u = new Equipe();
				
				u.setId(rs.getInt("id"));
				u.setCriarEquipe(rs.getBoolean("criarEquipe"));
				u.setNomeEquipe(rs.getString("nomeEquipe"));			
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
