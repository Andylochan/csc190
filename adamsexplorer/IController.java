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
public interface IController {
    /**
     * All controller have to implement update(). This is used by the model to inform
     * controller that its internal data has changed. The controller can choose
     * to update itself. It MUST call the draw() function of its associated view
     * to redraw model.
     */
    public void update();
}
