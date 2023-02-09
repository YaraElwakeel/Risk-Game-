/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agents.AI;

import java.util.ArrayList;
import maps.maps;
import risk_game.Game;
import risk_game.Player;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class clone {

    Game game1;
    Game game2 = new Game();

    public clone(Game game) {
        this.game1 = game;

        game2.setM(game1.getM());
        Player a = new Player(game1.getA().getG());
        a.setNo_of_armies(game1.getA().getNo_of_armies());
        ArrayList<Territory> t = new ArrayList<Territory>();
        t.addAll(game1.getA().getOwned_Territories());
        for (Territory te : t) {
            a.setOwned_Territories(te);
        }
        Player b = new Player(game1.getB().getG());
        b.setNo_of_armies(game1.getB().getNo_of_armies());
        ArrayList<Territory> t2 = new ArrayList<Territory>();
        t2.addAll(game1.getB().getOwned_Territories());
        for (Territory te : t2) {
            b.setOwned_Territories(te);
        }
        game2.setA_clone(a);
        game2.setB_clone(b);
    }

}
