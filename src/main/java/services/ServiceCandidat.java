/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Candidat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sadbo
 */
public class ServiceCandidat {
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public ServiceCandidat () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCandidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Candidat> AfficherCandidat(int id) {
        List<Candidat> candidats = new ArrayList<>();
        Candidat ca = null;
        
        String r = "SELECT users.fullname, users.tel, users.email, a.matchs, user_skills.skill1_id, user_skills.skill2_id, user_skills.skill3_id, user_langues.langue1_ref, user_langues.langue2_ref, users.id FROM users "
                + "JOIN (SELECT user_id, matchs FROM applications WHERE offre_id = ?) a "
                + "ON a.user_id = users.id "
                + "JOIN user_skills "
                + "ON user_skills.user_id = users.id "
                + "JOIN user_langues "
                + "ON user_langues.user_id = users.id ORDER BY a.matchs DESC;";
  
       try {
        
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                ca = new Candidat();
                    ca.setFullname(res.getString(1));
                    ca.setTel(res.getString(2));
                    ca.setEmail(res.getString(3));
                    ca.setMatch(res.getDouble(4));
                    ca.setSkill1(res.getInt(5));
                    ca.setSkill2(res.getInt(6));
                    ca.setSkill3(res.getInt(7));
                    ca.setLangue1(res.getInt(8));
                    ca.setLangue2(res.getInt(9));
                    ca.setId(res.getInt("users.id"));
                candidats.add(ca);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCandidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return candidats;
    
    
}
    
}
