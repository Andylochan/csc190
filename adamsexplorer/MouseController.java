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
public class MouseController implements IController {

    protected Map map;
    protected IView view;

    /**
     * Constructor. Needs the map as model and view to draw model.
     * @param map
     * @param view 
     */
    public MouseController(Map map, IView view) {
        this.map = map;
        this.view = view;
    }

    /**
     * Make sure that the view will draw map
     */
    @Override
    public void update() {
        this.view.draw(map);
    }

    /**
     * Handle the mouse operations. x,y are the coordinates relative to the
     * top-left corner of the view.
     * @param x
     * @param y 
     */
    public void handleMouse(double x, double y) {
        //1. check if this is to reset location
        boolean bSetLocation = false;
        for (Point pt : map.arrPoints) {
            double px = pt.x, py = pt.y;
            double dist = Math.sqrt((px - x) * (px - x) + (py - y) * (py - y));
            if (dist < 10) {
                System.out.println("change location");
                map.explorer.setPoint(pt);
                bSetLocation = true;
            }
        }
        if (bSetLocation) {
            this.map.updateAll();
            return;
        }

        //2. otherwise it's to change direction
        Explorer ex = map.getExplorer();
        Point pt = ex.getPoint();
        int direction = 0;
        if (Math.abs(pt.x - x) > Math.abs(pt.y - y)) {//either EAST or WEST
            if (pt.x > x) {
                direction = Point.WEST;
            } else {
                direction = Point.EAST;
            }
        } else {
            if (pt.y > y) {
                direction = Point.NORTH;
            } else {
                direction = Point.SOUTH;
            }
        }
        ex.setDirection(direction);

        //update model
        this.map.updateAll();
    }

}
