package game;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class CMSC132EasiestGame extends Game {
	
	//make all game objects
	Player player;
	
	StaticObstacle sOstage1a;
	StaticObstacle sOstage1b;
	StaticObstacle sOstage2a;
	StaticObstacle sOstage2b;
	StaticObstacle sOstage3;
	MovingObstacle mOstage1;
	MovingObstacle mOstage2;
	MovingObstacle mOstage3a;
	MovingObstacle mOstage3b;
	MovingObstacle mOstage3c;
	MovingObstacle mOstage3d;
	MovingObstacle mOstage4a;
	MovingObstacle mOstage4b;
	MovingObstacle mOstage4c;
	MovingObstacle mOstage4d;
	
	//make lists for easier updates and redrawing through loops
	ArrayList<Coin> coins = new ArrayList<>();
	ArrayList<GameObject> obstacles = new ArrayList<GameObject>();
	
	//game set up colors
	Color area = new Color(223, 217, 226); //lavender
	Color outline = new Color(42, 127, 98); //jungle teal
	Color safe = new Color(123, 177, 158); //muted teal
	
	//variables for game set up
	int margin = 3;
	int widthMar = 18;
	int heightMar = 40;
	int wallHeight = 29;
	
	//variables for game objects and win screen info
	int circRad = 10;
	double circSpeed = 4;
	int score, fails;
	boolean win = false;
	
  //creates game objects and sets up the layout for the game
  public CMSC132EasiestGame() {
    //game set up
	super("CMSC132's Easiest Game!",600,800);
    player = new Player(300-Player.playerSize,15);
    this.setFocusable(true);
	this.requestFocus();
	addKeyListener(new UserInput(player, this));
	
	//create obstacles (walls and moving circles) sO is static and mO is moving
	sOstage1a = new StaticObstacle(new Point(margin, 80), 301, wallHeight);
	sOstage1b = new StaticObstacle(new Point(450, 80), width-widthMar-450, wallHeight);
	
	sOstage2a = new StaticObstacle(new Point(margin, 150), 151, wallHeight);
	sOstage2b = new StaticObstacle(new Point(200, 150), width-widthMar-200, wallHeight);
	
	sOstage3 = new StaticObstacle(new Point(margin, 370), 451, wallHeight);
	
	
	mOstage1 = new MovingObstacle(new Point(20, 45), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	
	mOstage2 = new MovingObstacle(new Point(width-widthMar-30, 120), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	
	mOstage3a = new MovingObstacle(new Point(20, 275), circRad, circSpeed, 180 + margin, 370 - margin - 2*circRad, true);
	mOstage3b = new MovingObstacle(new Point(170, 275), circRad, circSpeed, 180 + margin, 370 - margin - 2*circRad, true);
	mOstage3c = new MovingObstacle(new Point(320, 275), circRad, circSpeed, 180 + margin, 370 - margin - 2*circRad, true);
	mOstage3d = new MovingObstacle(new Point(470, 275), circRad, circSpeed, 180 + margin, 370 - margin - 2*circRad, true);
	
	mOstage4a = new MovingObstacle(new Point(0, 405), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	mOstage4b = new MovingObstacle(new Point(width-widthMar-30, 455), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	mOstage4c = new MovingObstacle(new Point(0, 505), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	mOstage4d = new MovingObstacle(new Point(width-widthMar-30, 555), circRad, circSpeed, margin, width-widthMar - 20 - margin);
	
	//add all obstacles to the obstacles arraylist
	obstacles.add(sOstage1a);
	obstacles.add(sOstage1b);
	obstacles.add(sOstage2a);
	obstacles.add(sOstage2b);
	obstacles.add(sOstage3);

	obstacles.add(mOstage1);
	obstacles.add(mOstage2);
	obstacles.add(mOstage3a);
	obstacles.add(mOstage3b);
	obstacles.add(mOstage3c);
	obstacles.add(mOstage3d);
	obstacles.add(mOstage4a);
	obstacles.add(mOstage4b);
	obstacles.add(mOstage4c);
	obstacles.add(mOstage4d);
	
	//add all coins to the coins arraylist
	coins.add(new Coin(new Point(20,45)));
	coins.add(new Coin(new Point(365,85)));
	coins.add(new Coin(new Point(width-widthMar - 30 - margin,45)));
	coins.add(new Coin(new Point(20,120)));
	coins.add(new Coin(new Point(168,155)));
	coins.add(new Coin(new Point(width-widthMar - 30 - margin,120)));
	coins.add(new Coin(new Point(95,270)));
	coins.add(new Coin(new Point(245,270)));
	coins.add(new Coin(new Point(395,270)));
	coins.add(new Coin(new Point(545,270)));
	
	coins.add(new Coin(new Point(20, 405)));
    coins.add(new Coin(new Point(20, 455)));
    coins.add(new Coin(new Point(20, 505)));
    coins.add(new Coin(new Point(20, 555)));
    coins.add(new Coin(new Point(560, 405)));
    coins.add(new Coin(new Point(560, 455)));
    coins.add(new Coin(new Point(560, 505)));
    coins.add(new Coin(new Point(560, 555)));
    coins.add(new Coin(new Point(250,455)));
    coins.add(new Coin(new Point(280,455)));
    coins.add(new Coin(new Point(310,455)));
    coins.add(new Coin(new Point(250,485)));
    coins.add(new Coin(new Point(280,485)));
    coins.add(new Coin(new Point(310,485)));
    coins.add(new Coin(new Point(250,515)));
    coins.add(new Coin(new Point(280,515)));
    coins.add(new Coin(new Point(310,515)));
    
    //make a coin move with an ANONYMOUS CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    coins.add(new Coin(new Point(250,200)) {
        double speed = 3;

        @Override
        public void update() {
            getShape().position.x += speed;

            if(getShape().position.x < 0 || getShape().position.x > width - 30) {
                speed = -speed;
            }

            getShape().rotate(10);
        }
    });

	//set the score and fails to 0
	score = 0;
	fails = 0;
  }
	
  // occurs after the player hits a moving obstacle, the player's position is reset to it's starting x and y coordinates
  public void resetPlayer() {
	    player.getShape().position.x = 300 - Player.playerSize;
	    player.getShape().position.y = 15;
	}
  
  //tests to see if the user has won, and tests to see if player has collided with a moving obstacle
  public void update() {

	    if(win) return;

	    Point[] playerPoints = player.getShape().getPoints();

	    //check collision with moving obstacles only    
	    CollisionHandler handler = new CollisionHandler();
	    handler.handlePlayerHits();
	    
     	//if the player object overlaps a coin object, collect the coin, increase the score, and make coin disappear
    	for(int i = 0; i < coins.size(); i++) {
    	    Coin c = coins.get(i);

    	    if(c != null) {
    	        for(Point p : playerPoints) {
    	            if(c.collidesWith(p)) {
    	                player.addScore();
    	                coins.remove(i);   // remove collected coin
    	                i--;               // prevent skipping next coin
    	                break;
    	            }
    	        }
    	    }
    	} 

	    // reached the bottom in the safe zone, enact win condition
	    if(player.getShape().position.y >= 640){
	        win = true;
	    }
	    
	    
	}
    
    //paints the screen
	public void paint(Graphics brush) {
		update();
		
		//draw game screen
    	brush.setColor(outline);
    	brush.fillRect(0,0,width,height);
    	brush.setColor(area);
    	brush.fillPolygon(new int[] {margin, width-widthMar, width-widthMar, margin} , new int[] {margin, margin, height-heightMar, height-heightMar}, 4);
    	brush.setColor(safe);
    	brush.fillPolygon(new int[] {margin, width-widthMar, width-widthMar, margin} , new int[] {margin, margin, wallHeight, wallHeight}, 4);
    	brush.fillPolygon(new int[] {margin, width-widthMar, width-widthMar, margin} , new int[] {height-heightMar-wallHeight, height-heightMar-wallHeight, 650, 650}, 4);     

    	brush.setColor(Color.white);
    	brush.drawString("Score is " + player.getScore(),50, 20);
    	brush.drawString("Fails: " + player.getFails(), 450, 20);
    	
    	// if win is true, display win screen and stop processing
    	if(win){
    	    brush.setColor(safe);
    	    brush.fillRect(0,0,width,height);

    	    brush.setColor(Color.BLACK);
    	    brush.setFont(new Font("Arial", Font.BOLD, 80));
    	    brush.drawString("YOU WIN!", 120, height/2);

    	    brush.setFont(new Font("Arial", Font.BOLD, 40));
    	    brush.drawString("Score: " + player.getScore(), 200, height/2 + 80);
    	    brush.drawString("Fails: " + player.getFails(), 200, height/2 + 130);

    	    return;
    	}
    	
    	//updates and redraws obstacles with a LAMBDA FUNCTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	obstacles.forEach(o -> {
	        o.update();
	        o.draw(brush);
	    });
    	
    	//updates and redraws existing coins with a LAMBDA FUNCTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	coins.forEach(c -> {
       	    c.update();
       	    c.draw(brush);
       	});

    	//drawing the player
    	player.draw(brush);
    	
    	
  }
	//allows for user input on the playerINNER CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public class UserInput implements KeyListener {

		Player player;
	    CMSC132EasiestGame panel;

	    int speed = 5;

	    public UserInput(Player p, CMSC132EasiestGame panel){
	        player = p;
	        this.panel = panel;
	    }
	    
	    public boolean canMove(int dx, int dy){

	        Point[] playerPoints = player.getShape().getPoints();

	        for(Point p : playerPoints){

	            double newX = p.x + dx;
	            double newY = p.y + dy;

	            if(newX < margin || newX > width - widthMar) return false;
	            if(newY < margin || newY > height - heightMar) return false;

	            Point newPoint = new Point(newX,newY);

	            for(GameObject obj : obstacles){
	                if(obj.collidesWith(newPoint)){
	                    return false;
	                }
	            }
	        }

	        return true;
	    }

	    public void keyPressed(KeyEvent e){

	        int key = e.getKeyCode();

	        if(key == KeyEvent.VK_LEFT){
	            if(canMove(-speed,0))
	                player.move(-speed,0);
	        }

	        if(key == KeyEvent.VK_RIGHT){
	            if(canMove(speed,0))
	                player.move(speed,0);
	        }

	        if(key == KeyEvent.VK_UP){
	            if(canMove(0,-speed))
	                player.move(0,-speed);
	        }

	        if(key == KeyEvent.VK_DOWN){
	            if(canMove(0,speed))
	                player.move(0,speed);
	        }

	        panel.repaint();
	    }

	    public void keyReleased(KeyEvent e){}
	    public void keyTyped(KeyEvent e){}
	}
	
	//if player touches a moving obstacle, the fail count is increased and the player is reset
	class CollisionHandler {

	    public void handlePlayerHits() {

	        Point[] playerPoints = player.getShape().getPoints();

	        for(GameObject obj : obstacles){

	            if(obj instanceof MovingObstacle){

	                for(Point p : playerPoints){

	                    if(obj.collidesWith(p)){
	                        player.addFail();
	                        resetPlayer();
	                        return;
	                    }
	                }
	            }
	        }
	    }
	}
  
	public static void main (String[] args) {
   		CMSC132EasiestGame a = new CMSC132EasiestGame();
		a.repaint();
  }
}

