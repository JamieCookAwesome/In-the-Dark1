import javax.swing.ImageIcon;

public class char1 extends Characters{
    public char1(){
        super();
    }

    public char1(int x, int y){
        super(x,y,200,200,5,2,new ImageIcon("blue.png"),"Blue", new MHD(x,y));
    }
}
