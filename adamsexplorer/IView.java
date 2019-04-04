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
public interface IView {
    /**
     * Draw the given model
     * @param model - cannot be null
     */
    public void draw(IModel model);
}
