/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author FibbS
 */
public class Matricula {
    private int id;
    private Date data;

    public Matricula(int id, Date data) {
        this.id = id;
        this.data = data;
    }
    
    public Matricula(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", data=" + data + '}';
    }
}
