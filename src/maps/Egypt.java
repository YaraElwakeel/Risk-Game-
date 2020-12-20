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
    private Formatter y;
    public String wallpaper="Egypt_Map.png";
    List<Territory> t_all = new ArrayList<Territory>();
    int no_of_cities;
    Territory ts[] =null;

    public Egypt() throws FileNotFoundException {
        openfiletoread();
        readfromfile();
    }

    @Override
    public void openfiletoread() throws FileNotFoundException {
        x = new Scanner(new File("egypt.txt"));

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
                this.ts[i].makechild(ts[parseInt(splitStr1)]);
            }
        }
    }
     @Override
    public void maketerritories(int x){
        for (int i = 1; i <= no_of_cities; i++) {
            this.ts[i] = new Territory(i);
        }
    }
}
