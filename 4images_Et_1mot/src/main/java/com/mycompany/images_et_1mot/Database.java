/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.images_et_1mot;

/**
 *
 * @author Admin
 */
public class Database {
    
    private String userName = "postgres";
    private String password = "postgres";
    private String connectionUrl = "jdbc:postgresql://localhost:5432/jeu_images_mots";
    
    public Database() {
    }
    
    
             public Database(String url, String user, String password) {
   
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
