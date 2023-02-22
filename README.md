# **Risk Game** 
Developed by Hasbro, Risk is a challenging board game that integrates skills and luck. The objective is straightforward: take over the planet. Despite such a straightforward objective, the game is such a straightforward objective, the game is quite complex and dynamic. Gamers try to conquer the entire globe by destroying every other player. Players are eliminated when they lose all of their soldiers on the game board. Gamers must be skillful at unit deployment and understand the game's underlying possibilities.
## the board 
Based on the map, the Risk game board is split into territories. the game have two map selections in this case: Egypt and the United States.

At the outset, each player has 20 troops to distribute over the board's available regions. Each turn is divided into two sections: army placement and attack. At the start of your round, calculate the total number of territories you hold and divide by three. This is the number of additional armies you will receive for a land (ignoring fractions). If your total number of territories is fewer than three, you will be given three armies instead. You may make attacks after positioning your soldiers. Only if your territory has two or more armies and the target territory is close by, are you permitted to invade it. A single army must stay behind to guard your region; all other armies are free to attack.

## playing agents 
In the game you are provided by four playing (Non-AI) agents, and four playing AI agents.

Two game modes—playing mode and simulation mode—are provided. The user can select any two agents from the list of defined agents, except the human agent, to compete against one another in the simulation mode. In the playing mode, the human agent will only select one other agent to compete with.
For all players, the initial deployment of armies is done at random.
### **Non-AI agents** 
1. A human agent that can perform activities via the GUI.
2. A wholly passive agent that deploys all of its bonus armies to the region with the fewest troops and refrains from initiating any assaults.
3. An aggressive agent that greedily tries to assault territories with the most troops he may attack and always deploys all of its bonus armies on the territory with the most armies.
4. A nearly pacifist agent only occupies the one area with the fewest soldiers after positioning its forces as though it were a totally passive agent (if it can).
### **AI agents**
1. A greedy agent that chooses the move with the highest immediate heuristic value.
2. A* search performed by a similar agent
3. A real-time A* agent.
4. A Minimax with beta-pruning agent.
![Screenshot 2023-02-21 213029](https://user-images.githubusercontent.com/66715310/220516115-fc5effc5-0653-4737-b076-2cec96553963.png)
![Screenshot 2023-02-21 212901](https://user-images.githubusercontent.com/66715310/220516494-04d7d3f6-bc53-4179-8fa2-a9cd5cb1ad1f.png)
![Screenshot 2023-02-21 213631](https://user-images.githubusercontent.com/66715310/220517095-172e900f-3923-47c2-b49e-10335de99127.png)


