/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents;

import Agents.AI.Astar;
import Agents.AI.Gready;
import Agents.AI.realtime;
import Agents.nonAI.Passive;
import Agents.nonAI.aggressive;
import Agents.nonAI.pacifist;
import risk_game.Game;

/**
 *
 * @author yarae
 */

public class AgentMaker {
    
    public Agent create(String name,Game g)
	{  
         
		// {"Human","completely passive","aggressive","nearly pacifist","greedy agent","A* agent","real-time A*"}
		if(name.equals("passive"))
			return new Passive(g);
		else if(name.equals("aggressive"))
			return new aggressive(g);
		else if(name.equals("pacifist"))
			return new pacifist(g);
		else if(name.equals("greedy"))
			return new Gready(g);
		else if(name.equals("A*"))
			return new Astar(g);
		else if(name.equals("real time"))
			return new realtime(g);
		return null;
	}
    
}
