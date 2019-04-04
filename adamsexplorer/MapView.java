/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamsexplorer;

import java.awt.geom.AffineTransform;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

/**
 *
 * @author csc190
 */
public class MapView implements IView {

    protected Canvas canvas;

    /**
     * Needs a canvas object to draw
     * @param canvas 
     */
    public MapView(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Need to convert model to a map object and draw. It first draws the background.png,
     * and then draws all points, and then draws lines between neighboring points,
     * and finally draw the explorer. Note there are 4 pictures available for explorer,
     * e.g., "explorer_east.png"
     * @param model 
     */
    @Override
    public void draw(IModel model) {
        FileInputStream fis = null;
        try {
            Map map = (Map) model;
            GraphicsContext gc = this.canvas.getGraphicsContext2D();
            //1. load the background picture
            gc.clearRect(0, 0, 400, 600);   
            
            //2 ADD BACKGROUND
            fis = new FileInputStream("images/background.png");
            Image bg = new Image(fis);
            gc.drawImage(bg, 0, 0);
            gc.fillOval(130,40, 40, 40); //208
            gc.fillOval(130,510, 40, 40); //200
            gc.fillOval(50,180, 40, 40); //204
            gc.fillOval(50,350, 40, 40); //203
            gc.fillOval(310,350, 40, 40); //212
            
            gc.fillOval(135, 185, 30, 30); //TopMID
            gc.fillOval(135, 355, 30, 30); //BottomMID
                    
            gc.strokeLine(55, 370, 315, 370); //H 203-212
            gc.strokeLine(55, 200, 150, 200); //H 204
            gc.strokeLine(150, 45, 150, 515); //V 208-200
            
            //3. draw the explorer
            Explorer ex = map.getExplorer();
            Point expt = ex.getPoint();
            String [] arrExprPics = new String [] {
                "explorer_east.png", "explorer_north.png",
                "explorer_west.png", "explorer_south.png"
            };
            String pic = arrExprPics[ex.getDirection()];
            int width = 100;
            int x = expt.x - width/2;
            int y = expt.y - width/2;
            fis = new FileInputStream("images/"+pic);
            Image ig2 = new Image(fis);
            gc.drawImage(ig2, x, y, width, width);
           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(MapView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
