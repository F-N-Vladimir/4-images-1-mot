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
public class NewMain_niveuax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
        jeu_login niveaux = new jeu_login();
        
        niveaux.setId_niveaux(5);
        niveaux.setId_mot(5);
        niveaux.setId_images(5);
        niveaux.setNumero_niveaux("Niveua 5");
        
        Jeu_Dao jeu = new Jeu_Dao();
      
        int result = jeu.insert(niveaux);
        
            if (result > 0 ) {
                System.out.println("Insertion réussie ! ");
            }else {
                System.out.println("Insertion échouée !");
            }
                
            List<jeu_login> res = Jeu_Dao.findAll();
            
                for (int i = 0; i < res.size(); i++){
                     System.out.println("Contenu de la table Niveaux :");
                                System.out.println("------------------------------------------------------------------");
                                System.out.println("Id_Niveaux = " + res.get(i).getId_niveaux());
                                System.out.println("Id_images = " + res.get(i).getId_images());
                                System.out.println("Id_mot = " +  res.get(i).getId_mot());
                                System.out.println("Numero_niveaux" + res.get(i).getNumero_niveaux());
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Total de insertion : " + res.size() + " enregistrement(s)");
                                System.out.println("fin  \n");
                    
                }
    }
    
}
