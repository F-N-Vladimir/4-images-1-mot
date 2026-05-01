/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe_du_jeux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Mots {
    
    private int id_mot;
    private String mot;
    private List<Character> lettresMelangees;
    private Character alea;

    public Mots(int id_mot, String mot, List<Character> lettresMelangees, Character alea) {
        this.id_mot = id_mot;
        this.mot = mot;
        this.lettresMelangees = lettresMelangees;
        this.alea = alea;
    }

  /*  public int getIdmot() {
        return id_mot;
    }

    public void setIdmot(int idmot) {
        this.id_mot = idmot;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public List<Character> getLettresMelangees() {
        return lettresMelangees;
    }*/

    public int getId_mot() {
        return id_mot;
    }

    public void setId_mot(int id_mot) {
        this.id_mot = id_mot;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
    
    

    public void setLettresMelangees(List<Character> lettresMelangees) {
        this.lettresMelangees = lettresMelangees;
    }

    public Character getAlea() {
        return alea;
    }

    public void setAlea(Character alea) {
        this.alea = alea;
    }
    
            
    
         public  Mots(String mot){
             
             this.mot = mot.toLowerCase().trim();
             this.lettresMelangees = new ArrayList<>();
             genererLettresMelangees();
                     
         }
    
         //Methode qui vas melanger les lettre + ajouter des lettre aleatoires
         
        private void genererLettresMelangees() {
            
              // On met les lettres du mot
              
                for (char c : mot.toCharArray()){
                  lettresMelangees.add(c);
            }
         //On ajoutes 8 a 12 lettres aleatoires en fonction des niveau de difficulter
                String lettresExtra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                
                int nombreExtra = 12 - mot.length(); // mot de 4 -> 8 lettres en plus 
                for (int i = 0; i < nombreExtra; i ++){
                char alea = lettresExtra.charAt((int)(Math.random() * lettresExtra.length()));
                    lettresMelangees.add(alea);
                }
                // On melange tout 
                Collections.shuffle(lettresMelangees);
        }
               public boolean verifierProposition(String proposition){
                   return proposition.toLowerCase().trim().equalsIgnoreCase(mot);
               }
               
               private String getMots(){
                   return mot;
               }
        
}