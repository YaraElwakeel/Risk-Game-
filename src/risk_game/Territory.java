/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import java.util.ArrayList;
/**
 *
 * @author yarae
 */
public class Territory {
     public ArrayList<Territory> adjacent_Territories = new ArrayList<Territory>();
     public Territory parent_Territory = null;
     int territory_no;
     boolean available=true;
     int no_of_armies=0;
     Player p;
     public int xcoordinate;
     public int ycoordinate;
     public int playerno;

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNo_of_armies() {
        return no_of_armies;
    }

    public Player getP() {
        System.out.println("i am hereeeeee");
        return p;
        
    }

    public void setP(Player p,int A) {
        this.playerno=A;
        System.out.println("i am hereeeeee"+A);
        this.p = p;
    }

    public void setNo_of_armies(int no_of_armies) {
        this.no_of_armies = no_of_armies;
    }     
    public Territory(int territory_no) {
        this.territory_no=territory_no;  
    }
    public int get_no(){
         return territory_no;
    }
    public ArrayList<Territory> Get_adj_Territory(){
         return adjacent_Territories;
    }
     
    public void makechild(Territory t ){
         this.adjacent_Territories.add(t);
         t.parent_Territory=this;
     }
     public int getXcoordinate() {
        return xcoordinate;
    }

    public void setXcoordinate(int xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public int getYcoordinate() {
        return ycoordinate;
    }

    public void setYcoordinate(int ycoordinate) {
        this.ycoordinate = ycoordinate;
    }
}
