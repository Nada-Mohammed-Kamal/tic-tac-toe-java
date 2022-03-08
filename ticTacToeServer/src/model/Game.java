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

    
    private PlayerDto player1;
    private PlayerDto player2;
    ArrayList<String> Steps = new ArrayList<String>();

    public Game(PlayerDto player1, PlayerDto player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public PlayerDto getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerDto player1) {
        this.player1 = player1;
    }

    public PlayerDto getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerDto player2) {
        this.player2 = player2;
    }

    public ArrayList<String> getSteps() {
        return Steps;
    }

    public void setSteps(ArrayList<String> Steps) {
        this.Steps = Steps;
    }

    
    public void setStep(String step) {
        Steps.add(step);
        System.out.println("    " + step);
    }

    public int getStepLength() {
        return Steps.lastIndexOf(Steps);
    }

    public int someoneWin(int[][] p1, int[][] p2) {
        //  0   0   1
        //  0   1   0
        //  1   0   0   
        //0+0+0+0+0+1
        int result = 0;
        if (((p1[0][0] * p1[0][1] * p1[0][2]) + (p1[1][0] * p1[1][1] * p1[1][2]) + (p1[2][0] * p1[2][1] * p1[2][2]) + (p1[0][0] * p1[1][1] * p1[2][2]) + (p1[0][2] * p1[1][1] * p1[2][0])
                + (p1[0][0] * p1[1][0] * p1[2][0]) + (p1[0][1] * p1[1][1] * p1[2][1]) + (p1[0][2] * p1[1][2] * p1[2][2])) > 0) {
            result = 1;
        }
        if (((p2[0][0] * p2[0][1] * p2[0][2]) + (p2[1][0] * p2[1][1] * p2[1][2]) + (p2[2][0] * p2[2][1] * p2[2][2]) + (p2[0][0] * p2[1][1] * p2[2][2]) + (p2[0][2] * p2[1][1] * p2[2][0])
                + (p2[0][0] * p2[1][0] * p2[2][0]) + (p2[0][1] * p2[1][1] * p2[2][1]) + (p2[0][2] * p2[1][2] * p2[2][2])) > 0) {
            result = 2;
        }
        System.out.println("" + Steps.size());
        if (Steps.size() == 5 && result == 0) {
            result = 3;
        }
        return result;
    }

}