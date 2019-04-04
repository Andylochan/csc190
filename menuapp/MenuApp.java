/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class MenuApp extends Application implements API {
    protected NavController nc;
    protected ImageView iv;
    protected Label lblDesc;
    protected Label lblPrice;
    
    @Override
    public void start(Stage primaryStage) {
        //init
        Config c = new Config();
        this.nc = new NavController(c, this);
        //setup layout 
        GridPane gp = new GridPane();
        this.iv = new ImageView();
        gp.add(iv,0,0,2,1);
        
        this.lblDesc = new Label();
        gp.add(this.lblDesc,0,1,1,1);
        this.lblPrice = new Label();
        gp.add(this.lblPrice,1,1,1,1);
        
       
        Button btn = new Button();
        btn.setText("Prev");
        btn.setOnAction((ActionEvent event) -> {
            nc.movePrev();                   
        });
        gp.add(btn,0,2,1,1);
        
        
        Button btn2 = new Button();
        btn2.setText("Next");
        btn2.setOnAction((ActionEvent event) -> {
            nc.moveNext(); 
        }); 
         gp.add(btn2,1,2,1,1);
        
        StackPane root = new StackPane();
        //root.getChildren().add(btn);  
        
       // gp.getChildren().add(btn);
       // gp.getChildren().add(btn2);
         
        Scene scene = new Scene(gp, 300, 250);
        
        primaryStage.setTitle("Andy's MenuApp!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void drawPic(String picname){
        picname = "pics/" + picname; 
        try {
            FileInputStream fis = new FileInputStream(picname); //java.io import
            Image im = new Image(fis);
            this.iv.setImage(im);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        nc.displayCurDish(); //is this in the right location?
    }

    @Override
    public void drawDesc(String desc){
        this.lblDesc.setText(desc);
    }
    
    @Override
    public void drawPrice(float price){
        this.lblPrice.setText(String.valueOf(price));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
