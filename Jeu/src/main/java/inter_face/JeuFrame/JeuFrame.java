/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inter_face.JeuFrame;

import DAO.jeu_login;

import DAO.Jeu_Dao;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

    

/**
 *
 * @author Admin
 */



public class JeuFrame extends JFrame {
  
    private final JLabel[] imageLabels = new JLabel[4];          
    private JTextField[] casesReponse;
    private JPanel panelReponse = new JPanel();
    private JLabel labelNiveau;                             
    private JButton[] boutonsAssocies;
    private int score = 0;
    private JLabel labelPieces;                            
    private JButton btnValider;                             
    private JButton btnSuivant;                             
    private JButton btnEffacer;                                                  
    private JButton[] boutonsLettres;          
    private JPanel panelClavier;
    
    private List<jeu_login> listeNiveaux;                   
    private int indexNiveauActuel = 0;                      
    private String motCorrectActuel = "";                  

   
public JeuFrame() {
    setTitle("4 Images 1 Mot");
    setSize(550, 650);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

     try {
        listeNiveaux = Jeu_Dao.findAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement des niveaux !");
            e.printStackTrace();
        listeNiveaux = new ArrayList<>(); // éviter null
}

    // Affichage de l'écran d'accueil au démarrage
    add(creerEcranDemarrage(), BorderLayout.CENTER);
}

   
    public JPanel barreHaut() {
        JPanel panel = new JPanel();                        
       panel.setBackground(new Color(102, 0, 153));     
        panel.setPreferredSize(new Dimension(450, 80));    

        labelNiveau = new JLabel();            
        labelNiveau.setForeground(Color.WHITE);           
        labelNiveau.setFont(new Font("Arial", Font.BOLD, 30)); 

        labelPieces = new JLabel("Pièces : 00");           
        labelPieces.setForeground(new Color(255, 193, 7));
        labelPieces.setFont(new Font("Arial", Font.BOLD, 20));
        
     

        panel.add(labelNiveau);                        
        panel.add(Box.createHorizontalStrut(150));          
        panel.add(labelPieces);

        return panel;                                      
    }
    
    //eran d"acceuil
private JPanel creerEcranDemarrage() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(new Color(75, 0, 130)); // Violet foncé

    // 4 images pour pour l'eccueil 
    JPanel panelImages = new JPanel(new GridLayout(2, 2, 25, 25));
    panelImages.setOpaque(false);
    panelImages.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));


    String[] imagesAccueil = {
        "cardenas1.jpg",   
        "cardenas2.jpg",
        "cardenas3.jpg",
        "cardenas4.jpg"
    };

    for (String nomImage : imagesAccueil) {
        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        imgLabel.setOpaque(true);
        imgLabel.setBackground(new Color(50, 0, 90));

       
        String chemin = "images/" + nomImage;
        ImageIcon icon = new ImageIcon(chemin);
        
        if (icon.getIconWidth() == -1) {
      
            imgLabel.setText("Image manquante");
            imgLabel.setForeground(Color.WHITE);
            imgLabel.setFont(new Font("Arial", Font.BOLD, 14));
        } else {
           
            Image img = icon.getImage().getScaledInstance(180, 140, Image.SCALE_SMOOTH);
            imgLabel.setIcon(new ImageIcon(img));
        }
        
        panelImages.add(imgLabel);
    }

    // Bouton Démarrer
    JButton btnDemarrer = new JButton("Démarrer");
    btnDemarrer.setFont(new Font("Arial", Font.BOLD, 28));
    btnDemarrer.setBackground(new Color(135, 206, 250));
    btnDemarrer.setForeground(Color.BLACK);
    btnDemarrer.setPreferredSize(new Dimension(280, 75));
    btnDemarrer.setFocusPainted(false);

    JPanel bottom = new JPanel();
    bottom.setOpaque(false);
    bottom.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
    bottom.add(btnDemarrer);

    panel.add(panelImages, BorderLayout.CENTER);
    panel.add(bottom, BorderLayout.SOUTH);

    // action bouton
    btnDemarrer.addActionListener(e -> lancerLeJeu());

    return panel;
}

private void lancerLeJeu() {
    getContentPane().removeAll();          
    add(barreHaut(), BorderLayout.NORTH);
    add(zoneImages(), BorderLayout.CENTER);
    add(zoneBas(), BorderLayout.SOUTH);
    revalidate();
    repaint();
    chargerNiveauActuel();                 
}

    
    private void majScore() {
    labelPieces.setText("Pièces : " + score);
}

  
    public JPanel zoneImages() {
                    
       JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));    
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        panel.setBackground(new Color(102, 0, 153)); 
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(2, 2, 15, 15));
        
            for (int i = 0; i < 4; i++) {
    imageLabels[i] = new JLabel();
    imageLabels[i].setHorizontalAlignment(JLabel.CENTER);
    imageLabels[i].setVerticalAlignment(JLabel.CENTER);
    panel.add(imageLabels[i]);
}

        return panel;
    }


