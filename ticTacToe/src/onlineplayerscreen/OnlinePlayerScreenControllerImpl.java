/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineplayerscreen;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.stage.Stage;
import model.PlayerDto;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.ServerQueries;

/**
 *
 * @author nados
 */
interface OnlinePlayerScreenController{
    
}

public class OnlinePlayerScreenControllerImpl implements OnlinePlayerScreenController , NetworkUser{
    OnlinePlayerScreenInterface onlinePlayerScreenInterface;
    Stage stage;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    

    
    public OnlinePlayerScreenControllerImpl(OnlinePlayerScreenInterface onlinePlayerScreenInterface , Stage stage){
         this.onlinePlayerScreenInterface = onlinePlayerScreenInterface;
         this.stage = stage;
         networkLayer = NetworkLayerImpl.getInstance(this);
         networkLayer.printStream(ServerQueries.GET_ONLINE_USERS);
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        stringTokenizer = new StringTokenizer(receivedMsg, ";");
        String commandToExcute = stringTokenizer.nextToken();
        System.out.println(commandToExcute);
        switch (commandToExcute){
            case ServerQueries.ONLINE_USERS:
                showOnlineUsers();
                break;
                
        }
    }

    private void showOnlineUsers() {
        ArrayList<PlayerDto> players = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            String[] player = stringTokenizer.nextToken().split("~");
            players.add(new PlayerDto(player[0], "", Integer.parseInt(player[1]), true));
        }
        onlinePlayerScreenInterface.updateOnlinePlayersList(players);
    }
    
    
    
}
