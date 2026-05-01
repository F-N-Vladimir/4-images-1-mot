/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vladimir.jeu.jeu;

/**
 *
 * @author Admin
 */
public class Database {

    private String userName = "postgres";
    private String password = "fnv2004";
    private String connectionUrl = "jdbc:postgresql://localhost:5432/jeu_images_mots";

    public Database() {
    }

    public Database(String userName, String password, String connectionUrl) {

        this.userName = userName;
        this.password = password;
        this.connectionUrl = connectionUrl;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

}
