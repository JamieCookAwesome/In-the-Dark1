import javax.swing.ImageIcon;


public class RegFlash extends Items {
    public RegFlash(){
        super();
    }
    public RegFlash(int x, int y){
        super(x,y,300,200, 12, 300, 20, new ImageIcon("regflashlight1.png"), new ImageIcon("regflashlight2.png"), "Regular Flashlight");
    }
    public String toString(){
        return "Regular Flashlight";
    }
}
