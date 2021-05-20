package logic;

import nonAiAgents.*;
import players.*;

public class Game implements GameInterface {
 private static USmap mymap;
 private static player myplayer1 ;
 private static player myplayer2 ;
 private static char myGameType;


    /** Singletone !! **/
	private static Game instance1 = null;
	
	
	 public synchronized static Game getInstance(char gameType) 
	 {
		 
		 if (instance1 == null) {
	            instance1 = new Game();
	        }
	        return instance1;
	  }
	 public synchronized static Game getInstance() 
	 {
		 mymap = new USmap();
	        if (instance1 == null) {
                     return null;	       
       }
	        return instance1;
	  }
		
	public static int calcBouns(player p)
	{
		int len = p.getMy_terrs().size();
		 return ((int)(Math.ceil(len/3)));
	}
	
    public static USmap getMymap() {
		return mymap;
	}
	public static void setMymap(USmap mymap) {
		Game.mymap = mymap;
	}
	public static player getMyplayer1() {
		return myplayer1;
	}
	public static void setMyplayer1(player myplayer1) {
		Game.myplayer1 = myplayer1;
	}
	public static player getMyplayer2() {
		return myplayer2;
	}
	public static void setMyplayer2(player myplayer2) {
		Game.myplayer2 = myplayer2;
	}
	public static char getMyGameType() {
		return myGameType;
	}
	public static void setMyGameType(char myGameType) {
		Game.myGameType = myGameType;
	}


    
}
