package players;

import java.util.Iterator;
import java.util.List;

import logic.territory;

public class HumanPlayer extends player {

	public HumanPlayer(List<territory> terrs) {
		super(terrs);
		// TODO Auto-generated constructor stub
	}

	
	public boolean  placeBonus(int bonus,int terrId) {
		if (!super.isMineTerr(terrId)|| bonus>this.getBonusArmy() )
		{
			return false;
		}
		for(int i=0;i<this.getMy_terrs().size();i++)
		{
			territory tempTerritory =this.getMy_terrs().get(i);
			if (tempTerritory.getTerr_id()== terrId) {
				tempTerritory.setArmy(tempTerritory.getArmy()+bonus);
				return true;
			}
		}
		return true ; 
	
		
	}

	
	public boolean attack(player player2,int terrID1,int terrID2) {
		System.out.println("id1"+terrID1+"id2"+terrID2);
		return super.attack(player2, terrID1, terrID2);
	}


}
