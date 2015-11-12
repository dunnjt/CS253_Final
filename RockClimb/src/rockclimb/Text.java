/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

/**
 *
 * @author johndunn
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Text {
    
    public void drawText(String str, int x, int y) {
        g.drawString(str, x, y);
    }
}
