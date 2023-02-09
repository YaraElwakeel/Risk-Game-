/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.*;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public final class Egypt implements maps{

    private Scanner x;
    private Scanner x1;
    private Formatter y;
    public String wallpaper="resources/Egypt_Map.png";
    ArrayList<Territory> ts = new ArrayList<>();
    int no_of_cities;

    public Egypt() throws FileNotFoundException {
        openfiletoread();
        readfromfile();
        
    }

    @Override
    public void openfiletoread() throws FileNotFoundException {
        x = new Scanner(new File("resources/egypt.txt"));
        x1= new Scanner(new File("resources/egypt coordinates.txt"));
    }
     @Override
    public void readfromfile() {
        this.no_of_cities=parseInt(x.nextLine());
        maketerritories(no_of_cities);
        int i=0;
        while (x.hasNextLine()) {
            i++;
            String[] splitStr = x.nextLine().trim().split("\\s+");
            for (String splitStr1 : splitStr) {
                this.ts.get(i).makechild(ts.get(parseInt(splitStr1)));
            }   
        }
        i=0;
         while (x1.hasNextLine()) {
            i++;
            this.ts.get(i).setXcoordinate(x1.nextInt());
            this.ts.get(i).setYcoordinate(x1.nextInt());
         }
    }
     @Override
    public void maketerritories(int x){
        this.ts.add(0, null);
        for (int i = 1; i < x+1; i++) {
            this.ts.add(i, new Territory(i));
        }
    }

    @Override
    public ArrayList<Territory> getTerritories() {
        return  ts;
    }
    @Override
    public String getwallpapper() {
        return wallpaper;
    }
}
