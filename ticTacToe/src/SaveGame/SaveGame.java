/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveGame;

import DisplayAlert.PlayersNames;
import GameLocalMultiPlayersScreenWithAlert.GameLocalMultiPlayersScreenBase;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esraa
 */
public class SaveGame {
    private static String movesAsAString; 
    public static void saveFile(PlayersNames playersNames,Vector<Integer> vc)
    {
        try { 
               Date date = new Date();
               Format formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
               String s = formatter.format(date);
               BufferedWriter writer = new BufferedWriter(new FileWriter( playersNames.getPlayer1()+"VS" + playersNames.getPlayer2() + s+".txt"));

               System.out.println(vc);
               movesAsAString = convertVectorOfIntToString(vc);
                   System.out.println(movesAsAString);
               concatenateNameInStringToSaveInFile(playersNames.getPlayer1() , playersNames.getPlayer2());
               writer.write(movesAsAString);
               writer.close();
               System.out.println("saved successfully");
               } catch (Exception ex) {
                   Logger.getLogger(GameLocalMultiPlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
               }
               System.out.println("");
    }
    private static String convertVectorOfIntToString(Vector<Integer> vector){
        String str = "";
        for(int i = 0 ; i < vector.size() ; i++)
        {
            str += vector.get(i);
            str += ",";
        }
        return str;
    }
    private static void concatenateNameInStringToSaveInFile(String name1 , String name2){
        movesAsAString += "&";
        movesAsAString += name1;
        movesAsAString += "&";
        movesAsAString += name2;
    }    
}
