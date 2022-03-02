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
import utils.AttributeConstants;
import utils.AuthenticationConstants;
import utils.ResultConstants;
import utils.SQLQueriesConstants;

/**
 *
 * @author AhmedAli
 */
public class PlayerManagerImpl implements PlayerManager {
    
    private ConnectionDB con;
    private static PlayerManager playerManager;
    
    private PlayerManagerImpl(ConnectionDB con) {
        this.con = con;
    }
    
    public synchronized static PlayerManager getInstance(ConnectionDB con) {
        if (playerManager == null) {
            playerManager = new PlayerManagerImpl(con);
        }
        return playerManager;
    }
    
    @Override
    public int addNewPlayer(String username, String password, int score, boolean isOnline) {
        int result = -1;
        if (!isAlreadyRegistered(username)) {
            try {
                PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.ADD_NEW_PLAYER);
                
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, score);
                ps.setBoolean(4, isOnline);
                if(ps.executeUpdate()>0)
                    result = ResultConstants.SUCCESSFULLY_REGISTERED;
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                result = ResultConstants.DB_ERROR;
            }
        }else{
            result = ResultConstants.ALREADY_REGISTERED;
        }
       
        return result;
    }
    
    @Override
    public boolean updatePlayerScore(String username, int score) {
        
        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_PLAYER_SCORE);
            
            ps.setInt(1, score);
            ps.setString(2, username);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        
        return result;
    }
    
    @Override
    public boolean updatePlayerState(String username, boolean isOnline) {
        
        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_PLAYER_STATE);
            
            ps.setBoolean(1, isOnline);
            ps.setString(2, username);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        
        return result;
    }
    
    private ResultSet rs;
    
    @Override
    public Vector<PLayerDAO> selectAllPlayers() {
        
        rs = null;
        Vector<PLayerDAO> allPlayers = new Vector<>();
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ALL_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                allPlayers.add(new PLayerDAO(rs.getString(AttributeConstants.USERNAME), rs.getString(AttributeConstants.PASSWORD), rs.getInt(AttributeConstants.SCORE), rs.getBoolean(AttributeConstants.ISONLINE)));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allPlayers;
    }
    
    @Override
    public Vector<PLayerDAO> selectOnlinePlayers() {
        
        rs = null;
        Vector<PLayerDAO> onlinePlayers = new Vector<>();
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ONLINE_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                onlinePlayers.add(new PLayerDAO(rs.getString(AttributeConstants.USERNAME), rs.getString(AttributeConstants.PASSWORD), rs.getInt(AttributeConstants.SCORE), rs.getBoolean(AttributeConstants.ISONLINE)));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return onlinePlayers;
    }
    
    @Override
    public int login(String userName, String password) {
        rs = null;
        int result = ResultConstants.DB_ERROR;
        
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.LOGIN_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(userName) && rs.getString(2).equals(password)) {
                    if (rs.getBoolean(4)) {
                        result = ResultConstants.ALREADY_LOGGINED;
                    } else {
                        result = ResultConstants.SUCCESSFULLY_LOGGINED;
                        updatePlayerState(userName, true);
                    }
                } else {
                    result = ResultConstants.WRONG_USERNAME_OR_PASSWORD;
                }
            }
            
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            result = ResultConstants.DB_ERROR;
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public void releaseResources() {
        // server close => release data
        con.close();
        playerManager = null;
    }
    
    @Override
    public boolean isAlreadyRegistered(String username) {
        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.IS_ALREADY_REGISTERED_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
