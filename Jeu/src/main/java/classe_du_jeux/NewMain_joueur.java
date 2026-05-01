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
public class NewMain_joueur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
      /*  jeu_login joueur = new jeu_login();
        
        joueur.setId_joueur(1);
        joueur.setNom_joueur("James");
        joueur.setScore(1);
        joueur.setNiveau_actuel(1);
        
        
                Jeu_Dao jeulogin = new Jeu_Dao();
            int result = jeulogin.insertJoueur(joueur);
                    
                    if (result > 0) {
                        System.out.println("Insertion réussie ! ");
                    }else {
                        System.out.println("Insertion échouée !");
                    }
                    
                       // List<jeu_login> res = jeu_login.findall();
                       List<jeu_login> res = Jeu_Dao.findAll();
                        
                            for (int i = 0; i < res.size(); i++){
                                System.out.println("Contenu de la table 'joueur' :");
                                System.out.println("------------------------------------------------------------------");
                                 System.out.println("Id_joueur = " + res.get(i).getId_joueur());
                                System.out.println("nom_joueur = " + res.get(i).getNom_joueur());
                                System.out.println("Score  = " + res.get(i).getScore());
                                System.out.println("niveux = " + res.get(i).getNiveau_actuel());
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Total de insertion : " + res.size() + " enregistrement(s)");
                                System.out.println("fin  \n");
                    }*/
    }
    
}
