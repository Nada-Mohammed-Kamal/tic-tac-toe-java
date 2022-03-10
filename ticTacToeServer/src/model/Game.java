/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import utils.GameManagerHelper;

/**
 *
 * @author abdelwahabzayed
 */
public class Game{

    
    private PlayerDto playerX;
    private PlayerDto playerO;
    private ArrayList<Integer> playerXSteps = new ArrayList<Integer>();
    private ArrayList<Integer> playerOSteps = new ArrayList<Integer>();
    private int state = 0;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
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

    public int addPlayerXStep(int move) {
        playerXSteps.add(move);
        return GameManagerHelper.detectWin(playerXSteps, playerOSteps);  
    }
    
    public int addPlayerOStep(int move) {
        playerOSteps.add(move);
        return GameManagerHelper.detectWin(playerXSteps, playerOSteps);  
    }
    
    ArrayList<Integer> getPlayerXSteps() {
        return playerXSteps;
    }
    
    ArrayList<Integer> getPlayerOSteps() {
        return playerOSteps;
    }
    //TO play again
   public void clearPlayersSteps(){
       playerXSteps.clear();
       playerOSteps.clear();
   }
}