/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

/**
 *
 * @author abdelwahabzayed
 */
public interface NetworkLayer {
    void printStream(String msg);
    void closeConnection();
    void setNetworkUser(NetworkUser networkUser);
    void setScore(int score);
    int getScore();
    void setUsername(String username);
    String getUsername();
}
