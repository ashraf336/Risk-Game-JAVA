package nonAiAgents;

import java.util.ArrayList;
import java.util.List;

import logic.territory;
import players.player;

//that places all of its bonus armies to the territory with the fewest armies
//conquers only the one territory with fewest armies (if it can).
public class NearlyPacifistAgent extends NonAiAgents  {

	public NearlyPacifistAgent(List<territory> terrs) {
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
	int minArmies=1000;
		AttackPair attackPair=new AttackPair();
		for (int i=0; i< this.getMy_terrs().size();i++)
		{
			territory tempTerritory= this.getMy_terrs().get(i);
			for(int j=0;j<tempTerritory.getNeighbours().size();j++)
			{
				List<territory> neighbourTerritories= tempTerritory.getNeighbours();
				if(neighbourTerritories.get(j).getArmy()<minArmies)
					{
					if (this.isMineTerr(neighbourTerritories.get(j).getTerr_id())) continue;	
					System.out.println("INSIDE");
				    attackPair.setAttckerTerritory(tempTerritory);
				    attackPair.setAttackedTerritory(neighbourTerritories.get(j));
					minArmies = neighbourTerritories.get(j).getArmy();
					}
				else if (neighbourTerritories.get(j).getArmy()==minArmies && neighbourTerritories.get(j).getTerr_id()< attackPair.getAttackedTerritory().getTerr_id())
					{
					if (this.isMineTerr(neighbourTerritories.get(j).getTerr_id())) continue;	//check if the neighbour is in my terrs
					attackPair.setAttckerTerritory(tempTerritory);
				    attackPair.setAttackedTerritory(neighbourTerritories.get(j));
					}
				
			}			
		}
		
		if (attackPair.getAttckerTerritory().getArmy()>attackPair.getAttackedTerritory().getArmy())
			return super.attack(player, attackPair.getAttckerTerritory().getTerr_id(), attackPair.getAttackedTerritory().getTerr_id());
		return false;
	}

	
}
