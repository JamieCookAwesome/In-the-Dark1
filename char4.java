import javax.swing.ImageIcon;

public class char4 extends Characters {
    public char4() {
        super();
    }

    public char4(int x, int y) {
        super(x, y, 200, 200, 15, 5, new ImageIcon("red.png"),"Red", new Phone(x,y));
    }
}
