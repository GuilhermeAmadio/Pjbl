import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends StreetObject {
    private PlayerCollision playerColl;
    public int dir = -1;

    public Player(int R, int G, int B, PlayerCollision playerColl) {
        super(R, G, B, 200, 500, 30, 35);
        this.playerColl = playerColl;
    }

    public void Draw(Graphics2D g2d) {
        super.DrawCar(g2d, 50 * dir);
        playerColl.DrawCar(g2d, 50 * playerColl.dir);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { dir = -1; playerColl.dir = 1; break; }
            case KeyEvent.VK_RIGHT: { dir = 1; playerColl.dir = -1; break; }
        }
    }
}
