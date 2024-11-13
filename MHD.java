import javax.swing.ImageIcon;


public class MHD extends Items {
    public MHD(){
        super();
    }
    public MHD(int x, int y){
        super(x,y,300,200, 12, 300, 20, new ImageIcon("MHD1.png"), new ImageIcon("MHD2.png"), "MEGAHEAVYDUTY");
    }
    public String toString(){
        return "MEGAHEAVYDUTY ";
    }
}
