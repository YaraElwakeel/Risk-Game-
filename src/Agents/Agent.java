/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

import java.util.ArrayList;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public interface Agent {

    
    
    
    public void addarmies();
    public void setPlayer(Player p);
    public boolean canAttack() ;
    public Territory getMinTerritory(Player P) ;
    public Territory getMaxTerritory(Player P) ;
	public void attack();
        public void DeterminePlayer();
    public void addarmiesh(ArrayList<Territory> clicked);
    public void attack(ArrayList<Territory> clicked);
}