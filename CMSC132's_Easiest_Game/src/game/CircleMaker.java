package game;
public class CircleMaker {
	
	//constructor that creates a list of Points to be used to create a circular object. uses int radius and int sides parameters
	public static Point[] createCircle(int radius, int sides) {
		Point[] points = new Point[sides];
		for (int i = 0; i < sides; i++) {
			double angle = 2 * Math.PI * i / sides;
			double x = radius * Math.cos(angle);
			double y = radius * Math.sin(angle);
			points[i] = new Point(x, y);
		}
		return points;
	}
}