/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Admin
 */
public class jeu_login {

      
    private int id_niveaux;
      private int id_mot;
      private int id_images;
      private int id_indice;
      private String numero_niveaux;
      public String mot;
      public String images1;
      public String images2;
      public String images3;
      public String images4;
      public int id_joueur;
      public String nom_joueur;
      public int score;
      public int niveau_actuel;
              

    public jeu_login() {
    }

    public jeu_login(int id_niveaux, int id_mot, int id_images, int id_indice, String numero_niveaux, String mot, String images1, String images2, String images3, String images4, int id_joueur, String nom_joueur, int score, int niveau_actuel) {
        this.id_niveaux = id_niveaux;
        this.id_mot = id_mot;
        this.id_images = id_images;
        this.id_indice = id_indice;
        this.numero_niveaux = numero_niveaux;
        this.mot = mot;
        this.images1 = images1;
        this.images2 = images2;
        this.images3 = images3;
        this.images4 = images4;
        this.id_joueur = id_joueur;
        this.nom_joueur = nom_joueur;
        this.score = score;
        this.niveau_actuel = niveau_actuel;
    }

    public int getId_niveaux() {
        return id_niveaux;
    }

    public void setId_niveaux(int id_niveaux) {
        this.id_niveaux = id_niveaux;
    }

    public int getId_mot() {
        return id_mot;
    }

    public void setId_mot(int id_mot) {
        this.id_mot = id_mot;
    }

    public int getId_images() {
        return id_images;
    }

    public void setId_images(int id_images) {
        this.id_images = id_images;
    }

    public int getId_indice() {
        return id_indice;
    }

    public void setId_indice(int id_indice) {
        this.id_indice = id_indice;
    }

    public String getNumero_niveaux() {
        return numero_niveaux;
    }

    public void setNumero_niveaux(String numero_niveaux) {
        this.numero_niveaux = numero_niveaux;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getImages1() {
        return images1;
    }

    public void setImages1(String images1) {
        this.images1 = images1;
    }

    public String getImages2() {
        return images2;
    }

    public void setImages2(String images2) {
        this.images2 = images2;
    }

    public String getImages3() {
        return images3;
    }

    public void setImages3(String images3) {
        this.images3 = images3;
    }

    public String getImages4() {
        return images4;
    }

    public void setImages4(String images4) {
        this.images4 = images4;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNiveau_actuel() {
        return niveau_actuel;
    }

    public void setNiveau_actuel(int niveau_actuel) {
        this.niveau_actuel = niveau_actuel;
    }        
    
}
