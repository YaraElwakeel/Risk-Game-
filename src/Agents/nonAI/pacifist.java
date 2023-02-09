/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents.nonAI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Agents.Agent;
import risk_game.Game;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class pacifist implements Agent{
	
	Game g ;
	ArrayList <Territory> tsall = new ArrayList<>();
	Player P ,P2;
	
	public pacifist(Game g) {
		this.g=g;
		this.tsall=g.getM().getTerritories();
	}
	
     public void setPlayer(Player p){
        this.P=p;
    
     }

     public void DeterminePlayer() {
     if (!(g.getB().getG() instanceof pacifist)) {
    	  this.P2 = g.getB();
     }
     else {
    	  this.P2 = g.getA();
     }
    	 
     }
     
 
 	public void attack() {//conquer one land only with the fewest territories
 		if (canAttack()) {
 			
 	         
 		DeterminePlayer();
 		
 		if (P.getOwned_Territories().size()!=0 && P2.getOwned_Territories().size()!=0) {
     
         int index=0;
         
 		Territory t= getMinTerritory(P2); //get terr with min # of armies in player B
 		int PlayerArmies=t.getNo_of_armies();
 		List<Territory> Player2territories = P2.getOwned_Territories();
 		List<Territory> PacifistTerritories = P.getOwned_Territories();//.get(1).Get_adj_Territory();
 		boolean noElementsInCommon = Collections.disjoint(Player2territories, PacifistTerritories); // true
 		if (noElementsInCommon) 	//not one of territories 
 		{
 		 
 		for (int i=0 ; i< PacifistTerritories.size() ; i++)
 		{			
 			if (PacifistTerritories.get(i).Get_adj_Territory().contains(t) )//if minTerritory in P2 is adjacent to my territories
 			{
 			if (PacifistTerritories.get(i).getNo_of_armies() > PlayerArmies ) 
 			{
 				 index =i;
 					
 				t.setNo_of_armies(PacifistTerritories.get(index).getNo_of_armies()-1);

 		 		PacifistTerritories.get(index).setNo_of_armies(1);
 				Player2territories.remove(t);
 				PacifistTerritories.add(t);
 				 
 			 }
 		   }
 		 }		
 		}
 	
 	   }
 		
   	}
 	
  }
    
     
     
     @Override
     public void addarmies() {
    	DeterminePlayer();
    		int numofTerritories= 0;
    		numofTerritories=P.getOwned_Territories().size();
    		if (P2.getOwned_Territories().size()!=0 ) {
    		int bonusArmies = numofTerritories/3;//count # of territories/3
    		if (bonusArmies<3){
    			bonusArmies=3;
    		
          }	
    		System.out.println("Bonusssarmies="+bonusArmies);
         //P.setNo_of_armies(bonusArmies);
          Territory minTerritory=getMinTerritory(P);
          minTerritory.setNo_of_armies(minTerritory.getNo_of_armies()+bonusArmies);
    	attack();	
    		}
     }
     
     
     public boolean canAttack() {
    
    	 return true ;
    	
     }

  
    
	public Territory getMinTerritory(Player P) {
		Territory minTerritory=null;
		if (P.getOwned_Territories().size()!=0) {
		int numberofarmies = 0;
		minTerritory= P.getOwned_Territories().get(0);
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
		else System.out.println("Game Ended!!");
		
		return minTerritory;
	}
	public Territory getMaxTerritory(Player P) {
		return null;
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