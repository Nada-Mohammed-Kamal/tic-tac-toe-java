/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import model.PlayerDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import tictactoeserver.GameHandler;
import tictactoeserver.OnAvailablePlayersChangeListeners;
import tictactoeserver.OnPlayerCountChangeListener;
import utils.AttributeConstants;
import utils.PlayerStatusValues;
import utils.ResultConstants;
import utils.SQLQueriesConstants;
//                                              WAITING
//                 false                        IN_Game
//Case isOnline == true && Status == PlayerStatus.Idel; ==> Should be shown in Online screen.
//WHEN TO OBSERVE
//when any player login
//when any player In_GAME ==> IDEL
//IDEL => WAITING 
//WAITING => IDEL
//player is inGame XXX ===> offline ???
//IDEL ==> 

/**
 *
 * @author AhmedAli
 */
public class PlayerManagerImpl implements PlayerManager {

    private OnPlayerCountChangeListener onPlayerCountChangeListener;
    private OnAvailablePlayersChangeListeners onAvailablePlayersChangeListener;
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
                if (ps.executeUpdate() > 0) {
                    result = ResultConstants.SUCCESSFULLY_REGISTERED;
                    updateServerStatistics();
                }
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                result = ResultConstants.DB_ERROR;
            }
        } else {
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
    public boolean updateIsPlayerOnline(String username, boolean isOnline) {

        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_PLAYER_STATE);

            ps.setBoolean(1, isOnline);
            ps.setInt(2, PlayerStatusValues.IDLE);
            ps.setString(3, username);

            ps.executeUpdate();
            updateServerStatistics();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }

        return result;
    }

    private ResultSet rs;

    @Override
    public int getAllPlayersCount() {

        rs = null;
        int sum = 0;

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ALL_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            while (rs.next()) {
                sum++;
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sum;
    }

    @Override
    public int getOnlinePlayersCount() {

        rs = null;
        Vector<PlayerDto> allPlayers = new Vector<>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ALL_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            while (rs.next()) {
                allPlayers.add(new PlayerDto(rs.getString(AttributeConstants.USERNAME), rs.getString(AttributeConstants.PASSWORD), rs.getInt(AttributeConstants.SCORE), rs.getBoolean(AttributeConstants.ISONLINE)));
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public List<String> getOnlinePlayers() {

        rs = null;
        List<String> onlinePlayers = new ArrayList<>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ONLINE_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            while (rs.next()) {
                onlinePlayers.add(rs.getString(AttributeConstants.USERNAME));
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return onlinePlayers;
    }

    @Override
    public int login(String userName, String password, Integer scoreRefrence) {
        rs = null;
        int result = ResultConstants.DB_ERROR;

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.LOGIN_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                scoreRefrence = rs.getInt(3);
                if (rs.getBoolean(4)) {
                    result = ResultConstants.ALREADY_LOGGINED;
                } else {
                    result = ResultConstants.SUCCESSFULLY_LOGGINED;
                    updateIsPlayerOnline(userName, true);
                }
            } else {
                // should be handeled as ResultConstants.UNREGISTERED_USER
                result = ResultConstants.WRONG_USERNAME_OR_PASSWORD;
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
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ALL_COL_FOR_USERNAME, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean updatePlayerStatusOnDB(String username, int state, int oldState) {

        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_PLAYER_STATUS);

            ps.setInt(1, state);
            ps.setString(2, username);
            ps.executeUpdate();
            updateServerStatistics();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        //Update if player
        if(state == PlayerStatusValues.IDLE || oldState == PlayerStatusValues.IDLE )
        updateAvailableOnlinePlayers();
        return result;
    }

    @Override
    public void setOnPlayerCountChangeListener(OnPlayerCountChangeListener onPlayerCountChangeListener) {
        this.onPlayerCountChangeListener = onPlayerCountChangeListener;
        updateServerStatistics();
    }

    @Override
    public void updateServerStatistics() {
        List<String> onlineUsers = getOnlinePlayers();
        int count = getAllPlayersCount();
        Platform.runLater(() -> {
            onPlayerCountChangeListener.onPlayerCountChange(onlineUsers, count);
        });
    }

    @Override
    public boolean logOut(String username, int oldState) {
        boolean result =false;
        result = updateIsPlayerOnline(username, false);
        if(oldState == PlayerStatusValues.IDLE)
            updateAvailableOnlinePlayers();

        return result;
    }
    //init 
    @Override
    public List<PlayerDto> getAvilableOnlinePlayersWithScores() {

        rs = null;
        List<PlayerDto> availableOnlinePlayers = new ArrayList<>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ONLINE_PLAYERS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();

            while (rs.next()) {
                if(rs.getBoolean(AttributeConstants.ISONLINE) && rs.getInt(AttributeConstants.STATUS) == PlayerStatusValues.IDLE)//Null in handler take Care
                    availableOnlinePlayers.add(new PlayerDto(rs.getString(AttributeConstants.USERNAME), "", rs.getInt(AttributeConstants.SCORE), true, null));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return availableOnlinePlayers;
    }
    
    


    @Override
    public PlayerDto getPlayer(String username) {
        PlayerDto player = null;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.SELECT_ALL_COL_FOR_USERNAME, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                player = new PlayerDto(username, "", rs.getInt(AttributeConstants.SCORE), rs.getInt(AttributeConstants.STATUS), rs.getBoolean(AttributeConstants.ISONLINE));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }

    @Override
    public boolean updateSetPlayerOffline() {
        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_SET_PLAYERS_OFFLINE);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }

        return result;
    }

    @Override
    public boolean updateSetPlayerStatusZero() {
        boolean result = true;
        try {
            PreparedStatement ps = con.getConnection().prepareStatement(SQLQueriesConstants.UPDATE_SET_PLAYERS_STATE_ZERO);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }

        return result;
    }
    private void updateAvailableOnlinePlayers(){
        new Thread(()->{
            GameHandler.onAvailablePlayersChangee(getAvilableOnlinePlayersWithScores());
        }).start();
    }
   

}
