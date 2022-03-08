/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdao;

import java.util.List;
import model.PlayerDto;

/**
 *
 * @author AhmedAli
 */
public interface PlayerManager extends PlayerCountChangeUpdater {

    int addNewPlayer(String username, String password, int score, boolean isOnline);

    boolean updatePlayerScore(String username, int score);

    boolean updateIsPlayerOnline(String username, boolean isOnline);

    boolean updatePlayerStatusOnDB(String username, int state, int oldState);

    int getAllPlayersCount();

    int getOnlinePlayersCount();

    List<String> getOnlinePlayers();

    int login(String userName, String password, Integer scoreRefrence);

    boolean isAlreadyRegistered(String username);

    void releaseResources();

    void updateServerStatistics();

    PlayerDto getPlayer(String username);

    boolean logOut(String username, int oldState);

    public List<PlayerDto> getAvilableOnlinePlayersWithScores();

    boolean updateSetPlayerOffline();

    boolean updateSetPlayerStatusZero();
}
