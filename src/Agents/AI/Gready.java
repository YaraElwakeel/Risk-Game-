/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents.AI;

import Agents.Agent;
import Agents.nonAI.pacifist;
import java.util.ArrayList;
import risk_game.Game;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class Gready implements Agent{
Player P,P2;

Game game;
    public Gready(Game g) {
        this.game=game;
    }
            public void setPlayer(Player p){
          this.P=p;
        }
           
    public void addarmies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean canAttack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Territory getMinTerritory(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Territory getMaxTerritory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DeterminePlayer() {
         if (!(game.getB().getG() instanceof pacifist)) {
    	  this.P2 = game.getB();
     }
     else {
    	  this.P2 = game.getA();
     }    
    }

  
    @Override
    public void addarmiesh(ArrayList<Territory> clicked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack(ArrayList<Territory> clicked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
