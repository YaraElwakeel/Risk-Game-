/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Agents.nonAI.HumanAgent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import maps.maps;
import risk_game.Game;
import risk_game.Territory;

/**
 *
 * @author yarae
 */
public class GamePanel extends JPanel implements ActionListener,MouseListener{

    Game game;
    ImageIcon wall;
    maps map;
   
    boolean PlayerAisPlaying=true;
    Timer t =new Timer(700, this);
    ArrayList<Territory> ts = new ArrayList<>();
    ArrayList<Territory>clicked=new ArrayList<>();
        ImageIcon circle = new ImageIcon("resources/black button.png");
        ImageIcon  circleA = new ImageIcon("resources/pink button.png");
        ImageIcon circleB = new ImageIcon("resources/blue button.png");
        ImageIcon Battle=new ImageIcon("resources/battle.png");
        ImageIcon PlayerA=new ImageIcon("resources/playerA.png");
        ImageIcon PlayerB=new ImageIcon("resources/playerB.png");
        ImageIcon Player;
        ImageIcon Add=new ImageIcon("resources/add.png");
    public GamePanel(Game game) {
        t.start();
        Player=PlayerA;
        this.game = game;
        this.map = game.getM();
        this.ts = map.getTerritories();
        wall = new ImageIcon(map.getwallpapper());
        addMouseListener(this);
        Dimension size = new Dimension(wall.getIconWidth(), wall.getIconHeight());
        System.out.print(size);
//        setPreferredSize(size);
//        setMinimumSize(size);
//        setMaximumSize(size);
        setSize(size);
//        setLayout(null);
        
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Arial", Font.BOLD, 18);
        g.drawImage(wall.getImage(), 0, 0, null);
        g.drawImage(Player.getImage(), 10, 5, this);
        g.drawImage(Battle.getImage(), 100, 680, this);
        g.drawImage(Add.getImage(), 700, 680, this);
        for (int i = 0; i < game.getA().getOwned_Territories().size(); i++) {
            g.drawImage(circleA.getImage(), game.getA().getOwned_Territories().get(i).xcoordinate, game.getA().getOwned_Territories().get(i).ycoordinate, null);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf( game.getA().getOwned_Territories().get(i).getNo_of_armies()), game.getA().getOwned_Territories().get(i).xcoordinate+10,  game.getA().getOwned_Territories().get(i).ycoordinate+25);
            
        }
        for (int i = 0; i < game.getB().getOwned_Territories().size(); i++) {
            g.drawImage(circleB.getImage(),game.getB().getOwned_Territories().get(i).xcoordinate, game.getB().getOwned_Territories().get(i).ycoordinate, null);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf( game.getB().getOwned_Territories().get(i).getNo_of_armies()), game.getB().getOwned_Territories().get(i).xcoordinate+20,  game.getB().getOwned_Territories().get(i).ycoordinate+20);
        }
        for (Territory t : clicked) {
            g.drawImage(circle.getImage(),t.getXcoordinate(),t.getYcoordinate(),null);
        }
    }
public void switchPlayers()
{
    if(PlayerAisPlaying) //Player A is playing now 
    { 
        Player=PlayerB;
        if (game.getB().getG() instanceof HumanAgent) {
             t.stop();
        }
        else{
        	System.out.println("gameee="+game.getB().getPlayer_id());
        game.getB().play();    
        PlayerAisPlaying=false;
        }
    }
    else
    {
        Player=PlayerA;
        if (game.getA().getG() instanceof HumanAgent) {
             t.stop();
        }
        else{
        game.getA().play(); 
        PlayerAisPlaying=true;
        }
    }
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
       switchPlayers();
       repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int y=e.getY();
        int x=e.getX();
        for (int i = 1; i < ts.size(); i++) {
            Territory t=ts.get(i);
            if (x>=t.getXcoordinate()
                    &&x<=t.getXcoordinate()+circleA.getIconWidth()
                    &&y>=t.getYcoordinate()
                    &&y<=t.getYcoordinate()+circleA.getIconHeight()) {
               
                 clicked.add(t); 
                 
        }
            
            repaint();
            }
            if (x>=100&&x<=100+Battle.getIconWidth()&&y>=680&&y<=680+Battle.getIconHeight()) {
             // boolean attacked= game.getA().getG().canAttack();
              System.out.print("attack");
             
              if (game.getA().getG() instanceof HumanAgent) {
                  game.getA().getG().attack(clicked);
                  PlayerAisPlaying=false;
           }
            
           else if (game.getB().getG() instanceof HumanAgent) {
           
                game.getB().getG().attack(clicked);
                PlayerAisPlaying=false;
             }
             repaint();
             
         clicked.clear();          
         t.start();
            
       }
             
            if (x>=700&&x<=700+Battle.getIconWidth()&&y>=680&&y<=680+Battle.getIconHeight()) {
               // game.getA().getG().addarmies();
                System.out.println("add");
                if (game.getA().getG() instanceof HumanAgent) {
                       game.getA().getG().addarmiesh(clicked);
                       PlayerAisPlaying=false;
                }
                 
                else if (game.getB().getG() instanceof HumanAgent) {
                
                     game.getB().getG().addarmiesh(clicked);
                     PlayerAisPlaying=false;
                  }
                  repaint();
                  
              clicked.clear();          
              t.start();
                 
            }
            repaint(); 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
