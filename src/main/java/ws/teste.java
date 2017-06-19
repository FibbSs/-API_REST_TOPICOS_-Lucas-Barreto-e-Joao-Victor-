/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.AlunoDAO;
import dao.MatriculaDAO;
import dao.TurmaDAO;
import java.sql.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Aluno;
import model.Matricula;
import model.Turma;

/**
 * REST Web Service
 *
 * @author FibbS
 */
@Path("teste")
public class teste {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of teste
     */
    public teste() {
    }

    /**
     * Retrieves representation of an instance of ws.teste
     * @return an instance of java.lang.String
     */
    @Path("buscar/matricula/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMatricula(@PathParam("id") int id) throws ClassNotFoundException {
        Matricula matricula;
        matricula = MatriculaDAO.buscaMatricula(id);
        return matricula.toString();
    }
    
    @Path("buscar/turma/{versao}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTurma(@PathParam("versao") byte versao) throws ClassNotFoundException {
        Turma turma;
        turma = TurmaDAO.buscaTurma(versao);
        return turma.toString();
    }
    
    @Path("buscar/aluno/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAluno(@PathParam("id") int id) throws ClassNotFoundException {
        Aluno aluno;
        aluno = AlunoDAO.buscaAluno(id);
        return aluno.toString();
    }
    
    
    
    @Path("cadastrar/matricula/{data}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setMatricula(@PathParam("data") Date data) throws ClassNotFoundException {
        Matricula matricula = new Matricula();
        matricula.setData(data);
        MatriculaDAO.cadastrarMatricula(matricula);
        return null;
    }
    
    @Path("cadastrar/turma/{inicio},{termino},{totalVagas},{versao},{matriculas},{aberta}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setTurma(@PathParam("inicio") Date inicio, @PathParam("termino") Date termino, @PathParam("totalVagas") byte totalVagas, @PathParam("versao") byte versao, @PathParam("matriculas") String matriculas, @PathParam("aberta") boolean aberta ) 
            throws ClassNotFoundException {
        Turma turma = new Turma();
        
        turma.setInicio(inicio);
        turma.setTermino(termino);
        turma.setTotalVagas(totalVagas);
        turma.setVersao(versao);
        turma.setAberta(aberta);
        
        TurmaDAO.cadastrarTurma(turma, matriculas);
        return null;
    }
    
    @Path("cadastrar/aluno/{nome},{cpf},{email},{telefone}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setAluno(@PathParam("nome") String nome, @PathParam("cpf") String cpf, @PathParam("email") String email, @PathParam("telefone") String telefone ) 
            throws ClassNotFoundException {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
        
        AlunoDAO.cadastraAluno(aluno);
        return null;
    }
    
    
    
    @Path("alterar/aluno/{id},{nome},{cpf},{email},{telefone}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String alterarAluno(@PathParam("id") int id, @PathParam("nome") String nome, @PathParam("cpf") String cpf, @PathParam("email") String email, @PathParam("telefone") String telefone ) 
            throws ClassNotFoundException {
        Aluno aluno;
        aluno = AlunoDAO.buscaAluno(id);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
        
        AlunoDAO.alterarAluno(aluno);
        return null;
    }
    
    @Path("alterar/turma/{versao},{inicio},{termino},{totalVagas},{aberta}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String alterarTurma(@PathParam("inicio") Date inicio, @PathParam("termino") Date termino, @PathParam("totalVagas") byte totalVagas, @PathParam("versao") byte versao, @PathParam("aberta") boolean aberta ) 
            throws ClassNotFoundException {
        Turma turma;
        turma = TurmaDAO.buscaTurma(versao);
        turma.setInicio(inicio);
        turma.setTermino(termino);
        turma.setTotalVagas(totalVagas);
        turma.setAberta(aberta);
        
        TurmaDAO.alterarTurma(turma);
        return null;
    }
    
    
    
    @Path("remover/matricula/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String removerMatricula(@PathParam("id") int id) throws ClassNotFoundException {
        MatriculaDAO.removerMatricula(id);
        return null;
    }
    
    @Path("remover/aluno/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String removerAluno(@PathParam("id") int id) throws ClassNotFoundException {
        AlunoDAO.removerAluno(id);
        return null;
    }
    
    @Path("remover/turma/{versao}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String removerTurma(@PathParam("versao") int versao) throws ClassNotFoundException {
        TurmaDAO.removerTurma(versao);
        return null;
    }

    /**
     * PUT method for updating or creating an instance of teste
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
