/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk_game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import maps.Panel;


/**
 *
 * @author yarae
 */
public class Risk_Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
         Panel panel = new Panel(
         new ImageIcon("resources/wallpapper1.jpg").getImage());

    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
    }
    
