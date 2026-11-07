package game;
import java.awt.Color;
class MovingObstacle extends Obstacle{
	private double speed;
	private int leftBound;
	private int rightBound;
	private boolean vertical = false;
	static Color obstacle = new Color(195, 172, 206);
	
	//constructor for a moving obstacle that doesn't use the circleMaker class. uses Point position, int width, int height, double speed, int leftBound, and int rightBound parameters to create a moving obstacle
	public MovingObstacle(Point position, int width, int height, double speed, int leftBound, int rightBound) {
		super(new Polygon(new Point[] {new Point(0,0), new Point(width,0), new Point(width,height), new Point(0,height)},position,0), obstacle);
		
		this.speed = speed;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}
	//constructor for a moving obstacle that does use the circleMaker class. uses Point position, int radius, double speed, int leftBound, and int rightBound parameters to create a moving obstacle
	public MovingObstacle(Point position, int radius, double speed, int leftBound, int rightBound) {
		super(new Polygon(CircleMaker.createCircle(radius, 30), position, 0), obstacle);
		this.speed = speed;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}
	
	//constructor for a moving obstacle that does use the circleMaker class. uses Point position, int radius, double speed, int topBound, and int bottomBound parameters to create a moving obstacle that moves up and down
	public MovingObstacle(Point position, int radius, double speed, int topBound, int bottomBound, boolean vertical) {
		super(new Polygon(CircleMaker.createCircle(radius, 30), position, 0), obstacle);
		this.speed = speed;
		this.leftBound = topBound;
		this.rightBound = bottomBound;
		this.vertical = vertical;
	}
	
	//if the vertical variable is true, move the obstacle up and down within the stated bounds, if false, move the obstacle horizontally within their stated bounds
	@Override
	public void update() {
		if (vertical) {
			shape.position.y += speed;
			
			if (shape.position.y < leftBound || shape.position.y > rightBound) {
				speed = -speed;
			}
		} else {		
			shape.position.x += speed;
		
			if (shape.position.x < leftBound || shape.position.x > rightBound) {
				speed = -speed;
			}
		}
	}
	
}