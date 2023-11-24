package oopd_gu_chalmers.polygons;

import oopd_gu_chalmers.polygons.polygon.*;

import javax.swing.*;
import java.awt.Graphics;
import java.util.*;

public class DrawPolygons extends JComponent{
    public ArrayList<oopd_gu_chalmers.polygons.polygon.Polygon> polygons;
    public boolean direction = true;
    public int ticker = 0;
    public JFrame frame;

    public DrawPolygons(){
        polygons = new ArrayList<>(10);
        // TODO: 1b: Get rid of these constructor calls, and
        //   replace with calls to the new factory methods.
        polygons.add(new Square(50,50));
        polygons.add(new Triangle(100,100));
        polygons.add(new Rectangle(50,150));

    }//constructor

    public void update(){
        ticker++;
        int value = direction ? 10 : -10;
        for (oopd_gu_chalmers.polygons.polygon.Polygon p: polygons){
            p.updateCenter(p.centerPoint.x+value, p.centerPoint.y+value);
        }
        if (ticker > 10) {
            direction = !direction;
            ticker = 0;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        for (oopd_gu_chalmers.polygons.polygon.Polygon currentPolygon : polygons) {
            currentPolygon.paint(g);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        polygons.frame = frame;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);


        try {
            while (true) {
                Thread.sleep(500);
                polygons.update();
            }
        } catch (InterruptedException ignored) {}

    }//main

}//DIT953.polygons.DrawPolygons