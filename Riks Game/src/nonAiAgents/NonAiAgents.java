package nonAiAgents;

import java.util.List;

import logic.territory;
import players.player;

public class NonAiAgents extends player implements AgentsPlayerActions{

	public NonAiAgents(List<territory> terrs) {
		super(terrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void placeBonus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attack(player player) {
		return true;
		// TODO Auto-generated method stub
		
	}

}
