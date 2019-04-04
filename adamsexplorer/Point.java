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
public class Point {
    public static final int EAST = 0;
    public static final int NORTH = 1;
    public static final int WEST = 2;
    public static final int SOUTH = 3;
    
    //DATA MEMBERS!
    int x, y;
    Point [] arrNeighbors; //if no neighbor on one direction, set it to null
    String [] arrPics; //4 pictures for EAST, NORTH, WEST, SOUTH
    
    public Point(){
        //do nothing
    }
    
    /**
     * Set the correspoding data members
     * @param x
     * @param y
     * @param neighbors
     * @param pics 
     */
    public void set(int x, int y, Point [] neighbors, String [] pics){
        this.x = x;
        this.y = y;
        this.arrNeighbors = neighbors;
        this.arrPics = pics;
    }
}
