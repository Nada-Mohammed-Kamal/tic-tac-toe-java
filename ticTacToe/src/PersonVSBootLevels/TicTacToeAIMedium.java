/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonVSBootLevels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author AhmedAli
 */
public class TicTacToeAIMedium {

    List<List> allWinningLists;
    List<List> allMayWinLists;
    List topRow1;
    List topRow2; 
    List midRow1; 
    List midRow2 ;
    List bottomRow1;
    List bottomRow2;
    List leftcol1;
    List midcol1 ;
    List rightco1;
    List diagonalOne1;
    List diagonalOne2;
    List diagonalTwo1;
    List diagonalTwo2;
    List topRow;
    List midRow;
    List bottomRow;
    List leftcol;
    List midcol;
    List rightcol;
    List diagonalOne;
    List diagonalTwo;
    List rightco2;
    TicTacToeAIMedium() {
        allWinningLists = new ArrayList<>();
        allMayWinLists = new ArrayList<>();

        topRow1 = Arrays.asList(1, 2);
        topRow2 = Arrays.asList(1, 3);
        midRow1 = Arrays.asList(4, 6);
        midRow2 = Arrays.asList(4, 5);
        bottomRow1 = Arrays.asList(8, 9);
        bottomRow2 = Arrays.asList(7,8);
        leftcol1 = Arrays.asList(1, 7);
        midcol1 = Arrays.asList(5, 8);
        rightco1 = Arrays.asList(3,9);
        rightco2 = Arrays.asList(3,6);
        diagonalOne1 = Arrays.asList( 5, 9);
        diagonalTwo1 = Arrays.asList(3, 5);
        diagonalOne2 = Arrays.asList( 1, 5);
        diagonalTwo2 = Arrays.asList(5, 7);
        
        allMayWinLists.add(topRow1);
        allMayWinLists.add(topRow2);
        allMayWinLists.add(midRow1);
        allMayWinLists.add(midRow2);
        allMayWinLists.add(bottomRow1);
        allMayWinLists.add(bottomRow2);
        allMayWinLists.add(leftcol1);
        allMayWinLists.add(midcol1);
        allMayWinLists.add(rightco1);
        allMayWinLists.add(rightco2);
        allMayWinLists.add(diagonalOne1);
        allMayWinLists.add(diagonalOne2);
        allMayWinLists.add(diagonalTwo1);
         allMayWinLists.add(diagonalTwo2);
        /*
        1   2   3
        4   5   6
        7   8   9
         */
        topRow = Arrays.asList(1, 2, 3);
        midRow = Arrays.asList(4, 5, 6);
        bottomRow = Arrays.asList(7, 8, 9);
        leftcol = Arrays.asList(1, 4, 7);
        midcol = Arrays.asList(2, 5, 8);
        rightcol = Arrays.asList(3, 6, 9);
        diagonalOne = Arrays.asList(1, 5, 9);
        diagonalTwo = Arrays.asList(3, 5, 7);
        
        allWinningLists.add(topRow);
        allWinningLists.add(midRow);
        allWinningLists.add(bottomRow);
        allWinningLists.add(leftcol);
        allWinningLists.add(midcol);
        allWinningLists.add(rightcol);
        allWinningLists.add(diagonalOne);
        allWinningLists.add(diagonalTwo);
    }
    public int detectNextPlay(ArrayList<Integer> playerXSteps, ArrayList<Integer> moves){
        int move = -1;
        for (List l : allMayWinLists) {
            if (playerXSteps.containsAll(l)) {
                if(l.equals(topRow1) && !moves.contains(3))// topRow1 = Arrays.asList(1, 2);
                {
                   
                    return 3;
                }
                else if(l.equals(topRow2) && !moves.contains(2))//topRow2 = Arrays.asList(1, 3);
                {
                   
                    return 2;
                }
                else if(l.equals(midRow1) && !moves.contains(5))//midRow1 = Arrays.asList(4, 6);
                {
                    return 5;
                }
                else if(l.equals(midRow2) && !moves.contains(6))//midRow2 = Arrays.asList(4, 5);
                {
                    return 6;
                }
                else if(l.equals(bottomRow1) && !moves.contains(7)){//bottomRow1 = Arrays.asList(8, 9);
                    return 7;
                }
                else if(l.equals(bottomRow2) && !moves.contains(9)){//bottomRow2 = Arrays.asList(7,8);
                    return 9;
                }
                else if(l.equals(leftcol1) && !moves.contains(4)){//leftcol1 = Arrays.asList(1, 7);
                    return 4;
                }
                else if(l.equals(midcol1) && !moves.contains(2)){//midcol1 = Arrays.asList(5, 8);
                    return 2;
                }
                else if(l.equals(rightco2) && !moves.contains(9)){ // rightco2 = Arrays.asList(3,6);
                    return 9;
                }
                else if(l.equals(rightco1) && !moves.contains(6)){//rightco1 = Arrays.asList(3,9);
                    return 6;
                }
                else if(l.equals(diagonalOne1) && !moves.contains(1)){//diagonalOne1 = Arrays.asList( 5, 9);
                    return 1;
                }
                else if(l.equals(diagonalTwo1) && !moves.contains(7)){//diagonalTwo1 = Arrays.asList(3, 5);
                    return 7;
                }
                else if(l.equals(diagonalOne2) && !moves.contains(9)){//diagonalOne2 = Arrays.asList( 1, 5);
                    return 9;
                }
                else if(l.equals(diagonalTwo2) && !moves.contains(3)){ // diagonalTwo2 = Arrays.asList(5, 7);
                    return 3;
                }
                
                
            } 
        }
        return move;
    }
    public int detectWin(ArrayList<Integer> playerXSteps, ArrayList<Integer> playerOSteps) {
        if (playerXSteps.size() + playerOSteps.size() >= 5) {
            for (List l : allWinningLists) {
                if (playerXSteps.containsAll(l)) {
                    return GameResult.X_WIN;
                } else if (playerOSteps.containsAll(l)) {
                    return GameResult.O_WIN;
                }
            }
            if (playerXSteps.size() + playerOSteps.size() == 9) {
                return GameResult.TIE;
            }
        }
        
        return GameResult.CONTINUE_PLAYING;
    }
}
