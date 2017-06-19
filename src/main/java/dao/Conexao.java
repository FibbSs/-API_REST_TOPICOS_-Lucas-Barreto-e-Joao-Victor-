/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FibbS
 */
public class Conexao {
    public static Connection getConnection() throws ClassNotFoundException {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                                                                //seuIp   nomeDaDb  login  senha
                return DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123");
            }         
	catch(SQLException excecao) {
		throw new RuntimeException(excecao);
	}
    }
    
    public static void executaSQlQuery(String query) throws ClassNotFoundException{
	Connection con = getConnection();
	Statement st;
	try{
		st = con.createStatement();
		st.executeUpdate(query);
 	}catch(Exception e){
		e.printStackTrace();	
	}
    }
}
