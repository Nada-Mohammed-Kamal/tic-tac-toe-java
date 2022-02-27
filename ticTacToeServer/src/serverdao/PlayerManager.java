/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AhmedAli
 */
public class PlayerManager {
    
    ConnectionDB con;
    
    boolean addNewPlayer(String username, String password, int score, boolean isOnline) {
        
        con = new ConnectionDB();
        boolean result = true;
        try {    
            PreparedStatement ps = con.getConnection().prepareStatement("INSERT INTO PLAYERS (USERNAME, PASSWORD, SCORE, ISONLINE) VALUES (?, ?, ?, ?)");
            
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, score);
            ps.setBoolean(4, isOnline);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        } finally {
            con.close();
        }
        
        return result;
    }
    
    boolean updatePlayerScore(String username, int score) {
        
        con = new ConnectionDB();
        boolean result = true;
        try{
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE PLAYERS SET " + "SCORE = ? " + "WHERE USERNAME = ?");
            
            ps.setInt(1, score);
            ps.setString(2, username);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        } finally {
            con.close();
        }
        
        return result;
    }
    
    boolean updatePlayerState(String username, boolean isOnline) {
        
        con = new ConnectionDB();
        boolean result = true;
        try{
            PreparedStatement ps = con.getConnection().prepareStatement("UPDATE PLAYERS SET " + "ISONLINE = ? " + "WHERE USERNAME = ?");
            
            ps.setBoolean(1, isOnline);
            ps.setString(2, username);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        } finally {
            con.close();
        }
        
        return result;
    }
    
    boolean deletePlayer(String username) {
        
        con = new ConnectionDB();
        boolean result = true;
        try{
            PreparedStatement ps = con.getConnection().prepareStatement("DELETE FROM PLAYERS WHERE USERNAME = ?");
            
            ps.setString(1, username);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        } finally {
            con.close();
        }
        
        return result;
    }
    
    private ResultSet rs;
    Vector<PLayerDAO> selectAllPlayers(){
        
        con = new ConnectionDB();
        rs = null;
        Vector<PLayerDAO> allPlayers = new Vector<>();
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM PLAYERS", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                allPlayers.add(new PLayerDAO(rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getInt("SCORE"), rs.getBoolean("ISONLINE")));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        
        return allPlayers;
    }
    
    Vector<PLayerDAO> selectOnlinePlayers(){
        
        con = new ConnectionDB();
        rs = null;
        Vector<PLayerDAO> onlinePlayers = new Vector<>();
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM PLAYERS WHERE ISONLINE = true", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                onlinePlayers.add(new PLayerDAO(rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getInt("SCORE"), rs.getBoolean("ISONLINE")));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        
        return onlinePlayers;
    }
    
    boolean login(String userName, String password){
        con = new ConnectionDB();
        rs = null;
        boolean result = false; 
        
        try{
            PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM PLAYERS WHERE USERNAME = ? AND PASSWORD = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next())
                if(rs.getString(1).equals(userName) && rs.getString(2).equals(password))
                    result = true;
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        
        return result;
    }
}
