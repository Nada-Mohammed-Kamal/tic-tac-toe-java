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
public interface NetworkUser {
    void onErrorReceived(String errorMsg);
    void onMsgReceived(String receivedMsg);
}
