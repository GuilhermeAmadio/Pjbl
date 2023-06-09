import java.awt.*;

public class StreetSigns extends DescentObject {
    public StreetSigns(int R, int G, int B, int x, int y, int w, int h) {
        super(R, G, B, x, y, w, h);
    }

    public void Draw(Graphics2D g2d) {
        super.Descent(30);
        super.Draw(g2d, 0);
    }
}
