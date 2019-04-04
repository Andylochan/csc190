/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuapp;

/**
 *
 * @author csc190
 */
public class NavController {
    
    protected int curIdx;
    protected Dish[] arrDishes;
    protected API api;
    protected Config config;
    
    
    public NavController(Config config, API api){
        this.api = api;
        this.arrDishes = config.getDishes();
        this.curIdx = 0;
    }

    
    public void moveNext() {
        if (curIdx < arrDishes.length-1) curIdx++;
        this.displayCurDish();
    }
    
    
    public void movePrev() {
        if (curIdx > 0) curIdx--;
        this.displayCurDish(); 
    }

    public void displayCurDish() {
        Dish dish = this.arrDishes[curIdx];
        api.drawDesc(dish.getDesc());
        api.drawPrice(dish.getPrice());
        api.drawPic(dish.getPic());
    }

}
