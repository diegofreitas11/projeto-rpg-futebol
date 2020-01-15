/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistência;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diegofreitas
 */
public class Banco {
    
    public static String nomeBanco, usuario, 
                         senha, servidor;
    public static int porta;
    
    //valores padrões, podem ser modificados por fora
    static {
        nomeBanco = "futrpg";
        usuario = "diego";
        senha = "23ty12";
        servidor = "localhost";
        porta = 3306;
    }
    
    public static java.sql.Connection conexao = null;
    
    
    
    public static void abrir() throws SQLException {
        
        String url = "jdbc:mysql://" + servidor +
                     ":" + porta + "/" + nomeBanco;
        conexao = DriverManager.getConnection(url, 
                                usuario, senha);
        
    }
    
    public static void fechar() throws SQLException {
        conexao.close();
    }
    
    public static java.sql.Connection getConexao() {
        return conexao;
    }
}
