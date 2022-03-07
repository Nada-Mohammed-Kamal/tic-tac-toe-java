/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import tictactoeserver.GameHandler;
import utils.PlayerStatusValues;

/**
 *
 * @author AhmedAli
 */
public class PlayerDto  {
    
    private String username;
    private String password;
    private int score;
    private int status = PlayerStatusValues.IDLE;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private boolean isOnline;
    private GameHandler handler;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PlayerDto)
            return username.equals(((PlayerDto)obj).username);
        else
            return false;
    }

    public PlayerDto(String username, String password, int score, boolean isOnline) {
        this.username = username;
        this.password = password;
        this.score = score;
        this.isOnline = isOnline;
    }
    public PlayerDto(String username, String password, int score, int status, boolean isOnline) {
        this.username = username;
        this.password = password;
        this.score = score;
        this.status = status;
        this.isOnline = isOnline;
    }
    public PlayerDto(String username, String password, int score, boolean isOnline, GameHandler handler) {
        this.username = username;
        this.password = password;
        this.score = score;
        this.isOnline = isOnline;
        this.handler = handler;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public GameHandler getHandler() {
        return handler;
    }

    public void setHandler(GameHandler handler) {
        this.handler = handler;
    }

    
    
}
