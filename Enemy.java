import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Enemy {
    private int x,y,w,h,speed,dx,dy;
    private ImageIcon pic;
    private String name;
    //chek for mouse colission
    public Enemy(){
        x=0;
        y=0;
        w=0;
        h=0;
        speed=0;
        dx=0;
        dy=0;
        pic = new ImageIcon();
        name = "";
    }

    public Enemy(int xV, int yV, int width, int height, int sp, ImageIcon p, String nameV){
        x=xV;
        y=yV;
        w=width;
        h=height;
        speed=sp;
        pic=p;
        dx=0;
        dy=0;
        name = nameV;
    }

    public void drawEnemy(Graphics g2d){
        g2d.drawImage(pic.getImage(),x,y,w,h, null);
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
}
