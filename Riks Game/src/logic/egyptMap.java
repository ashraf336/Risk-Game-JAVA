package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class egyptMap {
	
    List<territory> p1_terrs = new ArrayList<territory>();
    List<territory> p2_terrs = new ArrayList<territory>();
    List<territory> map_terrs = new ArrayList<territory>();

    public egyptMap() {
    	this.map_terrs=generate_map();
        random_map();
        distribute_army(this.p1_terrs);
        distribute_army(this.p2_terrs);
        return;
    }

    public List<territory> generate_map() {
        territory terr1 = new territory(1, null);
        territory terr2 = new territory(2, null);
        territory terr3 = new territory(3, null);
        territory terr4 = new territory(4, null);
        territory terr5 = new territory(5, null);
        territory terr6 = new territory(6, null);

        ArrayList<territory> neighbour1  = new ArrayList<territory>(List.of(terr3, terr6));
        terr1.add_neighbours(neighbour1 );

        ArrayList<territory> neighbour2  = new ArrayList<territory>(List.of(terr4, terr6));
        terr2.add_neighbours(neighbour2 );

        ArrayList<territory> neighbour3  = new ArrayList<territory>(List.of(terr1, terr4));
        terr3.add_neighbours(neighbour3 );

        ArrayList<territory> neighbour4  = new ArrayList<territory>(List.of(terr3, terr2,terr6));
        terr4.add_neighbours(neighbour4 );

        ArrayList<territory> neighbour5  = new ArrayList<territory>(List.of(terr6));
        terr5.add_neighbours(neighbour5 );

        ArrayList<territory> neighbour6  = new ArrayList<territory>(List.of(terr1, terr2,terr4,terr5));
        terr6.add_neighbours(neighbour6 );

        ArrayList<territory> list_of_terrs  = new ArrayList<territory>(List.of(terr1, terr2,terr3, terr4, terr5,terr6));

        return list_of_terrs;
    }

    public  void random_map(){
        Random rand = new Random();
        for (int i=map_terrs.size()-1;i>0;i--){
            int j = rand.nextInt(i);
            Collections.swap(map_terrs, i, j);
        }
        int half_count= (map_terrs.size()/2);
        for(int p1=0; p1<half_count;p1++ ){
            p1_terrs.add(map_terrs.get(p1));
        }
        for(int p2=half_count; p2<map_terrs.size();p2++ ){
            p2_terrs.add(map_terrs.get(p2));
        }
        return;
    }

    public  void distribute_army(List<territory> player_terrs){
    	
            int initial_army=20;
            int player_dist_factor=initial_army - player_terrs.size();
          //  System.out.println( player_terrs.size());
            while(player_dist_factor!=0){
                for (int i=0;i<player_terrs.size();i++){
                    if (player_dist_factor==0)
                        return;
                 player_terrs.get(i).setArmy( player_terrs.get(i).getArmy()+1);
                 player_dist_factor--;
                }
            }
            return;
    }

    public  void print_map(List<territory> list_of_terrs){
        for(int i=0 ; i<list_of_terrs.size();i++ ){
        	System.out.println("LIST IS ");
            //System.out.println("ID: " + list_of_terrs.get(i).terr_id+"ARMY:"+list_of_terrs.get(i).army);
        }
        return;
    }


}
