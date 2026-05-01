/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inter_face.JeuFrame;

import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class NewMain {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    SwingUtilities.invokeLater(()-> {
        new JeuFrame().setVisible(true);
    });
    
}
}