private JPanel zoneBas() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(new Color(102, 0, 153));  
    panel.add(zoneReponse(), BorderLayout.NORTH);

    panelClavier = new JPanel(); // ✅ IMPORTANT
    panelClavier.setLayout(new GridLayout(3, 9, 6, 6));
    panel.add(panelClavier, BorderLayout.CENTER);
    panelClavier.setBackground(new Color(102, 0, 153));

    panel.add(zoneActions(), BorderLayout.SOUTH);

    return panel;
}

private void mettreAJourClavier() {
    panelClavier.removeAll();

    List<Character> lettres = genererLettresMelangees(motCorrectActuel);
    boutonsLettres = new JButton[lettres.size()];

    for (int i = 0; i < lettres.size(); i++) {
        JButton btn = new JButton(String.valueOf(lettres.get(i)));
        btn.setFont(new Font("Arial", Font.BOLD, 20));

        boutonsLettres[i] = btn;
        
       
        btn.setFont(new Font("Arial", Font.BOLD, 22));
        btn.setBackground(Color.BLACK); 
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder((Color.WHITE), 2));
        btn.setPreferredSize(new Dimension(30, 35));

        btn.addActionListener(e -> gererClicLettre(btn));

        panelClavier.add(btn);
    }

    panelClavier.revalidate();
    panelClavier.repaint();
}
    
 
  private JPanel zoneReponse() {
    panelReponse = new JPanel();
    panelReponse.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    return panelReponse;
}
  
  
  private void creerCasesReponse(int longueurMot) {

    panelReponse.removeAll(); 
    
    panelReponse.setBackground(new Color(102, 0, 153));

    panelReponse.setLayout(new GridLayout(1, longueurMot, 10, 10));

    casesReponse = new JTextField[longueurMot];
    boutonsAssocies = new JButton[longueurMot];

    for (int i = 0; i < longueurMot; i++) {
        casesReponse[i] = new JTextField();
        casesReponse[i].setHorizontalAlignment(JTextField.CENTER);
        casesReponse[i].setFont(new Font("Arial", Font.BOLD, 24));
        casesReponse[i].setEditable(false);
        
        
        casesReponse[i].setBackground(Color.WHITE);
        casesReponse[i].setForeground(Color.BLACK);
        casesReponse[i].setPreferredSize(new Dimension(40, 45));
        casesReponse[i].setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder((Color.BLACK), 3),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)
    ));
        casesReponse[i].setFont(new Font("Arial", Font.BOLD, 28));

 
        final int index = i;  
        casesReponse[i].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                effacerLettreDansCase(index);
            }
        });
        

        panelReponse.add(casesReponse[i]);
    }

    panelReponse.revalidate();
    panelReponse.repaint();
}
  
private void effacerLettreDansCase(int indexCase) {
    JTextField caseCliquee = casesReponse[indexCase];

    if (!caseCliquee.getText().trim().isEmpty()) {

        caseCliquee.setText("");

        //reaction du bouton
        if (boutonsAssocies[indexCase] != null) {
            boutonsAssocies[indexCase].setEnabled(true);
            boutonsAssocies[indexCase] = null;
        }
    }
}
  

   
    
       private List<Character> genererLettresMelangees(String mot) {
    List<Character> lettres = new ArrayList<>();
    Random random = new Random();

    // Ajouter lettres du mot
    for (char c : mot.toCharArray()) {
        lettres.add(c);
    }

    // Ajouter lettres aléatoires
    while (lettres.size() < 12) {
        char lettre = (char) ('A' + random.nextInt(26));
        lettres.add(lettre);
    }

    Collections.shuffle(lettres);
    return lettres;
}
 
