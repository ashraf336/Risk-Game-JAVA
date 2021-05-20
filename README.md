                   Risk Game   using  java  FX
 
Team Members :
 Ahmed Ashraf HamidElDine   
 Osama Sherif  	  
 Mohamed Ayman Abdul Muti    
 Ali Moatasem  

Problem Description: 
Risk is a popular game for major strategy type players. In Risk, the objective is to conquer the world by attacking to acquire territory and defending your own territory from your opponents. Risk is a turn-based game and is best if played with two to six players. 
 
In this project we created different player agents. 
 
Non-AI agents include:  
1)	a human agent 
2)	a passive agent 
3)	an aggressive agent 
4)	a nearly pacifist agent 
 
AI agents include:  
1)	a greedy agent  
2)	an A* search agent) 
3)	a real-time A* agent 
4)	minmax alpha-beta pruning agent 
 
We choose JAVA to implement the game with JAVAFX for GUI. 
 
Game Modes  
Playing mode 
Simulation Mode 
 
 
Our Game Assumption 
•	We assume equal distribution of territories to players 
•	Random distribution for troops is assumed in the beginning of the game. 
Attack Function 
•	A player wins the attack if he has more armies in his territory than the attacked territory 
•	The loser player lose his territory and the winner get it into his list of territories without any loss in armies by the attack.  
 
 
 
 
 
 
 
 
Sample Run Of Game 
•	User can use play mode or Simulate mode 
 
 
 
•	Then choose the player one the Two 
 
 
•	Then starting the game with player one turn 
 
 
 
  
 
 
 
Around Agents Explanation 
MiniMax 
•	is a decision rule used in artificial intelligence for minimizing the possible loss for a worst case (maximum loss) scenario. 
•	Expanded possible states of the game from the current state using DFS strategy alternately between max and min prospective then using alpha beta pruning technique to reduce the expansion tree size. 
•	After that every step in the game have next in the agent to satisfy the objective to maximize the territories till conquer the whole world. 
•	The huerstiuc used is  
H=1000* Num of territories 
H(s)=H + each territory army * its enemy neighbors list size - each territory army in opposite* its mine neighbors   list size 
 
 
 
 
 
 
 
