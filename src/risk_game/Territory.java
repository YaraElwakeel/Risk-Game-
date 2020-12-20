/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yarae
 */
public class Territory {
     public List<Territory> adjacent_Territories = new ArrayList<Territory>();
     public Territory parent_Territory = null;
     int territory_no;
     int xcoordinate;
     int ycoordinate;
     
    public Territory(int territory_no) {
        this.territory_no=territory_no;  
    }
    public int get_no(){
         return territory_no;
    }
    public List<Territory> Get_adj_Territory(){
         return adjacent_Territories;
    }
     
    public void makechild(Territory t ){
         this.adjacent_Territories.add(t);
         t.parent_Territory=this;
     }
}
