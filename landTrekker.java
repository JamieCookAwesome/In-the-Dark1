import javax.swing.ImageIcon;

public class landTrekker extends Enemy {
    public landTrekker(){
        super();
    }
    public String toString(){
        return "Land Trekker";
    }
    public landTrekker(int x, int y){
        super(x,y,350,400,2,new ImageIcon("landtrekker.png"), "Land Trekker");
    }
}
