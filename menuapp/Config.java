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
public class Config {

    public Dish[] getDishes() {
        return new Dish[]{
            new Dish("Joe's Grilled Wild Salmon - Wild alaskan salmon grilled fresh, with a side of "
                    + "lightly grilled greens $", "salmon.jpg", 25.0f),
            new Dish("Rony's Buffalo Chicken Pizza - Fresh brick oven baked, hand tossed pizza, topped"
                    + "with Buffalo chicken strips, parsely, and blue cheese drizzle $", "pizza.jpg", 20.0f),
            new Dish("Max's Spicy Korean Wings - 12 double fried spicy Korean style wings with a "
                    + "side of pickled radishes and creamy corn $", "wings.jpg", 15.0f)
        }; 
   
    }
    
}
