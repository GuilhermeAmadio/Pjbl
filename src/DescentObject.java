import java.awt.*;

abstract public class DescentObject extends StreetObject {
    public boolean remove;
    public DescentObject(int R, int G, int B, int x, int y, int w, int h) {
        super(R, G, B, x, y, w, h);
    }

    void Descent(int amount) {
        super.y += amount;

        if (y >= 650) {
            remove = true;
        }
    }

    abstract void Draw(Graphics2D g2d);
}
