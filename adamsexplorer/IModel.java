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
public interface IModel {
    /**
     * Model should keep track of a list of controllers who will perform update()
     * when the model data changes
     * @param ic - the controller to register for updates.
     */
    public void register(IController ic);
    /**
     * Update all controllers.
     */
    public void updateAll();
}
