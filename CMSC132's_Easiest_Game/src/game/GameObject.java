package game;
import java.awt.*;
public class GameObject implements Collidable{
	protected Polygon shape;
	protected Color color;
	
	//creates a gameobject by instantiating the shape and color variables using the Polygon and Color parameters
	public GameObject(Polygon obj, Color color) {
		this.shape = obj;
		this.color = color;
	}
	
	//returns the shape
	public Polygon getShape() {
		return shape;
	}
	
	//method is implemented in other classes
	public void update() {
	}
	
	//draws the object
	public void draw(Graphics brush) {
		Point[] points = shape.getPoints();
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].getX();
			yPoints[i] = (int) points[i].getY();
		}
		brush.setColor(color);
		brush.fillPolygon(xPoints, yPoints, points.length);
	}
	
	//returns true of the object collides with the Point parameter
	@Override
	public boolean collidesWith(Point p) {
	    return shape.contains(p);
	}
}