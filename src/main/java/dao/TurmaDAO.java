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
import java.util.ArrayList;
import java.util.Collection;
import model.Matricula;
import model.Turma;

/**
 *
 * @author FibbS
 */
public class TurmaDAO {
    public static Turma buscaTurma(byte versao) throws ClassNotFoundException {
        Connection connection = getConnection();

        String query = "SELECT * FROM `turma` WHERE `versao`=\""+versao+"\"";
        Statement st;
        ResultSet rs;
        Turma turma = null;
        String matriculasDB;
        
    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
            matriculasDB = rs.getString("matriculas");
            turma = new Turma(rs.getDate("inicio"), rs.getDate("termino"), rs.getByte("totalVagas"), rs.getByte("versao"), splitString(matriculasDB), rs.getBoolean("aberta"));	
        }
    }catch (Exception e){
	e.printStackTrace();
        }
        return turma;
    }
    
    public static void cadastrarTurma(Turma turma, String matriculas) throws ClassNotFoundException{
            String query = "INSERT INTO `turma`(`inicio`, `termino`, `totalVagas`, `versao`, `matriculas`, `aberta`) VALUES" + 
                "(\""+turma.getInicio()+"\",\""+turma.getTermino()+"\",\""+turma.getTotalVagas()+"\",\""+turma.getVersao()+"\",\""+matriculas+"\",\""+booleanToInt(turma.isAberta())+"\")";
            executaSQlQuery(query);
    }
    
    public static void alterarTurma(Turma turma) throws ClassNotFoundException{
        String query = "UPDATE `turma` SET `inicio`=\""+turma.getInicio()+"\",`termino`=\""+turma.getTermino()+"\",`totalVagas`=\""+turma.getTotalVagas()+"\",`matriculas`=\""+turma.getMatriculas()+"\",`aberta`=\""+booleanToInt(turma.isAberta())+"\" WHERE `versao`=";
        executaSQlQuery(query);
    }
    
    public static void removerTurma(int versao) throws ClassNotFoundException{
        String query = "DELETE FROM `turma` WHERE `versao`=\""+versao+"\" ";
        executaSQlQuery(query);
    }
    
    public static Collection<String> splitString(String matriculasDB){
        String[] matriculasSplit;
        Collection<String> matriculas = new ArrayList();
            matriculasSplit = matriculasDB.split("'");
            for(int i = matriculasSplit.length-1; i >= 0; i--){
                if(!matriculasSplit[i].equals("")){
                matriculas.add(matriculasSplit[i]);
                }
            }
        return matriculas;
    }
    
    public static int booleanToInt(boolean bool){
        int i;
        i = bool ? 1 : 0;
        return i;
    }
}
