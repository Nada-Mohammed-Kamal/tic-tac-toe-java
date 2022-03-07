/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author AhmedAli
 */
public class SQLQueriesConstants {
    public static final String LOGIN_QUERY = "SELECT * FROM PLAYERS WHERE USERNAME = ? AND PASSWORD = ?";
    public static final String SELECT_ALL_COL_FOR_USERNAME = "SELECT * FROM PLAYERS WHERE USERNAME = ?";
    public static final String SELECT_ONLINE_PLAYERS = "SELECT * FROM PLAYERS WHERE ISONLINE = true";
    public static final String SELECT_ALL_PLAYERS = "SELECT * FROM PLAYERS";
    public static final String UPDATE_PLAYER_STATE = "UPDATE PLAYERS SET ISONLINE = ? WHERE USERNAME = ?";
    public static final String UPDATE_PLAYER_SCORE = "UPDATE PLAYERS SET SCORE = ? WHERE USERNAME = ?";
    public static final String UPDATE_PLAYER_STATUS = "UPDATE PLAYERS SET STATUS = ? WHERE USERNAME = ?";
    public static final String UPDATE_SET_PLAYERS_OFFLINE = "UPDATE PLAYERS SET ISONLINE = false";
    public static final String UPDATE_SET_PLAYERS_STATE_ZERO = "UPDATE PLAYERS SET STATUS = 0";
    public static final String ADD_NEW_PLAYER = "INSERT INTO PLAYERS (USERNAME, PASSWORD, SCORE, ISONLINE) VALUES (?, ?, ?, ?)";
}
