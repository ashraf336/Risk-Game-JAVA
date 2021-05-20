package nonAiAgents;

import java.util.ArrayList;
import java.util.List;

import logic.territory;
import players.player;

//places all its bonus armies on the territory with the most armies
//to attack territories with most armies that he can attack.

public class AgreesiveAgent extends NonAiAgents {

	public AgreesiveAgent(List<territory> terrs) {
		super(terrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void placeBonus() {
	 territory	largest_terr = null ;
	 int largestTerrIndex =-1;
	 int  max_armies = 0;
	 for (int i=0;i<this.getMy_terrs().size();i++)
	 { 
		 territory tempTerritory=this.getMy_terrs().get(i);
		 if(tempTerritory.getArmy()>max_armies)
		 {	 largest_terr=tempTerritory;
		     largestTerrIndex=i;
		   	 max_armies=tempTerritory.getArmy();
		 }
		        // break ties with the smallest id
		  else if (tempTerritory.getArmy()==max_armies && tempTerritory.getTerr_id()< largest_terr.getTerr_id())
		  {
			largest_terr= tempTerritory;
			largestTerrIndex=i;
		  }
	 }
	 this.getMy_terrs().get(largestTerrIndex).setArmy( this.getMy_terrs().get(largestTerrIndex).getArmy()+getBonusArmy());
	}

	
	@Override
	public boolean attack(player player) {

		int maxArmies=0;
		List<AttackPair> possibleAttackPairs = new ArrayList<AttackPair>();
		for (int i=0; i< this.getMy_terrs().size();i++)
		{
			territory tempTerritory= this.getMy_terrs().get(i);
			for(int j=0;j<tempTerritory.getNeighbours().size();j++)
			{
				AttackPair tempAttackPair=new AttackPair();	
				List<territory> neighbourTerritories= tempTerritory.getNeighbours();
				if (this.isMineTerr(neighbourTerritories.get(j).getTerr_id())) continue;	// check if this neighbour is holded by me !

				if(neighbourTerritories.get(j).getArmy()>maxArmies&& tempTerritory.getArmy()>neighbourTerritories.get(j).getArmy())
					{
					tempAttackPair.setAttckerTerritory(tempTerritory);
					tempAttackPair.setAttackedTerritory(neighbourTerritories.get(j));
				    maxArmies = neighbourTerritories.get(j).getArmy();
					}
				else if (neighbourTerritories.get(j).getArmy()==maxArmies &&tempAttackPair.getAttackedTerritory()!=null&& neighbourTerritories.get(j).getTerr_id()< tempAttackPair.getAttackedTerritory().getTerr_id()&& tempTerritory.getArmy()>neighbourTerritories.get(j).getArmy())
					{
					tempAttackPair.setAttckerTerritory(tempTerritory);
					tempAttackPair.setAttackedTerritory(neighbourTerritories.get(j));
					}
				if(tempAttackPair.getAttackedTerritory()!=null) possibleAttackPairs.add(tempAttackPair);

			}
		}
		System.out.println("Size of Poissible attacks is "+possibleAttackPairs.size());
			for (int k=0;k<possibleAttackPairs.size()&&possibleAttackPairs!=null;k++)
			{
				System.out.println("Inside Attack No."+k);
			return super.attack(player, possibleAttackPairs.get(k).getAttckerTerritory().getTerr_id(), possibleAttackPairs.get(k).getAttackedTerritory().getTerr_id());
			}
			return false;
	}
	
	
	

}
