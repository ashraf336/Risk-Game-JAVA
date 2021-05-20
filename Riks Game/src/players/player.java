package players;
import java.util.ArrayList;
import java.util.List;

import logic.*;

public class player {

    private List<territory> my_terrs = new ArrayList<territory>();
    private int bonusArmy ;
    
    public player(List<territory> terrs) {
        this.my_terrs= (List<territory>) terrs; 
        this.bonusArmy=0;
    }

    public List<territory> getMy_terrs() {
		return my_terrs;
	}
    
    public territory getTerr(int terrID)
    {
    	  for(int i=0;i<this.getMy_terrs().size();i++)
          {
    		  territory tempTerritory =this.getMy_terrs().get(i);
    		  if (tempTerritory.getTerr_id()==terrID)   return tempTerritory;
          }
    	  return null;
    }

	public int getBonusArmy() {
		return bonusArmy;
	}
	
	public boolean isMineTerr(int id) {
		for(int i =0;i<this.my_terrs.size();i++)
		{
			if(this.my_terrs.get(i).getTerr_id()==id)
				return true;
		}
			
		return false;	
	}
	
	public void setBonusArmy(int bonusArmy) {
		this.bonusArmy = bonusArmy;
	}


	public void add_terr(territory terr){
        this.my_terrs.add(terr);
        return;
    }
	
	public boolean attack(player player2,int terrID1,int terrID2) {
		System.out.println("IDS:"+terrID1+terrID2);
		territory myTerritory=this.getTerr(terrID1);
		territory attackedTerritory=player2.getTerr(terrID2);
		if ( myTerritory==null || attackedTerritory==null)
		{
		System.out.println(" NULL not such terr in human or attacked !!");
		return false ;
		}
		 if(myTerritory.getArmy()>attackedTerritory.getArmy())
			 	{
			 System.out.println("Human attaking >> WINS!!");
			 	
			 	attackedTerritory.setArmy((int)(Math.random()*(myTerritory.getArmy()-2))+2);
			 	myTerritory.setArmy(Math.abs(myTerritory.getArmy()-attackedTerritory.getArmy()));
	 			this.add_terr(player2.remove_terr(terrID2));
	 			return true;
	 			
			 	}
	     else
	     { 	
	    	 System.out.println("Human attaking >> LOSE!!");
	    	 myTerritory.setArmy((int)(Math.random()*(myTerritory.getArmy()-2))+2);
			 attackedTerritory.setArmy(Math.abs(myTerritory.getArmy()-attackedTerritory.getArmy()));
	         player2.add_terr(this.remove_terr(terrID1));
	         return true;
	     }
	}

    public territory remove_terr(int id){
        territory removed_terr= null;
        for(int i=0; i<my_terrs.size();i++) {
            if (my_terrs.get(i).getTerr_id()==id) {
                removed_terr = this.my_terrs.remove(i);
                return removed_terr;
            }
        }
        return removed_terr;
    }
}
