/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classe_du_jeux;

import DAO.Jeu_Dao;
import DAO.jeu_login;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewMain_MOT {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
        jeu_login mot = new jeu_login();
            
            mot.setId_mot(5);
            mot.setMot("equipe");
            
            
            
            Jeu_Dao jeulogin = new Jeu_Dao();
            int result = jeulogin.insertMot(mot);
                    
                    if (result > 0) {
                        System.out.println("Insertion réussie ! ");
                    }else {
                        System.out.println("Insertion échouée !");
                    }
                    
                       // List<jeu_login> res = jeu_login.findall();
                       List<jeu_login> res = Jeu_Dao.findAll();
                        
                            for (int i = 0; i < res.size(); i++){
                                System.out.println("Contenu de la table 'mot' :");
                                System.out.println("------------------------------------------------------------------");
                                 System.out.println("Id_mot = " + res.get(i).getId_mot());
                                System.out.println("Id_images = " + res.get(i).getMot());
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Total de insertion : " + res.size() + " enregistrement(s)");
                                System.out.println("fin  \n");
                    }
        
        
    }
    }
    