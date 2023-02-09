/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents.nonAI;

import Agents.Agent;
import java.util.ArrayList;
import risk_game.Game;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class HumanAgent implements Agent{
	Game g ;
	ArrayList <Territory> tsall = new ArrayList<>();
	Player P ,P2;
	
	public HumanAgent(Game g) {
		this.g=g;
		this.tsall=g.getM().getTerritories();
	}
	
     public void setPlayer(Player p){
        this.P=p;
    
     }

     public void DeterminePlayer() {
     if (!(g.getB().getG() instanceof HumanAgent)) {
    	  this.P2 = g.getB();
     }
     else {
    	  this.P2 = g.getA();
     }
    	 
     }


    @Override
    public void addarmies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean canAttack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Territory getMinTerritory(Player P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public void addarmiesh(ArrayList<Territory> clicked) {
    	DeterminePlayer();
    	System.out.println("ADD FUNCTIONNNNNNNNNN");
    	 System.out.println("Size"+P.getOwned_Territories().size());
    	 System.out.println("ClickedSize"+clicked.size());
    	  int BonusArmies = P.getOwned_Territories().size()/3;
      
    	  if (BonusArmies<3)
    		  BonusArmies=3;
    	  if( P.getOwned_Territories().contains(clicked.get(0))){
    		  clicked.get(0).setNo_of_armies(clicked.get(0).getNo_of_armies()+BonusArmies);
    		  System.out.println("Bonuss="+BonusArmies);
    		  System.out.println("clicked="+clicked.get(0).getNo_of_armies());
    
    		//  P.setNo_of_armies(P.getNo_of_armies()-1);
        }
    	  
    }
    
    
    @Override
    public void attack(ArrayList<Territory> clicked) {
         DeterminePlayer();
             Territory attacker=clicked.get(0); //meeee 
             Territory defender=clicked.get(1); //will attack
             ArrayList<Territory> NonHumanTerritories = P2.getOwned_Territories();
            
             if (attacker.Get_adj_Territory().contains(defender) ){
             if (attacker.getNo_of_armies()>defender.getNo_of_armies()) { 
            	    defender.setNo_of_armies(attacker.getNo_of_armies()-1);
            	    attacker.setNo_of_armies(1);	
               }
             }
          
             P2.getOwned_Territories().remove(defender);
    	     P.setOwned_Territories(defender);  
    }
    
    
  

	@Override
	public Territory getMaxTerritory(Player P) {
		// TODO Auto-generated method stub
		return null;
	}
}
