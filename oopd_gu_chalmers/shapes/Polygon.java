package oopd_gu_chalmers.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2016-02-17.
 */
public abstract class Polygon extends Shape {

    protected Polygon(int x, int y){ super(x,y); }

    public void paint(Graphics g){
        List<Point> corners = getCorners();
        // first and last point should be the same
        corners.add(corners.get(0));
        Point from = null;
        for (Point to : corners){
            if (from != null){
                g.drawLine(from.x, from.y, to.x, to.y);
            }
            from = to;
        }

    }

    protected abstract Point[] calculateOffsetsByScale();

    // TODO: 2: What design pattern does the getCorners() method
    //  make use of, when calling the abstract calculateOffsetsByScale()
    //  method internally?
    private List<Point> getCorners() {
        // Find the data for this particular polygon
        Point center = getCenterPoint();
        Point[] offsets = calculateOffsetsByScale();
        double alpha = Math.toRadians(getRotation());
        // Calculate points based on that data
        return calculateCornerPoints(center, offsets, alpha);
    }

    /* Everything below this point is completely independent of any
    *  particular polygon. You can tell by the fact that the code does not
    *  mention any members (fields or methods) from the object itself.
    *  Hence we have chosen during refactoring to make these parts static. */

    private static List<Point> calculateCornerPoints(Point center, Point[] offsets, double alpha) {
        List<Point> corners = new ArrayList<>(offsets.length) ;
        for (Point pointOffsets : offsets) {
            Point newCorner = calculateCornerPoint(center, pointOffsets, alpha);
            corners.add(newCorner);
        }
        return corners;
    }
    private static Point calculateCornerPoint(Point center, Point offset, double alpha) {
        Point offsetPoint = offsetPointFromCenter(center, offset);
        return rotatePoint(center, alpha, offsetPoint);
    }
    private static Point offsetPointFromCenter(Point center, Point offset) {
        return new Point(center.x+ offset.x, center.y+ offset.y);
    }
    private static Point rotatePoint(Point center, double alpha, Point newCorner) {
        double newX = center.x + (newCorner.x - center.x) * Math.cos(alpha) - (newCorner.y - center.y) * Math.sin(alpha);
        double newY = center.y + (newCorner.x - center.x) * Math.sin(alpha) + (newCorner.y - center.y) * Math.cos(alpha);
        return new Point((int) newX, (int) newY);
    }

}
