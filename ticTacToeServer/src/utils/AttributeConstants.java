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
public class AttributeConstants {
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String SCORE = "SCORE";
    public static final String ISONLINE = "ISONLINE";
    public static final String ADD_NEW_PLAYER = "INSERT INTO PLAYERS (USERNAME, PASSWORD, SCORE, ISONLINE) VALUES (?, ?, ?, ?)";
}
