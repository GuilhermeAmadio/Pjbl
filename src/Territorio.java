import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Territorio extends JPanel {
    private Menu menuObj = new Menu(this);
    private End endObj = new End(this);
    private PlayerCollision playerColl = new PlayerCollision(236, 236, 236);
    private Player player = new Player(0, 255, 0, playerColl);
    private Spawner spawner = new Spawner();
    private static final int ALTURA_BARRA_TITULO = 20;
    private JFrame frame;
    public boolean menu = true, game, end;
    public Territorio(String nome) {
        frame = new JFrame(nome);
        frame.add(this);
        frame.setSize(400, 600 + ALTURA_BARRA_TITULO );
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NewLeitorSetas();
    }

    public void NewLeitorSetas() {
        KeyListener listener = new LeitorSetas(player, menuObj, endObj);
        addKeyListener(listener);
        setFocusable(true);
        requestFocus();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        if (menu) {
            menuObj.Draw(g2d);
        }
        else if (game)
        {
            player.Draw(g2d);
            spawner.Draw(g2d);

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Verdana", Font.BOLD, 20));
            g2d.drawString("Score: " + Score.ScoreGained(), 10, 20);

            if (spawner.TestColl(player.x + (50 * player.dir), player.y)) {
                System.out.println("GameOver");

                playerColl = new PlayerCollision(236, 236, 236);
                player = new Player(0, 255, 0, playerColl);
                spawner = new Spawner();

                NewLeitorSetas();

                game = false;
                end = true;
            }

            if (spawner.TestColl(playerColl.x + (50 * playerColl.dir), playerColl.y)) {
               System.out.println("Points!");
                Score.Scored(10);
            }
        }
        else if (end) {
            endObj.Draw(g2d);
        }
    }

    public void jogar() {
        boolean jogando = true;
        while (jogando) {
            repaint();
            try {
                Thread.sleep(300);
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        }
    }
}
