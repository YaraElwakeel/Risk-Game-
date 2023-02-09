/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import java.util.ArrayList;
import maps.maps;

/**
 *
 * @author yarae
 */
public class Game implements Cloneable{

    maps m;
    Player A;
    Player B;
    int NoOfPlayers = 0;
    public String Acircle = "resources/c.purple.png";
    public String Bcircle = "resources/c.pink.png";
    ArrayList<Territory> ts = new ArrayList<>();

    public Game() {
    }

    public int getNoOfPlayers() {
        return NoOfPlayers;
    }

    public void setNoOfPlayers(int NoOfPlayers) {
        this.NoOfPlayers = NoOfPlayers;
    }

    public maps getM() {

        return m;
    }

    public void setM(maps m) {
        this.m = m;
        this.ts = m.getTerritories();
    }

    public Player getA() {
        return A;
    }
    public void setA_clone(Player A){
        this.A = A;
    }
    public void setB_clone(Player B){
        this.B = B;
    }
    
    

    public void setA(Player A) {
        this.A = A;
        //players.add(A);
        inializeGame();
    }

    public Player getB() {
        return B;
    }

    public void setB(Player B) {
        this.B = B;
//        players.add(B);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void inializeGame() {
        System.out.println("\nA");
        outerloopA:
        for (int k = 0; k < 20; k++) {
            int y = getRandomNumber(1, 27);
            if (ts.get(y).available == true) {
                A.setOwned_Territories(ts.get(y));
                ts.get(y).setNo_of_armies(ts.get(y).no_of_armies + 1);
                A.setNo_of_armies(A.getNo_of_armies() - 1);
                System.out.print(" " + ts.get(y).getNo_of_armies() + " ");
            } else {
                ts.get(y).setNo_of_armies(ts.get(y).no_of_armies + 1);
            }
        }
        for (int i = 1; i < ts.size(); i++) {
            if (ts.get(i).available == true) {
                B.setOwned_Territories(ts.get(i));
                ts.get(i).setNo_of_armies(ts.get(i).no_of_armies + 1);
                B.setNo_of_armies(B.getNo_of_armies() - 1);
            }
        }

        int x = B.getNo_of_armies();
        outerloop:
        for (int j = 0; j < x; j++) {
            for (int i = 0; i < B.getOwned_Territories().size(); i++) {
                B.getOwned_Territories().get(i).setNo_of_armies(B.getOwned_Territories().get(i).getNo_of_armies() + 1);
                B.setNo_of_armies(B.getNo_of_armies() - 1);
                if (B.getNo_of_armies() == 0) {

                    break outerloop;
                }
            }
        }
        System.out.println("\nB");
        for (Territory t : B.getOwned_Territories()) {
            System.out.print(t.getNo_of_armies() + " ");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Game g =new Game();
        g.setM(this.getM());
        Player a = new Player(this.getA().getG());
        a.setNo_of_armies(this.getA().getNo_of_armies());
        ArrayList<Territory> t = new ArrayList<>();
        t.addAll(this.getA().getOwned_Territories());
        for (Territory te : t) {
            a.setOwned_Territories(te);
        }
        Player b = new Player(this.getB().getG());
        b.setNo_of_armies(this.getB().getNo_of_armies());
        ArrayList<Territory> t2 = new ArrayList<>();
        t2.addAll(this.getB().getOwned_Territories());
        for (Territory te : t2) {
            b.setOwned_Territories(te);
        }
        g.setA_clone(a);
        g.setB_clone(b);
        return g;
    }
    
}
