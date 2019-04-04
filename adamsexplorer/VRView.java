/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamsexplorer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author csc190
 */
public class VRView implements IView{

    protected ImageView iv;
    
    /**
     * Constructor
     * @param iv 
     */
    public VRView(ImageView iv){
        this.iv = iv;
        this.iv.setFitHeight(600);
        this.iv.setFitWidth(400);
    }
    
   
    /**
     * Draw the model. Needs to take out the current point of the
     * explorer and reads its direction to draw the image.
     * @param model 
     */
    @Override
    public void draw(IModel model) {
        FileInputStream fis = null;
        try {
            if(!(model instanceof Map)){
                System.out.println("cannot handle non-map");
                return;
            }   Map map = (Map) model;
            Explorer ex = map.getExplorer();
            Point pt = ex.getPoint();
            String pic = pt.arrPics[ex.getDirection()];
            String path = "images/" + pic;
            fis = new FileInputStream(path);
            Image ig = new Image(fis);
            this.iv.setImage(ig);
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(VRView.class.getName()).log(Level.SEVERE, null, ex1);
        } finally {
            try {
                if(fis!=null) fis.close();
            } catch (IOException ex1) {
                Logger.getLogger(VRView.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
}
