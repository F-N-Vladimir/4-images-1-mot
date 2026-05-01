/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.vladimir.jeu.jeu;

import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class Mainconnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Connectivity connection = new Connectivity().getConnection();
        Connection connection = Connectivity.getConnection();
        System.out.println("connection = " + connection);
        System.out.println("la connection a ete etablir = " + connection);

    }

}
