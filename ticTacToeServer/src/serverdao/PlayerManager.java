/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import java.util.Vector;

/**
 *
 * @author AhmedAli
 */
public interface PlayerManager {
    int addNewPlayer(String username, String password, int score, boolean isOnline);
    boolean updatePlayerScore(String username, int score);
    boolean updatePlayerState(String username, boolean isOnline);
    Vector<PLayerDAO> selectAllPlayers();
    Vector<PLayerDAO> selectOnlinePlayers();
    int login(String userName, String password);
    boolean isAlreadyRegistered(String username);
    void releaseResources();
}
