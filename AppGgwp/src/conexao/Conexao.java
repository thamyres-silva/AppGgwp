package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conn = null;
	
	public static Connection obterConexao(){

		if (conn == null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String serverName = "localhost";
				
			String bandoDados = "appggwp";      
			
			//String url = "jdbc:mysql://" + serverName + "/" + bandoDados;
			
			String u = "jdbc:mysql://" + serverName + "/" + bandoDados + "?useTimezone=true&serverTimezone=UTC";
				
			String usuario = "root";              
				
			String senha = "root";

			try {
				conn = DriverManager.getConnection(u,usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return conn;
	}
}