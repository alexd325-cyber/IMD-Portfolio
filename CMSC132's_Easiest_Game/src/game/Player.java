package game;
import java.awt.Color;
public class Player extends GameObject {
	static int playerSize = 10;
	int fails;
	int score;
	
	//constructor to create a player and set the fails and score to 0
	public Player(int startX, int startY){
		super(new Polygon(new Point[]{new Point(0,0), new Point(playerSize,0), new Point(playerSize,playerSize), new Point(0,playerSize)}, new Point(startX, startY), 0), Color.RED);
		fails = 0;
		score = 0;
	}
	
	//moves the player dx spaces on the x axis and dy spaces on the y axis
	public void move(int dx, int dy){
		shape.position.x += dx;
		shape.position.y += dy;
	}
	
	//returns the score
	public int getScore(){
		return score;
	}
	
	//adds one to the score
	public void addScore(){
		score++;
	}
	
	//returns the fails
	public int getFails() {
		return fails;
	}
	
	//adds one to the fails
	public void addFail(){
		fails++;
	}
}