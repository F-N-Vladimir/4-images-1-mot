/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewMaindao {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
        jeu_login niveaux = new jeu_login();
        
            niveaux.setId_niveaux(4);
            niveaux.setId_mot(4);
            niveaux.setId_images(4);
            niveaux.setId_indice(4);
            niveaux.setNumero_niveaux("Niveau 4.");
            
            Jeu_Dao jeulogin = new Jeu_Dao();
            int result = jeulogin.insert(niveaux);
                    
                    if (result > 0) {
                        System.out.println("Insertion réussie ! ");
                    }else {
                        System.out.println("Insertion échouée !");
                    }
                    
                       // List<jeu_login> res = jeu_login.findall();
                       List<jeu_login> res = Jeu_Dao.findAll();
                        
                            for (int i = 0; i < res.size(); i++){
                                System.out.println("Contenu de la table 'niveaux' :");
                                System.out.println("------------------------------------------------------------------");
                                System.out.println("Id_niveaux = " + res.get(i).getId_niveaux());
                                 System.out.println("Id_mot = " + res.get(i).getMot());
                                System.out.println("Id_images = " + res.get(i).getId_images());
                                System.out.println("Id_indice = " + res.get(i).getId_indice());
                                System.out.println("Numero_niveaux = " + res.get(i).getNumero_niveaux());
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Total de insertion : " + res.size() + " enregistrement(s)");
                                System.out.println("fin  \n");
                    }
        
        
    }
    
}
