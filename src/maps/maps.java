/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public interface maps {
     public void openfiletoread()throws FileNotFoundException ;
     public void readfromfile();
     public String getwallpapper();
     public void maketerritories(int x);
     public ArrayList<Territory> getTerritories(); 
}
