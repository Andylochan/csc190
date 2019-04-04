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
public class Dish {
    
    protected String desc, picPath;
    protected float price;
    
    public Dish(String desc, String picPath, float price){
        this.desc = desc;
        this.picPath = picPath;
        this.price = price;
    }    
    
    public String getDesc(){
            return desc;
        }
    
    public String getPic(){
        return picPath;
    }
    
    public float getPrice(){
        return price;
    }
    
}
