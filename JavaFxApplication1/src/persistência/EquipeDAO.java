/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistência;

import entidades.Equipe;
import entidades.Jogador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegofreitas
 */
public class EquipeDAO implements DAO<Equipe>{
    private java.sql.PreparedStatement pst,pst2;
    private java.sql.ResultSet rs, rs2;
    

    @Override
    public List<Equipe> listarTodos() {
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        
        
        
        String sql = "select * from equipes";
        String sql2;
        try {
            Banco.abrir();
            pst = Banco.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                sql2 = "select * from jogadores where equipe_id="+rs.getInt("id");
                pst2 = Banco.getConexao().prepareStatement(sql2);
                rs2 = pst2.executeQuery();
                ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
                Jogador armador = new Jogador(null, 0, 0, 0);
                
                while(rs2.next()){
                    Jogador jogador = new Jogador(rs2.getString("nome"),
                    rs2.getInt("ataque"), rs2.getInt("defesa"), rs2.getInt("passe"));
                    
                    jogadores.add(jogador);
                }
               
                for(Jogador jogador : jogadores){
                    if(jogador.getPasse() > armador.getPasse()){
                        armador = jogador;
                    }
                }
                
                Equipe equipe = new Equipe(rs.getString("nome"), jogadores,
                        rs.getFloat("entrosamento"), armador);
        
                equipes.add(equipe);
                                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return equipes;
    }
    
}
