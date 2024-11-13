import javax.swing.ImageIcon;

public class char2 extends Characters {
    public char2() {
        super();
    }

    public char2(int x, int y) {
        super(x, y, 200, 200, 20, 1, new ImageIcon("pink.png"),"Pink", new HKFlash(x,y));
    }
}
