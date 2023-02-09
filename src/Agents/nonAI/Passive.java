/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents.nonAI;

import java.util.ArrayList;
import Agents.Agent;
import risk_game.Game;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class Passive implements Agent{

	Game g ;//new Game();
	ArrayList <Territory> tsall = new ArrayList<>();
	Player P ;
	public Passive(Game g) {
		this.g=g;
		this.tsall=g.getM().getTerritories();          
	}
    
        public void setPlayer(Player p){
           this.P=p;  
          System.out.print(p.getOwned_Territories().size());
        }
        

	public boolean canAttack() {
		return false;
	}

	
	public Territory getMinTerritory(Player P) {
		int numberofarmies = 0;
		Territory minTerritory=null;
		if (P.getOwned_Territories().size()!=0) {
		 minTerritory = P.getOwned_Territories().get(0);
		int minTerritoryArmies = P.getOwned_Territories().get(0).getNo_of_armies();
		for (int i=1; i< P.getOwned_Territories().size() ; i++)
		{
			numberofarmies = P.getOwned_Territories().get(i).getNo_of_armies();
			
			if( numberofarmies < minTerritoryArmies ){
				minTerritoryArmies = numberofarmies;
				minTerritory =  P.getOwned_Territories().get(i);
	        }
		}
		}
		return minTerritory;
	}

    
	public void addarmies() {
	
		int numofTerritories= P.getOwned_Territories().size();
		int bonusArmies = numofTerritories/3;//count # of territories/3
		if (bonusArmies<3){
			bonusArmies=3;
                     //   P.setNo_of_armies(bonusArmies);
                }	
                Territory minTerritory=getMinTerritory(P);
                minTerritory.setNo_of_armies(minTerritory.getNo_of_armies()+bonusArmies);
		
	}


    public Territory getMaxTerritory(Player P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DeterminePlayer() {
        
    }

 


    @Override
    public void addarmiesh(ArrayList<Territory> clicked) {
    }

    @Override
    public void attack(ArrayList<Territory> clicked) {
    }


}