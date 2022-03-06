/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.util.List;

/**
 *
 * @author Esraa
 */
public interface OnPlayerCountChangeListener {
    void onPlayerCountChange(List<String> onlinePlayers, int allUsersCount);
}
