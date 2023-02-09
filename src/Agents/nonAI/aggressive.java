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
public class aggressive implements Agent{
	
	Game g ;
	ArrayList <Territory> tsall = new ArrayList<>();
	Player P ,P2;
	
	public aggressive(Game g) {
		this.g=g;
		this.tsall=g.getM().getTerritories();
	}
	
     public void setPlayer(Player p){
        this.P=p;
    
     }

     public void DeterminePlayer() {
     if (!(g.getB().getG() instanceof aggressive)) {
    	  this.P2 = g.getB();
     }
     else {
    	  this.P2 = g.getA();
     }
    	 
     }
 /*
 @Override
	public void attack() {
	DeterminePlayer();
	int index=0;
	 if (canAttack()) {
		 
		 System.out.println("\nAggressive");
         for (Territory t2 : P.getOwned_Territories()) {
          System.out.print(t2.getNo_of_armies() + " ");
         }
		 
		 if (P2.getOwned_Territories().size()!=0) {
		
		Territory t=null;
		Territory temp=null;
		Territory maxTerritory =null;
		t=getMaxTerritory(P); ///////  //get terr with min # of armies in player P2
		int PlayerArmies=t.getNo_of_armies();
	
		List<Territory> Player2territories = P2.getOwned_Territories();
		List<Territory> AggressiveTerritories = P.getOwned_Territories();
		boolean noElementsInCommon = Collections.disjoint(Player2territories, AggressiveTerritories); // true
		if (noElementsInCommon) 	//not one of territories 
		{
			int numberofarmies = 0;
			 maxTerritory = t.Get_adj_Territory().get(0);
			for (int j=1; j< t.Get_adj_Territory().size(); j++)
			{
				
		   		int maxTerritoryArmies = maxTerritory.getNo_of_armies();
		   		
		   			numberofarmies =  t.Get_adj_Territory().get(j).getNo_of_armies();
		   		if( numberofarmies > maxTerritoryArmies ){
		   			
		   				maxTerritory =  t.Get_adj_Territory().get(j);
		   	        }
		   		
			}
		}
		maxTerritory.setNo_of_armies(t.getNo_of_armies()-1);

		t.setNo_of_armies(1);
		Player2territories.remove(maxTerritory);
		AggressiveTerritories.add(maxTerritory);
				}		
	   }
	}
 
  
 */
     
     

     @Override
    	public void attack() {
    	DeterminePlayer();
    	
    	 if (canAttack()) {
    		 
    		 System.out.println("\nAggressive");
             for (Territory t2 : P.getOwned_Territories()) {
              System.out.print(t2.getNo_of_armies() + " ");
             }
    		 
    		 if (P2.getOwned_Territories().size()!=0) {
    		
    		Territory t=null;
    		Territory temp=null;
    		Territory maxTerritory =null;
    		t=getMaxTerritory(P); ///////  //get terr with min # of armies in player P2
    		int PlayerArmies=t.getNo_of_armies();
    	
    		List<Territory> Player2territories = P2.getOwned_Territories();
    		List<Territory> AggressiveTerritories = P.getOwned_Territories();
    		boolean noElementsInCommon = Collections.disjoint(Player2territories, AggressiveTerritories); // true
    		if (noElementsInCommon) 	//not one of territories 
    		{	
    			int numberofarmies = 0;
    			
    			for (int j=0; j< t.Get_adj_Territory().size(); j++)
    			{
    				if ( P2.getOwned_Territories().contains(t.Get_adj_Territory().get(j))  ) 
    				{
    					temp=t.Get_adj_Territory().get(j);
    					if (t.getNo_of_armies() > temp.getNo_of_armies())
    					{
    					
    						t.Get_adj_Territory().get(j).setNo_of_armies(t.getNo_of_armies()-1);
        		    		t.setNo_of_armies(1);
        		    		P2.getOwned_Territories().remove(t.Get_adj_Territory().get(j));
        		    		P.getOwned_Territories().add(t.Get_adj_Territory().get(j));
        		    		break;	
    					}
    					if ( P.getOwned_Territories().contains(t.Get_adj_Territory().get(j)) ) 
    					{
    						break;
    					}
     			    }
    			}
         	  }		
    	   }
    	}
       
     }

    @Override
    public boolean canAttack() {
    return true;
    }

    @Override
   	public Territory getMinTerritory(Player P) {
   		int numberofarmies = 0;
   		Territory minTerritory = P.getOwned_Territories().get(0);
   		int minTerritoryArmies = P.getOwned_Territories().get(0).getNo_of_armies();
   		for (int i=1; i< P.getOwned_Territories().size() ; i++)
   		{
   			numberofarmies = P.getOwned_Territories().get(i).getNo_of_armies();
   			
   			if( numberofarmies < minTerritoryArmies ){
   				minTerritoryArmies = numberofarmies;
   				minTerritory =  P.getOwned_Territories().get(i);
   	        }
   		}
   		return minTerritory;
   	}
    
    @Override
   	public Territory getMaxTerritory(Player P) {
    	
    	Territory maxTerritory=null;
		if (P.getOwned_Territories().size()!=0) {
   		int numberofarmies = 0;
   		 maxTerritory = P.getOwned_Territories().get(0);
   		int maxTerritoryArmies = P.getOwned_Territories().get(0).getNo_of_armies();
   		for (int i=1; i< P.getOwned_Territories().size() ; i++)
   		{
   			numberofarmies = P.getOwned_Territories().get(i).getNo_of_armies();
   		if( numberofarmies > maxTerritoryArmies ){
   				maxTerritoryArmies = numberofarmies;
   				maxTerritory =  P.getOwned_Territories().get(i);
   	        }
   		}
		}
   		return maxTerritory;
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
   		System.out.println("Bonusarmies="+bonusArmies);
      //  P.setNo_of_armies(bonusArmies);
         Territory maxTerritory=getMaxTerritory(P);
         maxTerritory.setNo_of_armies(maxTerritory.getNo_of_armies()+bonusArmies);
   	attack();	
   		}
    }
	
	@Override
	public void addarmiesh(ArrayList<Territory> clicked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(ArrayList<Territory> clicked) {
		// TODO Auto-generated method stub
		
	}
   
}
