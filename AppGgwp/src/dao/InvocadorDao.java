package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Invocador;

public class InvocadorDao {
	
	public static List<Invocador> obterLista(){
		String sql = "SELECT * FROM TInvocador ORDER BY id";
		
		List<Invocador> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Invocador>();			
			ps = Conexao.obterConexao().prepareStatement(sql);			
			ResultSet rs = null;			
			rs = ps.executeQuery();			
			
			while(rs.next()){
				lista.add(
					new Invocador(
							rs.getInt("id"),
							rs.getString("nick"),
							rs.getString("servidor"),
							rs.getString("posicaoPrimaria"), 
							rs.getString("posicaoSecundaria"), 
							rs.getString("elo"),
							rs.getString("diasSemana"),
							null));
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}	
	
	public static boolean incluir(Invocador invocador){
		
		String sql = "INSERT INTO TInvocador(nick, servidor, posicaoPrimaria, posicaoSecundaria, elo, diasSemana) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, invocador.getNick());
			ps.setString(2, invocador.getServidor());
			ps.setString(3, invocador.getPosicaoPrimaria());
			ps.setString(4, invocador.getPosicaoSecundaria());
			ps.setString(5, invocador.getElo());
			ps.setString(6, invocador.getDiasSemana());		
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean excluir(int id){
		String sql = "DELETE FROM TInvocador WHERE id = ?";
		
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
	
	public static boolean alterar(Invocador invocador){
        String sql = "UPDATE TInvocador SET nick = ?, servidor = ?, posicaoPrimaria = ?, posicaoSecundaria = ?, elo = ?, diasSemana = ? WHERE id = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, invocador.getNick());
			ps.setString(2, invocador.getServidor());
			ps.setString(3, invocador.getPosicaoPrimaria());
			ps.setString(4, invocador.getPosicaoSecundaria());
			ps.setString(5, invocador.getElo());
			ps.setString(6, invocador.getDiasSemana());	
            ps.setInt(7, invocador.getId());


            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public static Invocador obterPorId(int id) {
		String sql = "SELECT * FROM TInvocador WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Invocador u = new Invocador();
				
				u.setId(rs.getInt("id"));
				u.setNick(rs.getString("nick"));
				u.setServidor(rs.getString("servidor"));
				u.setPosicaoPrimaria(rs.getString("posicaoPrimaria"));
				u.setPosicaoSecundaria(rs.getString("posicaoPrimaria"));
				u.setElo(rs.getString("elo"));
				u.setDiasSemana(rs.getString("diasSemana"));				
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
}


