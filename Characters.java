import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Characters {
    private int x,y,w,h,speed,stam,dx,dy;
    private ImageIcon pic;
    private String name;
    private Items weap;
    //chek for mouse colission
    public Characters(){
        x=0;
        y=0;
        w=0;
        h=0;
        speed=0;
        stam=0;
        dx=0;
        dy=0;
        pic = new ImageIcon();
        name = "";
    }

    public Characters(int xV, int yV, int width, int height, int sp, int st, ImageIcon p, String nameV, Items we){
        x=xV;
        y=yV;
        w=width;
        h=height;
        speed=sp;
        stam=st;
        pic=p;
        dx=0;
        dy=0;
        name = nameV; 
        weap=we;
    }

    public void drawChar(Graphics g2d){
        g2d.drawImage(pic.getImage(),x,y,w,h, null);
    }
    public Items getWeapon(){
        return weap;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }
    public String getName(){
        return name;
    }
    public Items getItems(){
        return weap;
    }
    public void move(int screenW, int screenH, int maxW, int maxH) {
		//thanks for letting me use your move method misha : D
		x+=dx;
		if (x+w>maxW) {
			x=maxW-w;
		}
		else if (x<screenW){
			x=screenW;
		}
		
		y+=dy;
		//
		if (y+h>maxH)
			y=maxH-h;
		else if (y<screenH-(h/2))
			y=screenH-(h/2);
	}
}
