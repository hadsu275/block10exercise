package oopd_gu_chalmers.polygons.polygon;

import java.awt.*;

/**
 * Created by Niklas on 2016-01-19.
 */
// TODO: 1e: We want to be able to remove the 'public' modifier
//  for the concrete subclasses, making them package-private,
//  i.e. only available to other classes within the oopd_gu_chalmers.polygons.polygon
//  package. Can you do that now?
class Square extends Polygon {
    public Square(int x, int y) {
        super(x,y);
    }

   @Override
    public void paint(Graphics g){
        g.drawRect(getCenterPoint().x - 10, getCenterPoint().y - 10, 20, 20);
    }
}
