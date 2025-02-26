package oopd_gu_chalmers.polygons.polygon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niklas on 2016-01-19.
 */
public abstract class Polygon extends JComponent{
    private Point centerPoint;

    Polygon(Point center){
        this.centerPoint = center;
    }
    Polygon(int x, int y){
        this(new Point(x,y));
    }

    public void updateCenter(int x, int y){
        this.centerPoint = new Point(x,y);
    }

    @Override
    public abstract void paint(Graphics g)//paint
    ;

    public Point getCenterPoint() {
        return centerPoint;
    }
}
