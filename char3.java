import javax.swing.ImageIcon;

public class char3 extends Characters {
    public char3() {
        super();
    }

    public char3(int x, int y) {
        super(x, y, 200, 200, 8, 9, new ImageIcon("yellow.png"),"Yellow", new RegFlash(x,y));
    }
}
