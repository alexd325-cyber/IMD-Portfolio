package game;
import java.awt.Color;
class StaticObstacle extends Obstacle{
	
	static Color walls = new Color(182, 160, 128);
	
	//constructor that creates a static obstacle using Point position, int width, and int height parameters
	public StaticObstacle(Point position, int width, int height) {
		super(new Polygon(new Point[] {new Point(0,0), new Point(width,0), new Point(width,height), new Point(0,height)},position,0), walls);
	}
	
	//don't need this method for static object
	@Override
	public void update() {
		
	}
	
}