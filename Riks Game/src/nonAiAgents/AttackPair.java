package nonAiAgents;

import logic.territory;

public class AttackPair {

private territory attckerTerritory;
private territory attackedTerritory;


public AttackPair(territory attacker, territory attacked)
{
this.attckerTerritory=attacker;
this.attackedTerritory=attacked;
}


public AttackPair()
{

}

public territory getAttckerTerritory() {
	return attckerTerritory;
}


public void setAttckerTerritory(territory attckerTerritory) {
	this.attckerTerritory = attckerTerritory;
}


public territory getAttackedTerritory() {
	return attackedTerritory;
}


public void setAttackedTerritory(territory attackedTerritory) {
	this.attackedTerritory = attackedTerritory;
}



}

