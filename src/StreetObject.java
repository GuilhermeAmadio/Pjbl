import java.awt.*;

abstract public class StreetObject {
    protected int R, G, B;
    protected int x, y, w, h;

    public StreetObject(int R, int G, int B, int x, int y, int w, int h) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void Draw(Graphics2D g2d, int offset) {
        Color color = new Color(R, G, B);
        g2d.setColor(color);
        g2d.fillRect((x - w / 2) + offset , y, w, h);
    }

    void DrawCar(Graphics2D g2d, int offset) {
        Draw(g2d, offset);
        g2d.fillRect((x - w / 2) + offset + w, y + h, w - (w - 15), h - (h - 20));
        g2d.fillRect((x - w / 2) + offset - w + 15, y + h, w - (w - 15), h - (h - 20));
        g2d.fillRect((x - w / 2) + offset - w + 15, y - h + 20, w - (w - 15), h - (h - 20));
        g2d.fillRect((x - w / 2) + offset + w, y - h + 20, w - (w - 15), h - (h - 20));
    }
}
