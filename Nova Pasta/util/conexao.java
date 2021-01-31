/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DRang
 */
public class conexao {
    
   private static Connection Conexao;

    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   private conexao(){}
   
   public static Connection getconexao(){
       if(Conexao == null){
           try {
               Class.forName("com.mysql.jdbc.Driver");
               Conexao = DriverManager.getConnection("jdbc:mysql://localhost/personagemrpg", "root", "");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return Conexao;
   }  
}
