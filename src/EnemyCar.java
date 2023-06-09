import java.awt.*;

public class EnemyCar extends DescentObject {
    public int offset;
    public boolean canCollide = true;

    public EnemyCar (int R, int G, int B, int offset) {
        super(R, G, B, 200, -70, 30, 35);
        this.offset = offset;
    }

    public void Draw(Graphics2D g2d) {
        super.Descent(50);
        super.DrawCar(g2d, offset);
    }
}
