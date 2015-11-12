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
public class Points {
    
    private int x;
    private int y;
    
    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public String toString() {  
        return Integer.toString(x) + "," + Integer.toString(y);
    }
}
