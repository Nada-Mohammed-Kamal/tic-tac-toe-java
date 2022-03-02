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
    public static final String IS_ALREADY_REGISTERED_QUERY = "SELECT * FROM PLAYERS WHERE USERNAME = ?";
    public static final String SELECT_ONLINE_PLAYERS = "SELECT * FROM PLAYERS WHERE ISONLINE = true";
    public static final String SELECT_ALL_PLAYERS = "SELECT * FROM PLAYERS";
    public static final String UPDATE_PLAYER_STATE = "UPDATE PLAYERS SET ISONLINE = ? WHERE USERNAME = ?";
    public static final String UPDATE_PLAYER_SCORE = "UPDATE PLAYERS SET SCORE = ? WHERE USERNAME = ?";
    public static final String ADD_NEW_PLAYER = "INSERT INTO PLAYERS (USERNAME, PASSWORD, SCORE, ISONLINE) VALUES (?, ?, ?, ?)";
}
