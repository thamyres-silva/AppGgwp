package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.Conexao;
import negocio.Integrante;

public class IntegranteDao {
	
	public static List<Integrante> obterLista(){
		String sql = "SELECT * FROM TIntegrante ORDER BY id";
		
		List<Integrante> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Integrante>();			
			ps = Conexao.obterConexao().prepareStatement(sql);			
			ResultSet rs = null;			
			rs = ps.executeQuery();			
			
			while(rs.next()){
				Calendar dtInscricao = Calendar.getInstance();
				dtInscricao.setTime(rs.getDate("DataCadastro"));
				lista.add(
					new Integrante(							
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
		
	
	public static boolean incluir(Integrante integrante){
		
		String sql = "INSERT INTO TIntegrante(nome, sobrenome, anoNascimento, estado, cidade, genero, email, senha, DataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
						
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, integrante.getNome());
			ps.setString(2, integrante.getSobrenome());
			ps.setInt(3, integrante.getAnoNascimento());
			ps.setString(4, integrante.getEstado());
			ps.setString(5, integrante.getCidade());
			ps.setBoolean(6, integrante.isGenero());
			ps.setString(7, integrante.getEmail());
			ps.setFloat(8, integrante.getSenha());
			ps.setDate(9, new java.sql.Date(integrante.getDataCadastro().getTimeInMillis()));			
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
	
	public static boolean excluir(int id){
		String sql = "DELETE FROM TIntegrante WHERE id = ?";
		
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
	
	public static boolean alterar(Integrante integrante){
        String sql = "UPDATE TIntegrante SET nome = ?, sobrenome = ?, anoNascimento = ?, estado = ?, cidade = ?, genero = ?, email = ?, senha = ?, DataCadastro = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {
        	
            ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, integrante.getNome());
			ps.setString(2, integrante.getSobrenome());
			ps.setInt(3, integrante.getAnoNascimento());
			ps.setString(4, integrante.getEstado());
			ps.setString(5, integrante.getCidade());
			ps.setBoolean(6, integrante.isGenero());
			ps.setString(7, integrante.getEmail());
			ps.setFloat(8, integrante.getSenha());
			ps.setDate(9, new java.sql.Date(integrante.getDataCadastro().getTimeInMillis()));			
            ps.setInt(10, integrante.getId());


            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public static Integrante obterPorId(int id) {
		String sql = "SELECT * FROM TIntegrante WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				Calendar dtInscricao = Calendar.getInstance();
				dtInscricao.setTime(rs.getDate("DataCadastro"));
				Integrante u = new Integrante(							
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
