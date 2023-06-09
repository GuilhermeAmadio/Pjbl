import java.awt.*;

public class PlayerCollision extends StreetObject {
    public int dir = 1;
    public PlayerCollision(int R, int G, int B) {
        super(R, G, B, 200, 500, 30, 35);
    }

    public void Draw(Graphics2D g2d) {
        super.DrawCar(g2d, 50 * dir);
    }
}
