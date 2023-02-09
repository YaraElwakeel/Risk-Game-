/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yarae
 */
public class Turn_manager {
    int n;
    Game game;
    boolean gameend=false;
    Player A;
    Player B;
    Player playingPlayer;
    public Turn_manager(Player A,Player B,boolean playing) {
        this.playingPlayer=A;
         System.out.println(playing);
         doturn();
    }

    public boolean isGameend() {
        return gameend;
    }

    public void setGameend(boolean gameend) {
        this.gameend = gameend;
    }
    public Game game(){
        return game;
    }
    public void doturn(){
        System.out.println(playingPlayer.owned_Territories.size()); 
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Turn_manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
