package oopd_gu_chalmers.polygons.polygon;

import java.awt.*;

/**
 * Created by Niklas on 2016-01-19.
 */
// TODO: 1e: We want to be able to remove the 'public' modifier
//  for the concrete subclasses, making them package-private,
//  i.e. only available to other classes within the oopd_gu_chalmers.polygons.polygon
//  package. Can you do that now?
class Triangle extends Polygon {
    public Triangle(int x, int y) {
        super(x,y);
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(getCenterPoint().x, getCenterPoint().y-10, getCenterPoint().x-10, getCenterPoint().y+10);
        g.drawLine(getCenterPoint().x-10, getCenterPoint().y+10,
                getCenterPoint().x+10, getCenterPoint().y+10);
        g.drawLine(getCenterPoint().x+10, getCenterPoint().y+10, getCenterPoint().x, getCenterPoint().y-10);
    }
}
