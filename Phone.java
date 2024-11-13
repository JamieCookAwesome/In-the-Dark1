import javax.swing.ImageIcon;


public class Phone extends Items {
    public Phone(){
        super();
    }
    public Phone(int x, int y){
        super(x,y,500,200, 12, 500, 20, new ImageIcon("phone1.png"),new ImageIcon("phone2.png"), "Iphone");
    }
    public String toString(){
        return "Iphone ";
    }
}
