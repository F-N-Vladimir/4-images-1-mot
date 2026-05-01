/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe_du_jeux;

import java.awt.Image;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Niveau {

    public Niveau(int par, String ami, List<ImagesNiveau> imagesTest) {
    }/*SELECT id_niveaux, id_mot, id_images, id_indice, numero_niveaux
	FROM public.niveaux;*/
    
      private int id_niveaux;
      private int id_mot;
      private int id_images;
      private String numero_niveaux;

    public Niveau() {
    }

    public Niveau(int id_niveaux, int _mot, int id_images, String numero_niveaux) {
        this.id_niveaux = id_niveaux;
        this.id_mot = _mot;
        this.id_images = id_images;
        this.numero_niveaux = numero_niveaux;
    }

    public int getId_niveaux() {
        return id_niveaux;
    }

    public void setId_niveaux(int id_niveaux) {
        this.id_niveaux = id_niveaux;
    }

    public int getMot() {
        return id_mot;
    }

    public void setMot(int _mot) {
        this.id_mot = _mot;
    }

    public int getId_images() {
        return id_images;
    }

    public void setId_images(int id_images) {
        this.id_images = id_images;
    }

    public String getNumero_niveaux() {
        return numero_niveaux;
    }

    public void setNumero_niveaux(String numero_niveaux) {
        this.numero_niveaux = numero_niveaux;
    }
    
            
      
      
            

}
