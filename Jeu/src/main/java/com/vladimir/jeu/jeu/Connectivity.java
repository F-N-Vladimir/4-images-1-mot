/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vladimir.jeu.jeu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Connectivity {
    
    public static Connection getConnection(){
        
        Connection connection = null;
        Database db = new Database();
        
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(db.getConnectionUrl(), db.getUserName(), db.getPassword());
//            connection = (Connectivity) DriverManager.getConnection(db.getConnectionUrl(),db.getUserName(),db.getPassword());
            System.out.println("Database connected = "+connection);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erreur connexion DB = "+e.getMessage());
        }
       return connection;
    }
    
     
}
