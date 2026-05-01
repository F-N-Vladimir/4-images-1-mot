/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe_du_jeux;

/**
 *
 * @author Admin
 */
public class ImagesNiveau {
    private int idImages;
    private String cheminImages;
    private String motCorrect; //le mot a trouver sur les 4 images afficher

    public ImagesNiveau(int idImages, String cheminImages, String motCorrect) {
        this.idImages = idImages;
        this.cheminImages = cheminImages;
        this.motCorrect = motCorrect;
    }

    public int getIdImages() {
        return idImages;
    }

    public void setIdImages(int idImages) {
        this.idImages = idImages;
    }

    public String getCheminImages() {
        return cheminImages;
    }

    public void setCheminImages(String cheminImages) {
        this.cheminImages = cheminImages;
    }

    public String getMotCorrect() {
        return motCorrect;
    }

    public void setMotCorrect(String motCorrect) {
        this.motCorrect = motCorrect;
    }
    
            
}
