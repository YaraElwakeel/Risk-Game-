/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import Agents.Agent;
import java.util.ArrayList;

/**
 *
 * @author yarae
 */
public class Player {
    ArrayList<Territory> owned_Territories=null;
    public int no_of_armies;
    Agent g;
    int player_id;
    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }
    public Player( Agent g) {
        this.g=g;
        this.owned_Territories=new ArrayList<>();
        this.no_of_armies=20;
    }

    public Agent getG() {
        return g;
    }

    public void play(){
    	
        g.addarmies();
    }
    public ArrayList<Territory> getOwned_Territories() {
        return owned_Territories;
    }
   
    public void setOwned_Territories(Territory ownedt) {
        ownedt.setAvailable(false);
        
        
        this.owned_Territories.add(ownedt);
    }

    public int getNo_of_armies() {
        return no_of_armies;
    }

    public void setNo_of_armies(int no_of_armies) {
        this.no_of_armies = no_of_armies;
    }
    public int getbonusarmies(){
        int bonusArmies = owned_Territories.size()/3;//count # of territories/3
		if (bonusArmies<3){
			bonusArmies=3;
                        no_of_armies=bonusArmies;
                }	
        return no_of_armies;
    }
    
    public void SetRemovedTerritory(ArrayList<Territory> tr)
    {
    	this.owned_Territories= tr;
    	
    	
    }
}
