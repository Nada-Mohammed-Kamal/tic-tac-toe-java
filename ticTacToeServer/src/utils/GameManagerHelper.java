/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author AhmedAli
 */
public class GameManagerHelper {
    
    static List<List> allWinningLists = new ArrayList<>();
    
    static {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftcol = Arrays.asList(1,4,7);
        List midcol = Arrays.asList(2,5,8);
        List rightcol = Arrays.asList(3,6,9);
        List diagonalOne = Arrays.asList(1,5,9);
        List diagonalTwo = Arrays.asList(3,5,7);
        
        /*
        1   2   3
        4   5   6
        7   8   9
        */
        
        allWinningLists.add(topRow);
        allWinningLists.add(midRow);
        allWinningLists.add(bottomRow);
        allWinningLists.add(leftcol);
        allWinningLists.add(midcol);
        allWinningLists.add(rightcol);
        allWinningLists.add(diagonalOne);
        allWinningLists.add(diagonalTwo);
    }
    
    public String detectWin(ArrayList<Integer> playerXSteps, ArrayList<Integer> playerOSteps){
        if(playerXSteps.size()+ playerOSteps.size() >= 5) {
            for(List l : allWinningLists) {
                if (playerXSteps.containsAll(l)) {
                    return "playerX";
                } else if(playerOSteps.containsAll(l)) {
                    return  "playerO";
                } else if(playerXSteps.size() + playerOSteps.size() == 9) {
                    return "tie";
                }
            }
        }
        return "";
    }
}
