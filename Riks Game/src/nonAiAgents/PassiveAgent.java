package nonAiAgents;
import java.util.ArrayList;
import java.util.List;

import logic.territory;
import players.player;


//that places all of its bonus armies to the territory with the fewest armies
//doesn’t make any attacks.
public class PassiveAgent extends NonAiAgents  {

	public PassiveAgent(List<territory> terrs) {
		super(terrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void placeBonus() {
		 territory	fewest_terr = null ;
		 int fewest_terrIndex =-1;
		 int  min_armies = 10000;
		 for (int i=0;i<this.getMy_terrs().size();i++)
		 { 
			 territory tempTerritory=this.getMy_terrs().get(i);
			 if(tempTerritory.getArmy()<min_armies)
			 {	 fewest_terr=tempTerritory;
			 fewest_terrIndex=i;
			     min_armies=tempTerritory.getArmy();
			 }
			        // break ties with the smallest id
			  else if (tempTerritory.getArmy()==min_armies && tempTerritory.getTerr_id()< fewest_terr.getTerr_id())
			  {
				  fewest_terr= tempTerritory;
				  fewest_terrIndex=i;
			  }
		 }
		 this.getMy_terrs().get(fewest_terrIndex).setArmy( this.getMy_terrs().get(fewest_terrIndex).getArmy()+getBonusArmy());		
	}

	@Override
	public boolean attack(player player) {
		return false;
		//has no attcakes
			}
	}
	
