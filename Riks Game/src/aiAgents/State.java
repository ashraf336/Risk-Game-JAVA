package state;
import  game.game;
import game.territory;
import players.player;

import java.util.ArrayList;
import java.util.List;

public class State {
    ArrayList<territory> playerTerritories = new ArrayList<territory>();
    ArrayList<territory> enemyTerritories = new ArrayList<territory>();
    int heuristic ;
    int depth;
    territory attacker ;
    territory defender ;
    State parent ;



/*
/////to be continued//****
 /
    public   ArrayList<State> stateExpansion(){

        ArrayList<State> expansions;
        for(int i =0; i<playerTerritories.size();i++){
            for(int j =0; j<enemyTerritories.size();j++){
                ArrayList<ArrayList<territory>> tempAttack=attack(playerTerritories,enemyTerritories,playerTerritories.get(i).getTerr_id(),enemyTerritories.get(j).getTerr_id());

            }
        }

    }
*/
    public static territory getTerr(List<territory> myTerr,int terrID)
    {
        for(int i=0;i<myTerr.size();i++)
        {
            territory tempTerritory =myTerr.get(i);
    		 /*System.out.println("terr id: "+tempTerritory.getTerr_id());
    		  System.out.println("wanted id : "+terrID);*/
            if (tempTerritory.getTerr_id()==terrID)   return tempTerritory;
        }
        return null;
    }

    public static ArrayList<ArrayList<territory>>  attack(ArrayList<territory> myTerrs,ArrayList<territory> enemeyTerrs, int terrID1, int terrID2) {
        System.out.println("IDS:"+terrID1+terrID2);
        territory myTerritory=getTerr(myTerrs,terrID1);
        territory attackedTerritory=getTerr(myTerrs,terrID2);
        ArrayList<ArrayList<territory>> afterAttack= new ArrayList<ArrayList<territory> >();
        if(myTerritory.getArmy()>attackedTerritory.getArmy())
        {   attackedTerritory.setArmy(0);
            myTerrs.add(attackedTerritory);
            remove_terr(terrID2,enemeyTerrs);
            afterAttack.add(0,myTerrs);
            afterAttack.add(1,enemeyTerrs);
        }
        else
        {   myTerritory.setArmy(0);
            enemeyTerrs.add(myTerritory);
            remove_terr(terrID1,myTerrs);
            afterAttack.add(0,myTerrs);
            afterAttack.add(1,enemeyTerrs);

        }
        return null;
    }


    public static territory remove_terr(int id,List<territory>  my_terrs ) {
        territory removed_terr = null;
        for (int i = 0; i < my_terrs.size(); i++) {
            if (my_terrs.get(i).getTerr_id() == id) {
                removed_terr = my_terrs.remove(i);
                return removed_terr;
            }
        }
        return  removed_terr;
    }
        //for inital state
        public void initialState (ArrayList < territory > playerTerritories, ArrayList < territory > enemyTerritories)
        {
            this.playerTerritories = playerTerritories;
            this.enemyTerritories = enemyTerritories;
            this.parent = null;
            depth = 0;
            setHeuristic();
        }

        //for internal state
        public void normalState
        (ArrayList < territory > playerTerritories, ArrayList < territory > enemyTerritories, State parent ,int depth)
        {
            this.playerTerritories = playerTerritories;
            this.enemyTerritories = enemyTerritories;
            this.parent = parent;
            this.depth = depth;
            setHeuristic();
        }

   /* private void setHeuristic()
    {
        this.heuristic = playerTerritories.size() * 1000;
       for(int i =0; i<playerTerritories.size();i++)
       { territory currentTerr = playerTerritories.get(i);
         currentTerr.getArmy()*(this.)

       }
    }
*/

        private void setHeuristic ()
        {
            this.heuristic = playerTerritories.size() * 1000;
            playerTerritories.stream().map((territory) -> {
                this.heuristic += territory.getArmy() * (getEnemyNeighbours(territory, enemyTerritories).size() + 1);
                return territory;
            }).forEachOrdered((_item) -> {
                this.heuristic++;
            });
            enemyTerritories.stream().map((territory) -> {
                this.heuristic -= territory.getArmy() * (getEnemyNeighbours(territory, playerTerritories).size() + 1);
                return territory;
            }).forEachOrdered((_item) -> {
                this.heuristic--;
            });
        }

        public  List<territory> getEnemyNeighbours (territory terr, List<territory> enemyList)
        {
            List<territory> neighbourList = terr.getNeighbours();
            List<territory> enemyNeighbours = new ArrayList<territory>();
            for (int i = 0; i < neighbourList.size(); i++) {
                for (int j = 0; j < enemyList.size(); j++) {
                    if (neighbourList.get(i).getTerr_id() == enemyList.get(j).getTerr_id())
                        enemyNeighbours.add(neighbourList.get(i));
                }
            }
            return enemyNeighbours;
        }

    }


