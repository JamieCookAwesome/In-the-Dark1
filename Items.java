import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Items {

    //
    private int x,y,width,height, reload, radius, weight;
    private String type;
    private ImageIcon pic;
    private ImageIcon offImage;  // Image when the flashlight is off
    private ImageIcon onImage;
    public Items(){
        x=0;
        y=0;
        width=0;
        height=0;
        reload=0;
        radius=0;
        weight=0;
        pic = new ImageIcon();
        type = "";
    }
    public Items(int xV, int yV, int w, int h, int re, int rad, int we, ImageIcon offImg, ImageIcon onImg, String t){
        x=xV;
        y=yV;
        width=w;
        height=h;
        reload=re;
        radius=rad;
        weight=we;
        offImage = offImg;
        onImage = onImg;
        pic = offImg; 
        type=t;
    }
    public void toggle() {
        if (offImage != null && onImage != null) {
            pic = (pic == offImage) ? onImage : offImage;
        }
    }   
    public void drawItem(Graphics g2d){
        g2d.drawImage(pic.getImage(),x,y,width,height, null);
        
    }
     
    public int getX() {
        return x;
    }
    public ImageIcon getOnImage(){
        return onImage;
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
    public ImageIcon getPic(){
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getReload(){
        return reload;
    }
    public void setReload(int reload){
        this.reload = reload;
    }
    public String getType(){
        return type;
    }

}

