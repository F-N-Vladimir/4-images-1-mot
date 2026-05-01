/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.images_et_mots;  // ← adapte si ton package est différent

import com.mycompany.images_et_1mot.Database;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Connection {  

    private static Connection connection;  

    public static Connection getConnection() throws SQLException {
        
        if (connection == null || connection.isClosed()) {
            
            
            Database db = new Database();  
            String url      = db.getConnectionUrl();   
            String username = db.getUserName();      
            String password = db.getPassword();        
            
            try {
               
                Class.forName("org.postgresql.Driver");
                
              
                connection = (Connection) DriverManager.getConnection(url, username, password);
                
                System.out.println("Connexion PostgreSQL réussie !");
                
            } catch (ClassNotFoundException e) {
                System.err.println("Driver PostgreSQL introuvable !");
                System.err.println(e.getMessage());
                throw new SQLException("Driver PostgreSQL manquant (vérifie le JAR dans Dependencies)", e);
                
            } catch (SQLException e) {
                System.err.println("Échec de la connexion à la base de données :");
                System.err.println("URL     : " + url);
                System.err.println("Message : " + e.getMessage());
                throw e; 
            }
        }
        
        return connection;
    }

    private boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
