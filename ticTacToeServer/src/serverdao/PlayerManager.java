/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import java.util.List;
import tictactoeserver.OnPlayerCountChangeListener;

/**
 *
 * @author AhmedAli
 */
public interface PlayerManager {
    int addNewPlayer(String username, String password, int score, boolean isOnline);
    boolean updatePlayerScore(String username, int score);
    boolean updateIsPlayerOnline(String username, boolean isOnline);
    boolean updatePlayerStatus(String username, int state);
    int getAllPlayersCount();
    int getOnlinePlayersCount();
    List<String> getOnlinePlayers();
    int login(String userName, String password, Integer scoreRefrence);
    boolean isAlreadyRegistered(String username);
    void releaseResources();
    void setOnPlayerCountChangeListener(OnPlayerCountChangeListener onPlayerCountChangeListener);
    void updateServerStatistics();
}
