/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamsexplorer;

/**
 *
 * @author csc190
 */
public class Explorer {
    
    protected Point point;
    protected int direction;
    
    
    /**
     * Constructor of Explorer
     * @param p - it's location cannot be null
     * @param direction - an int between 0 to 3. Note macros defined in Point, e.g., Point.EAST
     */
    public Explorer(Point p, int direction){
        this.point = p;
        this.direction = direction;
    }
    
    /**
     * Move forward. If cannot forward, stay at the current point.
     */
    public void forward(){
        if (this.point != null){
            Point nb = this.point.arrNeighbors[this.direction];
            if (nb != null){
                this.point = nb; 
            }
        }
    }
    
    /**
     * Move backward and reverse its current direction. If cannot move, stay at the current point.
     */
    public void backward(){
        int revDirection = (this.direction + 2) % 4;
        
        if (this.point != null){
            Point nb = this.point.arrNeighbors[revDirection];
            if (nb != null){
                this.point = nb;
            }
        }
    }
    
    /**
     * Rotate clock-wise for 90 degrees.
     */
    public void rotateRight(){
        this.direction = (this.direction - 1 + 4) % 4;
    }
    
    /**
     * Rotate 90 degrees anti-clockwise
     */
    public void rotateLeft(){
        this.direction = (this.direction + 1) % 4;
    }
    
    /**
     * Set the location of explorer to the given point.
     * @param p - cannot be null
     */
    public void setPoint(Point p){
        this.point = p;        
    }
    
    /**
     * Set the direction to the given number in [0,3].
     * Note Point has the macro definitions of the 4 directions.
     * @param v 
     */
    public void setDirection(int v){
        this.direction = v;
    }
    
    /**
     * The current point of the explorer.
     * @return the current point
     */
    public Point getPoint(){
        return this.point;
    }
    
    /**
     * Return the current direction. 
     * @return an int in range [0,3]
     */
    public int getDirection(){
        return this.direction;
    }
}
