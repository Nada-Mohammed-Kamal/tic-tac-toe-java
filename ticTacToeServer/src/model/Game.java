/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author abdelwahabzayed
 */
public class Game{

    
    private PlayerDto playerX;
    private PlayerDto playerO;
    ArrayList<String> playerXSteps = new ArrayList<String>();
    ArrayList<String> playerOSteps = new ArrayList<String>();

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Game && (((Game) obj).playerX.equals(playerX) || ((Game) obj).playerX.equals(playerO) || ((Game) obj).playerO.equals(playerX) || ((Game) obj).playerO.equals(playerO));
    }
    
    public Game(PlayerDto player1, PlayerDto player2) {
        this.playerX = player1;
        this.playerO = player2;
    }

    public PlayerDto getPlayerX() {
        return playerX;
    }

    public void setPlayerX(PlayerDto playerX) {
        this.playerX = playerX;
    }

    public PlayerDto getPlayerO() {
        return playerO;
    }

    public void setPlayerO(PlayerDto playerO) {
        this.playerO = playerO;
    }

//    int addPlayerXStep(String move) {
//        playerXSteps.add(move);
//        
//    }
//    
//    int addPlayerOStep(String move) {
//        playerOSteps.add(move);
//    }
    
    ArrayList<String> getPlayerXSteps() {
        return playerXSteps;
    }
    
    ArrayList<String> getPlayerOSteps() {
        return playerOSteps;
    }
}