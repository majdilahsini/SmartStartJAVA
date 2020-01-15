/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;

/**
 *
 * @author p
 */
public class DBConnection {
    
    static String url = "jdbc:mysql://localhost:3306/start";
    static String login = "root";
    static String password = "";
    static Connection c;
    static DBConnection instanceBD;
    
    private DBConnection() {
        
        try {
            
            c = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static DBConnection getInstance() {
        if (instanceBD == null)
            instanceBD = new DBConnection();
        return instanceBD;
    }
    
    public Connection getConnection() {
        return c;
    }
    
}
  