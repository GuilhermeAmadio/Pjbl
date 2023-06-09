import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class LeitorSetas implements KeyListener {
    private Player player;
    private Menu menu;
    private End end;
    public LeitorSetas(Player player, Menu menu, End end) {
        this.player = player;
        this.menu = menu;
        this.end = end;
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        menu.keyPressed(e);
        end.keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
    }
}
