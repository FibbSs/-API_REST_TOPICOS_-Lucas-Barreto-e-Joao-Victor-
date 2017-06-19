/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Collection;

/**
 *
 * @author FibbS
 */
public class Turma {
    private Date inicio;
    private Date termino;
    private byte totalVagas;
    private byte versao;
    private Collection matriculas;
    private boolean aberta;

    public Turma(Date inicio, Date termino, byte totalVagas, byte versao, Collection matriculas, boolean aberta) {
        this.inicio = inicio;
        this.termino = termino;
        this.totalVagas = totalVagas;
        this.versao = versao;
        this.matriculas = matriculas;
        this.aberta = aberta;
    }
    
    public Turma(){
    
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public byte getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(byte totalVagas) {
        this.totalVagas = totalVagas;
    }

    public byte getVersao() {
        return versao;
    }

    public void setVersao(byte versao) {
        this.versao = versao;
    }

    public Collection getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Collection matriculas) {
        this.matriculas = matriculas;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    @Override
    public String toString() {
        return "Turma{" + "inicio=" + inicio + ", termino=" + termino + ", totalVagas=" + totalVagas + ", versao=" + versao + ", matriculas=" + matriculas + ", aberta=" + aberta + '}';
    }
}
