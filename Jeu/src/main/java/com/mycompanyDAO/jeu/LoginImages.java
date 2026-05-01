/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanyDAO.jeu;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class LoginImages {
    
    private int id;
    private String chamin;
    private String mot;
    private String descrition;
    private LocalDate created_at;

    public LoginImages(int id, String chamin, String mot, String descrition, LocalDate created_at) {
        this.id = id;
        this.chamin = chamin;
        this.mot = mot;
        this.descrition = descrition;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChamin() {
        return chamin;
    }

    public void setChamin(String chamin) {
        this.chamin = chamin;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
    
            
    
}
