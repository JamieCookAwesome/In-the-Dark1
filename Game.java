
import com.sun.source.doctree.SystemPropertyTree;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;


public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, screenHeight, screenWidth;
	private ArrayList<Characters> charList;
	private String screen;
	private Characters player;
	private Enemy enemy;
	private ArrayList<Enemy> enemyList;
	private String awesome;
	private double time;
	private int index;
	private Items flashlight;
	private ArrayList<Items> itemList;

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		charList = setCharList();
		awesome = "Select!";
		screen = "start";
		time = System.currentTimeMillis();

		enemyList = setEnemyList();
		itemList = setItemList();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
		//try{ 
		//customFont =
		//Font.createFont(Font.TRUETYPE_FONT), new
		//File("file");
	}
	public void updateFlashlightPosition() {
		if (flashlight != null && player != null) {
			flashlight.setX(player.getX()+100);
			flashlight.setY(player.getY());
		}
	}
	public ArrayList<Items> setItemList(){
		ArrayList<Items> temp = new ArrayList<Items>();
		temp.add(new RegFlash(200, 600));
		temp.add(new HKFlash(100,400));
		temp.add(new MHD(100, 200));
		temp.add(new Phone(100,800));
		return temp;
	}
	public ArrayList<Characters> setCharList(){
		ArrayList<Characters> temp = new ArrayList<Characters>();
		temp.add(new char1(100,200));
		temp.add(new char2(100,400));
		temp.add(new char3(100,600));
		temp.add(new char4(100,800));
		return temp;
	}
	public ArrayList<Enemy> setEnemyList(){
		ArrayList<Enemy> temp = new ArrayList<Enemy>();
			temp.add(new landTrekker(400,100));
			temp.add(new landTrekker(800,100));
			return temp;
		}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	            repaint();
				Thread.sleep(5);
				
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
	
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		awesome.substring(0,index);

		drawScreens(g2d);
	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	private void drawStartScreen(){

		
	}
	public void updateEnemies() {
		if (flashlight.getPic() == flashlight.getOnImage()) {  // Check if flashlight is on
			// Iterate over all enemies
			for (int i = 0; i < enemyList.size(); i++) {
				Enemy e = enemyList.get(i);
				
				// Calculate the distance between the player and the enemy
				int dx = e.getX() - player.getX();
				int dy = e.getY() - player.getY();
				double distance = Math.sqrt(dx * dx + dy * dy);  // Euclidean distance
				System.out.println("Checking enemy " + i + " at distance: " + distance);
				// Check if the enemy is within the flashlight's radius
				if (distance <= flashlight.getRadius()) {
					// Remove the enemy if within range	
					enemyList.remove(i);
					i--;  // Decrement index to account for the shift in the list
					System.out.println("Enemy removed!");
				}
				 // Calculate the magnitude (distance)
				// double magnitude = Math.sqrt(dx * dx + dy * dy);
            
				 // Normalize the direction (to make the movement consistent)
				 //double dirX = dx / magnitude;  // Unit vector in the x direction
				// double dirY = dy / magnitude;  // Unit vector in the y direction
				 
				 // Move the enemy towards the player at a constant speed
				// double speed = e.getSpeed();  // Get the enemy's speed (you can set this as needed)
				// e.setX(e.getX() + (int)(dirX * speed));
				// e.setY(e.getY() + (int)(dirY * speed));
			}
		}
	}
	public void drawGameScreen(Graphics g2d){
		for (Enemy e: enemyList){
			e.drawEnemy(g2d);
		}
		player.drawChar(g2d);
		flashlight.drawItem(g2d);
		updateFlashlightPosition();

	}
	public void drawScreens(Graphics g2d){
		switch(screen){
			case "start":
			for(Characters c: charList){
				c.drawChar(g2d);
				g2d.drawString("h,j,k,l", 300, 600);
				g2d.drawString(awesome.substring(0,index),100,100);
				if (index<awesome.length()){
				if (System.currentTimeMillis()-time>100){
					time = System.currentTimeMillis();
					index++;
				}
			}
		}
			break;
			case "selection":
			drawSelectScreen(g2d);
			break;
			case "gameplay":
			drawGameScreen(g2d);
			player.move(0, 0, screenWidth, screenHeight);
		}
	}

	public void drawSelectScreen(Graphics g2d){
		player.drawChar(g2d);
		g2d.drawString("You picked "+player.getName(),800,200);
		g2d.drawString("Stamina: "+player.getStam(), 800, 500);
		g2d.drawString("Speed: "+player.getSpeed(), 800, 600);
		g2d.drawString("Flashlight: "+ player.getItems(), 800,700);
	}
	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



//public void attack(){
	//if(player.getWeap() instanceof Ranged){
		//rangedFlash.add(new Ranged(player.getX(),player.getW(), player.getWeapon(), player.getSpeed(), player.getStam(), player.getPic()));
	//}
	//else {

	//}
//}


//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		if (key==72){
			screen="selection";
			player=charList.get(0);
			flashlight=itemList.get(2);
		}
		if (key==74){
			screen="selection";
			player=charList.get(1);
			flashlight=itemList.get(1);
		}
		if (key==75){
			screen="selection";
			player=charList.get(2);
			flashlight=itemList.get(0);
		}
		if (key==76){
			screen="selection";
			player=charList.get(3);
			flashlight=itemList.get(3);
		}
		else if (key==89){
			//key is y
			screen = "gameplay";
		}
		if ((key == 87)&&("gameplay".equals(screen))) {
            //-1
            player.setDy(-1);
        }
        if ((key == 83)&&("gameplay".equals(screen))){
            player.setDy(1);
        }
        if ((key == 65)&&("gameplay".equals(screen))) {
            //-1
            player.setDx(-1);
        }
        if ((key == 68)&&("gameplay".equals(screen))) {
            player.setDx(1);
        }
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		key= e.getKeyCode();

		if (key == 87) {
            player.setDy(0);
        }
        else if (key == 83) {
            player.setDy(0);
        }
        if (key == 65) {
            player.setDx(0);
        }
        else if (key == 68) {
            player.setDx(0);
        }
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//check 2 see if on start screen
		//for loop to check through all mainChars
		//if mousecollision is true
		//player = loop.get(i)
		if (flashlight != null) {
		flashlight.toggle(); 
		}
		updateEnemies();
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at"+ arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
