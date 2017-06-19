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
import model.Aluno;

/**
 *
 * @author FibbS
 */
public class AlunoDAO {
    
    public static Aluno buscaAluno(int id) throws ClassNotFoundException {
        Connection connection = getConnection();

        String query = "SELECT * FROM `aluno` WHERE `id`=\""+id+"\"";
        Statement st;
        ResultSet rs;
        Aluno aluno = null;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"));	
        }
    }catch (Exception e){
	e.printStackTrace();
        }
        return aluno;
    }
    
    public static void cadastraAluno(Aluno aluno) throws ClassNotFoundException{
        String query = "INSERT INTO `aluno`(`nome`, `cpf`, `email`, `telefone`) VALUES (\""+aluno.getNome()+"\",\""+aluno.getCpf()+"\",\""+aluno.getEmail()+"\",\""+aluno.getTelefone()+"\")";
        executaSQlQuery(query);
    }
    
    public static void alterarAluno(Aluno aluno) throws ClassNotFoundException{
        String query = "UPDATE `aluno` SET `nome`=\""+aluno.getNome()+"\",`cpf`=\""+aluno.getCpf()+"\",`email`=\""+aluno.getEmail()+"\",`telefone`=\""+aluno.getTelefone()+"\" WHERE `id`=";
        executaSQlQuery(query);
    }
    
    public static void removerAluno(int id) throws ClassNotFoundException{
        String query = "DELETE FROM `aluno` WHERE `id`=\""+id+"\" ";
        executaSQlQuery(query);
    }
}
