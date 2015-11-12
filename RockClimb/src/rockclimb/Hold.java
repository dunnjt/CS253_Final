/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author johndunn
 */
public class Hold {

   private Image zombieImage;
   private int xCoordinate;
   private int yCoordinate;
   private int movementRate;

   public Hold(String imageFileName, int rowHeight, int xCoordinate, int yCoordinate, int movementRate) {
      loadImage(imageFileName, rowHeight);
      this.xCoordinate = xCoordinate;
      this.yCoordinate = yCoordinate;
      this.movementRate = movementRate;
   }

   private void loadImage(String imageFileName, int rowHeight) {
      ImageIcon ii = new ImageIcon(imageFileName);
      zombieImage = ii.getImage();
      zombieImage = zombieImage.getScaledInstance(-1, rowHeight, -1);
   }

   public void drawHold(Graphics g, JPanel target) {
      xCoordinate -= movementRate;
      g.drawImage(zombieImage, xCoordinate, yCoordinate, target);
   }
}
