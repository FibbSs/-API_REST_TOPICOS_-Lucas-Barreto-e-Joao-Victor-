/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static dao.Conexao.executaSQlQuery;
import static dao.Conexao.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Matricula;
/**
 *
 * @author FibbS
 */
public class MatriculaDAO {
    public static Matricula buscaMatricula(int id) throws ClassNotFoundException {
        Connection connection = getConnection();

        String query = "SELECT `id`, `data` FROM `matricula` WHERE `id`=\""+id+"\"";
        Statement st;
        ResultSet rs;
        Matricula matricula = null;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    matricula = new Matricula(rs.getInt("id"),rs.getDate("data"));	
        }
    }catch (Exception e){
	e.printStackTrace();
        }
        return matricula;
    }
    
    public static void cadastrarMatricula(Matricula matricula) throws ClassNotFoundException{
            String query = "INSERT INTO `matricula`(`data`) VALUES (\""+matricula.getData()+"\")";
            executaSQlQuery(query);
    }
    
    public static void removerMatricula(int id) throws ClassNotFoundException{
        String query = "DELETE FROM `matricula` WHERE `id`=\""+id+"\" ";
        executaSQlQuery(query);
    }
}
    

