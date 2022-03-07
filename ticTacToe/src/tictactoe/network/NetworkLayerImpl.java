/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import utils.ErrorConstants;
import utils.ServerQueries;

/**
 *
 * @author abdelwahabzayed
 */
public class NetworkLayerImpl extends Thread implements NetworkLayer {

    private static NetworkUser networkUser;
    private static Socket mySocket;
    private static InputStreamReader dis;
    private static PrintStream ps;
    private static BufferedReader bufferReader;
    private static NetworkLayer networkLayer;
    private static int score = 0;
    private static String username = "";
    private boolean flag = true;
    
    private NetworkLayerImpl(NetworkUser networkUser) {
        NetworkLayerImpl.networkUser = networkUser;
        try {
            initConnection();
            listenToServer();

        } catch (IOException ex) {
            networkUser.onErrorReceived(ErrorConstants.COULD_NOT_CONNECT_TO_SERVER);
        }
    }

    private void initConnection() throws IOException {
        mySocket = new Socket("127.0.0.1", 5555);
        dis = new InputStreamReader(mySocket.getInputStream());
        ps = new PrintStream(mySocket.getOutputStream());
        bufferReader = new BufferedReader(dis);
        System.out.println("initConnection");
    }

    @Override
    public void printStream(String msg) {
        System.out.println("printStream(String msg)" + msg);
        ps.println(msg);
    }

    @Override
    public void closeConnection(String msg) {
        
            networkUser.exitNetwork(msg);
        
        networkUser = null;
        networkLayer = null;
        score = 0;
        username = null;
        try {
            ps.close();
            bufferReader.close();
            dis.close();
            mySocket.close();
        } catch (IOException ex) {
            networkUser.onErrorReceived(ErrorConstants.PROBLEM_WHILE_CLOSING_CONNECTION);
            Logger.getLogger(NetworkLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listenToServer() {
        this.start();
    }

    @Override
    public void run() {
        while (flag) {
            try {
                String msg = bufferReader.readLine();
                System.out.println("msg == " + msg);
                if (msg != null && !msg.isEmpty()) {
                    if(msg.equals(ServerQueries.CLOSE_NORMALLY)){
                        closeConnection(ServerQueries.CLOSE_NORMALLY);
                        flag = false;
                        return;
                    }                    
                        Platform.runLater(()->{
                        networkUser.onMsgReceived(msg);
                    });
                }
            } catch (IOException ex) {
                networkUser.onErrorReceived(ErrorConstants.COULD_NOT_RECEIVE_MSG_FROM_SERVER);
                flag = false;
                closeConnection(ErrorConstants.CLOSED_ABBNORMALLY);
                return;
            }
        }
    }

    @Override
    public synchronized void setNetworkUser(NetworkUser networkUser) {
        NetworkLayerImpl.networkUser = networkUser;
    }

    public static synchronized NetworkLayer getInstance(NetworkUser networkUser) {
        if (networkLayer == null) {
            networkLayer = new NetworkLayerImpl(networkUser);
        } else {
            NetworkLayerImpl.networkUser = networkUser;
        }
        return networkLayer;
    }

    @Override
    public void setScore(int score) {
        NetworkLayerImpl.score = score;
    }

    @Override
    public int getScore() {
        return NetworkLayerImpl.score;
    }

    @Override
    public void setUsername(String username) {
        NetworkLayerImpl.username = username;
    }

    @Override
    public String getUsername() {
        return NetworkLayerImpl.username;
    }
    
    
}
