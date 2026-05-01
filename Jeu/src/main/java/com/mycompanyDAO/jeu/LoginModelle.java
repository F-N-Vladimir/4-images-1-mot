package com.mycompanyDAO.jeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
class LoginModelle {
    
        private int idmot;
        private String mot;
        private String image_1;
        private String image_2;
        private String image_3;
        private String image_4;

    public LoginModelle() {
    }
     
    	
        public LoginModelle (int idmot, String mot, String image_1, String image_2,String image_3,String image_4){
            
            
	this.idmot   =  idmot;
        this.mot     =  mot;
        this.image_1 =  image_1;
        this.image_2 =  image_2;
        this.image_3 =  image_3;
        this.image_4 =  image_4;
            
        
        
        }

    public int getIdmot() {
        return idmot;
    }

    public void setIdmot(int idmot) {
        this.idmot = idmot;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }

    public String getImage_4() {
        return image_4;
    }

    
    
}
