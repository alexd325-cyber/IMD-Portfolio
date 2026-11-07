package game;
import java.awt.*;
abstract class Obstacle extends GameObject {
   //constructor that uses the super class to create an obstacle of Polygon shape and Color color
   public Obstacle (Polygon shape, Color color) {
	   super(shape, color);
   }
  
   // returns the polygon
   public Polygon getPolygon() {
       return shape;
   }
 
   // draws shape based on color and polygon points
   public void draw(Graphics brush) {
       Point[] points = shape.getPoints();
       int[] xPoints = new int[points.length];
       int[] yPoints = new int[points.length];
       for(int i=0;i<points.length;i++){
           xPoints[i] = (int)points[i].x;
           yPoints[i] = (int)points[i].y;
       }
       brush.setColor(color);
       brush.fillPolygon(xPoints,yPoints,points.length);
   }
}