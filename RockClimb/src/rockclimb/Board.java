/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author johndunn
 */

public class Board extends JPanel implements Runnable {

   private final int B_WIDTH = 1400;
   private final int B_HEIGHT = 800;
   //private final int INITIAL_X = -40;
   //private final int INITIAL_Y = -40;
   private final int DELAY = 150;
   private final int NUM_ROWS = 30;
   private final int ROW_HEIGHT = B_HEIGHT / NUM_ROWS;

   private List<Hold> holds = new ArrayList<Hold>();
   private Thread animator;
   private int x, y;

   /**
    * Creates new form Board
    */
   public Board() {
      initComponents();
      initBoard();
   }

   private void initBoard() {

      setBackground(Color.WHITE);
      setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
      setDoubleBuffered(true);
      
      ArrayList<Points> pointList = new ArrayList<Points>();
      
       ArrayList<Integer> listX = new ArrayList<Integer>();
        for (int i=0; i<1400; i+=7) {
            listX.add(i);
        }
        ArrayList<Integer> listY = new ArrayList<Integer>();
        for (int i=0; i<700; i+=3) {
            listY.add(i);
        }
        Collections.shuffle(listX);
        Collections.shuffle(listY);
        
      //Random rand = new Random();
      //int x;
      for (int i=0;i<200;i++){
         //x = rand.nextInt(1400);
         //y = rand.nextInt(800);
         pointList.add(new Points(listX.get(i), listY.get(i)));
         Hold hold = new Hold("hold"+i%7+".png",ROW_HEIGHT,listX.get(i),listY.get(i),0);
         holds.add(hold);
      }
      
      DijkstraTest.buildEdges(pointList);
   }

   @Override
   public void addNotify() {
      super.addNotify();

      animator = new Thread(this);
      animator.start();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (Hold z : holds){
         z.drawHold(g, this);
      }
      //g.drawString(DijkstraTest.printPath(), );
      Toolkit.getDefaultToolkit().sync();
   }

   private void cycle() {

      x += 1;
      y += 1;

      if (y > B_HEIGHT) {

         y = 0;
         x = 0;
      }
   }

   @Override
   public void run() {

      long beforeTime, timeDiff, sleep;

      beforeTime = System.currentTimeMillis();

      while (true) {

         cycle();
         repaint();

         timeDiff = System.currentTimeMillis() - beforeTime;
         sleep = DELAY - timeDiff;

         if (sleep < 0) {
            sleep = 2;
         }

         try {
            Thread.sleep(sleep);
         } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
         }

         beforeTime = System.currentTimeMillis();
      }
   }
   
   @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
      );
   }// </editor-fold>  
   
   }
