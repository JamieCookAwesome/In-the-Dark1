import javax.swing.ImageIcon;


public class HKFlash extends Items {
    public HKFlash(){
        super();
    }
    public HKFlash(int x, int y){
        super(x,y,600,200, 12, 600, 20, new ImageIcon("HKflashlight1.png"),new ImageIcon("HKflashlight2.png"), "Hello Kitty Flashlight");
    }
    public String toString(){
        return "Hello Kitty Flashlight ";
    }
}
