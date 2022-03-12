/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author AhmedAli
 */
public class ConnectionDB {
    
    private Connection con;
    private static ConnectionDB connectionDB;
    
    private ConnectionDB() throws SQLException{
        ClientDriver d = new ClientDriver();
        DriverManager.registerDriver(d);
        System.out.println("ConnectionDB(): Succeeded!");
        
        
        if (con == null) {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PlayerDB", "root", "root");

        }
    }
    

    
    void close(){ 
        
        try {
            con.close();
            System.out.println("close(): Succeeded!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("close(): Failed!");
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public static synchronized ConnectionDB getInstance() throws SQLException{
        if(connectionDB == null) {
            connectionDB = new ConnectionDB();
        }
        return connectionDB;
    }
}
