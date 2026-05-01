/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classe_du_jeux.Mots;
import com.vladimir.jeu.jeu.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Admin
 */
public class Jeu_Dao {

        public static List<jeu_login> findAll() throws Exception {
            List<jeu_login> result = new ArrayList<>();
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
              /*  String sql = "SELECT id_niveaux, id_mot, id_images, id_indice, numero_niveaux\n" +
"	FROM public.niveaux;";
                
                //Tabler mot
                String sqlmot = "SELECT id_mot, mot\n" +
"	FROM public.mot;";
                
                String sqlimages = "SELECT id_images, id_mot, id_niveaux, id_indice, images1, images2, images3, images4\n" +
"	FROM public.images;";*/
              
           String sql = 
    "SELECT \n" +
    "    n.id_niveaux, n.id_mot, n.id_images, n.numero_niveaux,\n" +
    "    m.mot,\n" +
    "    i.image1, i.image2, i.image3, i.image4\n" +
    "FROM niveaux n\n" +
    "JOIN mot m ON n.id_mot = m.id_mot\n" +
    "JOIN images i ON n.id_images = i.id_images\n" +
    "ORDER BY n.numero_niveaux ASC";
                
                try {
                    c = (Connection) Connectivity.getConnection();
                    ps = c.prepareCall(sql);
                    rs = ps.executeQuery();
                        
                        while (rs.next()){
                            jeu_login niveau = new jeu_login();
                            
                                niveau.setId_niveaux(rs.getInt("id_niveaux"));
                                niveau.setId_mot(rs.getInt("id_mot"));
                                niveau.setId_images(rs.getInt("id_images"));
                                niveau.setId_indice(rs.getInt(1));
                                niveau.setNumero_niveaux(rs.getString("numero_niveaux"));
                                niveau.setMot(rs.getString("mot"));
                                niveau.setImages1(rs.getString("image1"));
                                niveau.setImages2(rs.getString("image2"));
                                niveau.setImages3(rs.getString("image3"));
                                niveau.setImages4(rs.getString("image4"));
                                result.add(niveau);
                        }
                                
                                
                                 while (rs.next()){
                            jeu_login mot = new jeu_login();
                                
                                //Insertion mot
                                mot.setId_mot(rs.getInt("id_mot"));
                                mot.setMot(rs.getString("mot"));
                                
                                result.add(mot);
                        }
                                while (rs.next()){
                            jeu_login image = new jeu_login(); 
                            
                                image.setId_images(rs.getInt("id_images"));
                                image.setImages1(rs.getString("image1"));
                                image.setImages2(rs.getString("image2"));
                                image.setImages3(rs.getString("image3"));
                                image.setImages4(rs.getString("image4"));
                                
                                result.add(image);
                        }
                    
                } catch(Exception e){
                    throw e;
                    
                }finally {
                    if (rs != null)
                        rs.close();
                }
                 if (ps != null){
                        ps.close();
                 }
                  if (c != null){
                        c.close();
                  }
                  return result;
        }

   

    public Jeu_Dao() {
    }
        
              public  int insert(jeu_login niveaux) throws SQLException{
                 
                 Connection c = null;
                 PreparedStatement ps = null;
                 int rowsAffected = 0;
                 
                    String sql = "INSERT INTO public.niveaux(\n" +
"	id_niveaux, id_mot, id_images, id_indice, numero_niveaux)\n" +
"	VALUES (?, ?, ?, ?, ?);";
                    
                    try {
                        c = Connectivity.getConnection();
                        ps = c.prepareCall(sql);
                        
                            ps.setInt(1,niveaux.getId_niveaux());
                            ps.setInt(2, niveaux.getId_mot());
                            ps.setInt(3, niveaux.getId_images());
                            ps.setInt(4, niveaux.getId_indice());
                            ps.setString(5, niveaux.getNumero_niveaux());
                            
                                    
                                    rowsAffected = ps.executeUpdate();
                    }finally{
                        if (ps != null) try { ps.close(); } catch (Exception ignored) {}
                        if (c != null) try { c.commit(); } catch (Exception ignored) {}
                    }
                        return rowsAffected;
            }
              
            

            public  int insertMot(jeu_login mot) throws SQLException{
                 
                 Connection c = null;
                 PreparedStatement ps = null;
                 int rowsAffected = 1;
                 
                    
                    
                    //table mot
                    String sql = "INSERT INTO public.mot(\n" +
"	id_mot, mot)\n" +
"	VALUES (?, ?);";
                    
                    try {
                        c = Connectivity.getConnection();
                        ps = c.prepareCall(sql);
                        
                        ps.setInt(1, mot.getId_mot());
                        ps.setString(2, mot.getMot());
                                    
                                    rowsAffected = ps.executeUpdate();
                    }finally{
                        if (ps != null) try { ps.close(); } catch (Exception ignored) {}
                        if (c != null) try { c.commit(); } catch (Exception ignored) {}
                    }
                        return rowsAffected;
            }  
              
             
             public  int insertImages(jeu_login images) throws SQLException{
                 
                 Connection c = null;
                 PreparedStatement ps = null;
                 int rowsAffected = 0;
                 
                    
                    
                    //table mot
                    String sql = "INSERT INTO public.images(\n" +
"	id_images, image1, image2, image3, image4)\n" +
"	VALUES (?, ?, ?, ?, ?);";
                    
                    try {
                        c = Connectivity.getConnection();
                        ps = c.prepareCall(sql);
                        
                        ps.setInt(1, images.getId_images());
                        ps.setString(2, images.getImages1());
                        ps.setString(3, images.getImages2());
                        ps.setString(4, images.getImages3());
                        ps.setString(5, images.getImages4());
                                    
                                    rowsAffected = ps.executeUpdate();
                    }finally{
                        if (ps != null) try { ps.close(); } catch (Exception ignored) {}
                        if (c != null) try { c.commit(); } catch (Exception ignored) {}
                    }
                        return rowsAffected;
            }  
              

             
                public static String getMotById(String Id_mot) throws SQLException{
                    String sqlgetMotById = "SELECT id_mot, mot\n" +
"	FROM public.mot Where id_mot = ?;";
                    
                    try (
                            Connection c = Connectivity.getConnection();
                            PreparedStatement ps = c.prepareCall(sqlgetMotById)){
                       // ps.setInt(1, Id_mot);
                       ps.setInt(1, 1);
                        
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("mot");
                }
            }
        }
        return null; // si pas trouvé
    }
                
   }


              