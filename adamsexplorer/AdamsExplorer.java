/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamsexplorer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class AdamsExplorer extends Application {

    protected Map map;
    protected KeyboardController kc;
    protected MouseController mc;
    protected MapView mv;
    protected VRView vv;

    /**
     * Creates one ImageView for VRView and one Canvas for MapView.
     * Creates VRController, MouseController, MapView and VRView.
     * Set up mouse and keyboard events.
     * Width: 800, Height: 600.
     * Each view is 400*600.
     * @param primaryStage 
     */
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gp = new GridPane();
        
        Scene sc = new Scene(gp);
        ImageView iv = new ImageView();
        
        iv.setFitHeight(600);
        iv.setFitWidth(400);
        
        Canvas cv = new Canvas();
        cv.setWidth(400);
        cv.setHeight(600);
        
        gp.add(iv,0,0);
        gp.add(cv,1,0);
        
        primaryStage.setScene(sc);
        
        //2
        this.map = new Map();
        map.loadFromFile("none"); //ADD filepath? 
        
        this.mv = new MapView(cv);
        this.vv = new VRView(iv);
        this.mc = new MouseController(map, mv);
        this.kc = new KeyboardController(map, vv);
        
        this.map.register(this.mc);
        this.map.register(this.kc);
        
        //3
        sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                KeyCode code = event.getCode();
                
                if (code == KeyCode.UP){
                    kc.handleKey(KeyboardController.KEY.UP);
                }
                if (code == KeyCode.DOWN){
                    kc.handleKey(KeyboardController.KEY.DOWN);
                } 
                if (code == KeyCode.LEFT){
                    kc.handleKey(KeyboardController.KEY.LEFT);
                }
                if (code == KeyCode.RIGHT){
                    kc.handleKey(KeyboardController.KEY.RIGHT);
                }
            }                    
        });
        primaryStage.show();
        this.map.updateAll();
        
        //4
        cv.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                mc.handleMouse(event.getX(), event.getY());
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
