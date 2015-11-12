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
public class RouteLines {
    
    private Image image;
    private int dstx1, dsty1, srcx1, srcy1, dstx2, dsty2, srcx2, srcy2;
    
    public RouteLines(String imageFileName, int dstx1, int dsty1, int srcx1, int srcy1) {
      loadImage(imageFileName);
      this.dstx1 = dstx1;
      this.dsty1 = dsty1;
      this.srcx1 = srcx1;
      this.srcy1 = srcy1;
      dstx2 = dstx1+10;
      dsty2 = dsty1+10;
      srcx2 = srcx1+10;
      srcy2 = srcy1+10;
   }

   private void loadImage(String imageFileName) {
      ImageIcon ii = new ImageIcon(imageFileName);
      image = ii.getImage();
   }

   public void drawHold(Graphics g, JPanel target) {
    g.drawImage(image, dstx1, dsty1, dstx2, dsty2, srcx1, srcy1, srcx2, srcy2, target);
   }
}
