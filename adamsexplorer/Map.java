/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamsexplorer;

import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class Map implements IModel {

    protected Point[] arrPoints;
    protected Explorer explorer;
    protected String backgroundPic;
    protected ArrayList<IController> arrController = new ArrayList<IController>();

    /**
     * return all Point objects
     * @return an array of point objects
     */
    public Point[] getPoints() {
        return this.arrPoints;
    }

    /**
     * return the explorer
     * @return explorer object
     */
    public Explorer getExplorer() {
        return this.explorer;
    }

    /**
     * Loads from a file and create the Points and explorer
     * Currently, this is a dummy implementation.
     * It creates 7 points and loads their pictures and neighbors.
     * @param filename 
     */
    public void loadFromFile(String filename) {
        //DUMMY function now create 10 ponits
        this.arrPoints = new Point[7];
        for (int i = 0; i < this.arrPoints.length; i++) {
            this.arrPoints[i] = new Point();
        }

        int[] arrX = {160, 50, 160, 300, 50, 160, 160};
        int[] arrY = {530, 350, 350, 350, 180, 180, 60};
        Point[][] arrNeighbors = new Point[][]{
            {null, arrPoints[2], null, null},
            {arrPoints[2], null, null, null},
            {arrPoints[3], arrPoints[5], arrPoints[1], arrPoints[0]},
            {null, null, arrPoints[2], null},
            {arrPoints[5], null, null, null},
            {null, arrPoints[6], arrPoints[4], arrPoints[2]},
            {null, null, null, arrPoints[5]}

        };

        for (int i = 0; i < arrPoints.length; i++) {
            String[] arrPics = new String[4];
            for (int k = 0; k < arrPics.length; k++) {
                arrPics[k] = "p" + String.valueOf(i + 1) + String.valueOf(k + 1) + ".jpg";
            }
            arrPoints[i].set(arrX[i], arrY[i], arrNeighbors[i], arrPics);
        }

        this.explorer = new Explorer(arrPoints[0], Point.NORTH);
    }

    /**
     * Register a controller as the observer of any updates.
     * @param ic - cannot be null
     */
    @Override
    public void register(IController ic) {
        this.arrController.add(ic);
    }

    /**
     * Update all registered controllers
     */
    @Override
    public void updateAll() {
        for (IController ic: this.arrController){
            ic.update();
        }
    }
}
