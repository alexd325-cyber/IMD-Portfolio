package game;
import java.awt.*;
class Coin extends GameObject{
	
	private static int coinSize = 6;
	
	//constructor that creates a coin object using the circlemaker class
	public Coin(Point position) {
		super(new Polygon(CircleMaker.createCircle(coinSize, 20), position, 0), Color.YELLOW);
	}
	
	//makes the coins rotate
	@Override
	public void update() {
		shape.rotate(coinSize);
	}
	
}