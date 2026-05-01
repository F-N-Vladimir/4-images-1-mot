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
public class NewMain_Images {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        
         jeu_login images = new jeu_login();
            
            images.setId_images(5);
            images.setImages1("equipe1.jpg");
            images.setImages2("equipe2.jpg");
            images.setImages3("equipe3.jpg");
            images.setImages4("equipe4.jpg");
            
            
            
            Jeu_Dao jeulogin = new Jeu_Dao();
            int result = jeulogin.insertImages(images);
                    
                    if (result > 0) {
                        System.out.println("Insertion réussie ! ");
                    }else {
                        System.out.println("Insertion échouée !");
                    }
                    
                       // List<jeu_login> res = jeu_login.findall();
                       List<jeu_login> res = Jeu_Dao.findAll();
                        
                            for (int i = 0; i < res.size(); i++){
                                System.out.println("Contenu de la table 'Images' :");
                                System.out.println("------------------------------------------------------------------");
                                System.out.println("Id_images = " + res.get(i).getId_images());
                                System.out.println("images 1 = " + res.get(i).getImages1());
                                System.out.println("images 2 = " + res.get(i).getImages2());
                                System.out.println("images 3 = " + res.get(i).getImages3());
                                System.out.println("images 4 = " + res.get(i).getImages4());
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("Total de insertion : " + res.size() + " enregistrement(s)");
                                System.out.println("fin  \n");
                    }
        
        
    
    }
    
}
