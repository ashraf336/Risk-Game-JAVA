package logic;

import java.util.ArrayList;
import java.util.List;

public class territory {
    private int terr_id;
    private List<territory> neighbours = new ArrayList<territory>();
    private int army;

    
    public territory(int terr_id, List<territory> neighbours) {
        this.terr_id = terr_id;
        this.neighbours = neighbours;
        this.army=(int)(Math.random()*(10-2))+2;
    }
    
    public  void add_neighbours(List<territory> neighbours_list){
        this.neighbours = neighbours_list;
        return;
    }

	public int getTerr_id() {
		return terr_id;
	}

	public void setTerr_id(int terr_id) {
		this.terr_id = terr_id;
	}

	public List<territory> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<territory> neighbours) {
		this.neighbours = neighbours;
	}

	public int getArmy() {
		return army;
	}

	public void setArmy(int army) {
		this.army = army;
	}
	
	public void printTerr() {
		System.out.println("ID: "+this.terr_id+"|ARMY: "+this.army);
		
	}
    
}
