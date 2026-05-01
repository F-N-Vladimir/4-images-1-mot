package com.mycompanyDAO.jeu;


import com.vladimir.jeu.jeu.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class LoginDAO {

    
    public static List<LoginModelle> findall() throws Exception {

        //List<LoginModelle> result = new Array() {};
        List<LoginModelle> result = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM public.jeu;";

        try {
            //c = Connectivity.getConnection();
            c = (Connection) Connectivity.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                LoginModelle lm = new LoginModelle();

                lm.setIdmot(rs.getInt(1));
                lm.setMot(rs.getString(2));
                lm.setImage_1(rs.getString(3));
                lm.setImage_2(rs.getString(4));
                lm.setImage_3(rs.getString(5));
                lm.setImage_4(rs.getString(6));

                result.add(lm);
            }

        } catch (Exception e) {
            throw e;

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }

            return result;

        }
    }

   
    public static int insert(LoginModelle mot) throws SQLException {
    Connection c = null;
    PreparedStatement ps = null;
    int rowsAffected = 0;
    
    String sql = "INSERT INTO public.jeu (mot, image_1, image_2, image_3, image_4) "
               + "VALUES (?, ?, ?, ?, ?)";
    
    try {
        c = Connectivity.getConnection();
        ps = c.prepareStatement(sql);
        
        ps.setString(1, mot.getMot());
        ps.setString(2, mot.getImage_1());
        ps.setString(3, mot.getImage_2());
        ps.setString(4, mot.getImage_3());
        ps.setString(5, mot.getImage_4());
        
        rowsAffected = ps.executeUpdate();
    } finally {
        if (ps != null) try { ps.close(); } catch (Exception ignored) {}
        if (c != null) try { c.close(); } catch (Exception ignored) {}
    }
    
    return rowsAffected;
}
    
   } 
