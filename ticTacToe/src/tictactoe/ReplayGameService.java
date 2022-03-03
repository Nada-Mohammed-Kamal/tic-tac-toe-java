/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nados
 */
public class ReplayGameService {
    public String readedTextFromFile;
    public String PlayernamesFromDataReturned;
    public String getSubStringForNames = "";
    public String nameOfPlayerOneRecorder = "";
    public String nameOfPlayerTwoRecorder = "";
    ArrayList<Integer> playersRecorderMoves;
    String fileName;
    
    public ReplayGameService(String fileName){
        playersRecorderMoves =new ArrayList<>();
        this.fileName = fileName;
    }
    
    public void viewFileData()
    {
        try {
                   System.out.println(getFilePathFromName(fileName) + "    *****FileReader");
                    
                    BufferedReader writer = new BufferedReader(new FileReader(getFilePathFromName(fileName)));
                    readedTextFromFile = writer.readLine();
                    System.out.println(readedTextFromFile);
                    writer.close();
                    convertStringFromFileToArrayListOfIntsAndPlayerNames(readedTextFromFile);
                    seperateTheTwoPlayersNames(getSubStringForNames);
                    replayTheMoves(nameOfPlayerOneRecorder , nameOfPlayerTwoRecorder , playersRecorderMoves );
                    convertStringFromFileToPlayerNames(readedTextFromFile);
                } catch (Exception ex) {
                    Logger.getLogger(GameLocalMultiPlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("");
    }
    
    void convertStringFromFileToArrayListOfIntsAndPlayerNames(String strDatawithRecordedGameInfo){
        //al i de batba3 beha bs
        int i = 0;
        int res = strDatawithRecordedGameInfo.indexOf(",&");
        System.out.println(res);
        getSubStringForNames = strDatawithRecordedGameInfo.substring(res + 2);
        System.out.println(getSubStringForNames);
        String sub = "";
        sub = strDatawithRecordedGameInfo.substring(0,res);
        System.out.println(sub);
        StringTokenizer st = new StringTokenizer(sub,",");  
        while (st.hasMoreTokens()) 
        {  
              playersRecorderMoves.add(Integer.parseInt(st.nextToken()));
              System.out.println(playersRecorderMoves.get(i));
              i++;
        }
        //keda ma3aya al moves f playersRecorderMoves
        //wal2asamy f getsubStringForNames Bs MshMt2asam
    }
    
    void seperateTheTwoPlayersNames(String concatenatedNames)
    {
        
        int res = concatenatedNames.indexOf("&");
        nameOfPlayerOneRecorder = concatenatedNames.substring(0,res);
        nameOfPlayerTwoRecorder = concatenatedNames.substring(res+1);
        System.out.println(nameOfPlayerOneRecorder);
        System.out.println(nameOfPlayerTwoRecorder);
    }
    
    
    void replayTheMoves(String player1 , String player2 , ArrayList<Integer> PlayersMoves){
        String symbol1 = "X";
        String symbol2 = "O";
        int currentPlayerNumber = 1;
        Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run(){
            int currentPlayerNumber = 1;
                for(int i = 0 ; i < PlayersMoves.size() ; i++)
                {
                  try {
                    //thread1.wait(500);
                    if(currentPlayerNumber == 1)
                    {
                        System.out.println("name of player" + player1 + " index(button number) " + PlayersMoves.get(i) + " : " + symbol1);
                        currentPlayerNumber = 2;
                    }else{
                        System.out.println("name of player" + player2 + " index(button number) " + PlayersMoves.get(i) + " : " + symbol2);
                        currentPlayerNumber = 1;
                    }
                    }catch (Exception ex) {
                        Logger.getLogger(ReplayGameService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread1.start();
    }
    
        void convertStringFromFileToPlayerNames(String strDatawithRecordedGameInfo){
        int i = 0;
        StringTokenizer st = new StringTokenizer(strDatawithRecordedGameInfo,"&");  
        while (st.hasMoreTokens()) 
        {  
              PlayernamesFromDataReturned += (st.nextToken());
              System.out.println(playersRecorderMoves.get(i));
              i++;
        }
    }
        
  String getFilePathFromName(String filsName)
    {
        File f = new File(System.getProperty("user.dir"));
       String path = new String();
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            try {
               if(file.getName().equals(filsName))
                {
                    path = file.getCanonicalPath().toString();
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(RecordedScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return path;
    }      
    
}
