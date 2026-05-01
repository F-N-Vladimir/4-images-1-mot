/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompanyDAO.jeu;


import java.util.List;

/**
 *
 * @author Admin
 */
public class MainLogin {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
 LoginModelle mot = new LoginModelle();    
            
             mot.setIdmot(1);
            mot.setMot("feu");
            mot.setImage_1("feu.img1");
            mot.setImage_2("feu.img2");
            mot.setImage_3("feu.img3");
            mot.setImage_4("feu.img4");
            
              int result = LoginDAO.insert(mot);
    if (result > 0) {
            System.out.println("Insertion réussie !");
        } else {
            System.out.println("Insertion échouée !");
    }
        // TODO code application logic here
        List<LoginModelle> res = LoginDAO.findall();
        for (int i = 0; i < res.size(); i++) {
            
            System.out.println("Contenu de la table 'jeu' :");
             System.out.println("------------------------------------------------------------------");
             System.out.println("idmot   mot          image1     image2     image3     image4");
             System.out.println("------------------------------------------------------------------");
            System.out.println("res = " + res.get(i).getIdmot());
            System.out.println("res = " + res.get(i).getMot());
            System.out.println("res = " + res.get(i).getImage_1());
            System.out.println("res = " + res.get(i).getImage_2());
            System.out.println("res = " + res.get(i).getImage_3());
            System.out.println("res = " + res.get(i).getImage_4());
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Total de MOt : " + res.size() + " enregistrement(s)");
            System.out.println("fin  \n");

            //LoginModel loueur= new LoginModel();
           
    }
            
            
            
               
      

           
        }
    }