private void gererClicLettre(JButton bouton) {
    String lettre = bouton.getText();

    if (bouton.isEnabled()) {
        for (int i = 0; i < casesReponse.length; i++) {
            if (casesReponse[i].getText().trim().isEmpty()) {
                casesReponse[i].setText(lettre);

                boutonsAssocies[i] = bouton; 
                bouton.setEnabled(false);
                return;
            }
        }
    }
}
    
    private void reinitialiserClavier() {
    if (boutonsLettres == null) return;

    for (JButton btn : boutonsLettres) {
        btn.setEnabled(true);           
    }
   
}
    

    private JPanel zoneActions() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());               
         panel.setBackground(new Color(102, 0, 153));

        btnValider = new JButton("VALIDER");               
        btnValider.setFont(new Font("Arial", Font.BOLD, 16));
        btnValider.setBackground(new Color(135, 206, 250));
        btnValider.setForeground(Color.BLACK);
        btnValider.addActionListener(e -> validerReponse()); 
        panel.add(btnValider);

        btnSuivant = new JButton("SUIANT");        
        btnSuivant.setFont(new Font("Arial", Font.BOLD, 16));
        btnSuivant.setBackground(new Color(135, 206, 250));
        btnSuivant.setForeground(Color.BLACK);
        btnSuivant.addActionListener(e -> niveauSuivant());
        panel.add(btnSuivant);

        btnEffacer = new JButton("EFFACER");         
        btnEffacer.setFont(new Font("Arial", Font.BOLD, 16));
        btnEffacer.setBackground(new Color(135, 206, 250));
        btnEffacer.setForeground(Color.BLACK);
        btnEffacer.addActionListener(e -> effacerToutesLesCases());
        panel.add(btnEffacer);
        
        JButton btnRetour = new JButton("RETOUR");
        btnRetour.setFont(new Font("Arial", Font.BOLD, 16));
        btnRetour.setBackground(new Color(135, 206, 250)); 
        btnRetour.setForeground(Color.BLACK);           
        btnRetour.addActionListener(e -> niveauPrecedent());
        panel.add(btnRetour);

      

        return panel;
    }
    
    private void niveauPrecedent() {
    if (indexNiveauActuel > 0) {
        indexNiveauActuel--;      
        chargerNiveauActuel();   
    } else {
        JOptionPane.showMessageDialog(this, "Vous êtes déjà au premier niveau !");
    }
}

    
private void effacerToutesLesCases() {
    for (int i = 0; i < casesReponse.length; i++) {
        casesReponse[i].setText("");

        if (boutonsAssocies[i] != null) {
            boutonsAssocies[i].setEnabled(true);
            boutonsAssocies[i] = null;
        }
    }
}


    private void chargerNiveauActuel() {
    if (listeNiveaux.isEmpty() || indexNiveauActuel >= listeNiveaux.size()) {
        JOptionPane.showMessageDialog(this, "Fin des niveaux ! Bravo !");
        return;
    }

    jeu_login niveau = listeNiveaux.get(indexNiveauActuel);

 
    System.out.println("=== DEBUG NIVEAU " + (indexNiveauActuel + 1) + " ===");
    System.out.println("image1 : " + niveau.getImages1());
    
    System.out.println("numero_niveaux : " + niveau.getNumero_niveaux());
    System.out.println("mot            : " + niveau.getMot());
    System.out.println("image1         : " + niveau.getImages1());
    System.out.println("image2         : " + niveau.getImages2());
    System.out.println("image3         : " + niveau.getImages3());
    System.out.println("image4         : " + niveau.getImages4());
  

    labelNiveau.setText("" + niveau.getNumero_niveaux());

    motCorrectActuel = niveau.getMot().toUpperCase();
    if (motCorrectActuel == null || motCorrectActuel.trim().isEmpty()) {
        motCorrectActuel = "MOT_INCONNU";
    }
    //lieson avec zone text dynamique
    creerCasesReponse(motCorrectActuel.length());
    mettreAJourClavier();

    String[] nomsImages = {
        niveau.getImages1(),
        niveau.getImages2(),
        niveau.getImages3(),
        niveau.getImages4()
    };
    
  for (int i = 0; i < 4; i++) {
    String nomFichier = nomsImages[i];

    if (nomFichier == null || nomFichier.trim().isEmpty()) {
        imageLabels[i].setIcon(null);
        imageLabels[i].setText("Pas d'image");
        continue;
    }

    nomFichier = nomFichier.trim();

   
     String chemin = new java.io.File("images/" + nomFichier).getAbsolutePath();

    System.out.println("➡️ Chargement : " + chemin);

    ImageIcon icon = new ImageIcon(chemin);

    
    if (icon.getIconWidth() == -1) {
        imageLabels[i].setIcon(null);
        imageLabels[i].setText("Introuvable");
        System.out.println("❌ Image non trouvée : " + chemin);
    } else {
         Image img = icon.getImage().getScaledInstance(250, 190, Image.SCALE_SMOOTH);
        imageLabels[i].setIcon(new ImageIcon(img));
        imageLabels[i].setText("");
    }
}

        effacerToutesLesCases();                            
        reinitialiserClavier();         
        
        revalidate();
        repaint();

        
    }

    private void validerReponse() {
        StringBuilder reponse = new StringBuilder();        
        for (JTextField tf : casesReponse) {
            reponse.append(tf.getText().trim());
        }

        String reponseUtilisateur = reponse.toString().toUpperCase();

      if (reponseUtilisateur.equals(motCorrectActuel.toUpperCase())) {
    JOptionPane.showMessageDialog(this, "✅ BRAVO ! C'est correct !", "Victoire", JOptionPane.INFORMATION_MESSAGE);

    //  Ajouter des points
    score += 100;         
    majScore();          

    niveauSuivant();    
} else {
    JOptionPane.showMessageDialog(this, "❌ Mauvaise réponse.", "Raté", JOptionPane.ERROR_MESSAGE);
}
    }

    private void niveauSuivant() {
        indexNiveauActuel++;                               
        chargerNiveauActuel();                              
    }

   }         
    

