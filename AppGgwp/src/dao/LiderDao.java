package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.Conexao;
import negocio.Lider;

public class LiderDao {
	
	public static List<Lider> obterLista(){
		String sql = "SELECT * FROM TLider ORDER BY id";
		
		List<Lider> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Lider>();			
			ps = Conexao.obterConexao().prepareStatement(sql);			
			ResultSet rs = null;			
			rs = ps.executeQuery();			
			
			while(rs.next()){
				Calendar dtInscricao = Calendar.getInstance();
				dtInscricao.setTime(rs.getDate("DataCadastro"));	
				lista.add(
					new Lider(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("sobrenome"), 
							rs.getInt("anoNascimento"), 
							rs.getString("estado"),
							rs.getString("cidade"),
							rs.getBoolean("genero"),
							rs.getString("email"),
							rs.getFloat("senha"),
							null,
							dtInscricao
						));
			}			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}	
	
	public static boolean incluir(Lider lider){
		
		String sql = "INSERT INTO TLider(nome, sobrenome, anoNascimento, estado, cidade, genero, email, senha, DataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, lider.getNome());
			ps.setString(2, lider.getSobrenome());
			ps.setInt(3, lider.getAnoNascimento());
			ps.setString(4, lider.getEstado());
			ps.setString(5, lider.getCidade());
			ps.setBoolean(6, lider.isGenero());
			ps.setString(7, lider.getEmail());
			ps.setFloat(8, lider.getSenha());
			ps.setDate(9, new java.sql.Date(lider.getDataCadastro().getTimeInMillis()));			
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
	
	public static boolean excluir(int id){
		String sql = "DELETE FROM TLider WHERE id = ?";
		
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
	
	public static boolean alterar(Lider lider){
        String sql = "UPDATE TLider SET nome = ?, sobrenome = ?, anoNascimento = ?, estado = ?, cidade = ?, genero = ?, email = ?, senha = ?, DataCadastro = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {
        	
            ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, lider.getNome());
			ps.setString(2, lider.getSobrenome());
			ps.setInt(3, lider.getAnoNascimento());
			ps.setString(4, lider.getEstado());
			ps.setString(5, lider.getCidade());
			ps.setBoolean(6, lider.isGenero());
			ps.setString(7, lider.getEmail());
			ps.setFloat(8, lider.getSenha());
			ps.setDate(9, new java.sql.Date(lider.getDataCadastro().getTimeInMillis()));			
            ps.setInt(10, lider.getId());


            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public static Lider obterPorId(int id) {
		String sql = "SELECT * FROM TLider WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				Calendar dtInscricao = Calendar.getInstance();
				dtInscricao.setTime(rs.getDate("DataCadastro"));
				Lider u = new Lider(							
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("sobrenome"), 
							rs.getInt("anoNascimento"), 
							rs.getString("estado"),
							rs.getString("cidade"),
							rs.getBoolean("genero"),
							rs.getString("email"),
							rs.getFloat("senha"), 
							null,
							dtInscricao
						);				
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
}
