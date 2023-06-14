import java.awt.*;
import java.awt.event.KeyEvent;

public class End {
    private Territorio territorio = null;

    public End(Territorio territorio) {
        this.territorio = territorio;
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Verdana", Font.BOLD, 35));
        g2d.drawString("Gameover", 80, 50);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Score: ", 70, 250);
        g2d.setColor(Color.GREEN);
        g2d.drawString("" + Score.ScoreGained(), 210, 250);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Highscore: ", 40, 300);
        g2d.setColor(Color.GREEN);
        g2d.drawString("" + Score.Highscore(), 260, 300);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Aperte ", 60, 500);
        g2d.setColor(Color.RED);
        g2d.drawString("enter", 200, 500);
        g2d.setColor(Color.BLACK);
        g2d.drawString("para voltar", 70, 550);
    }

    public void keyPressed(KeyEvent e) {
        if (territorio.end == true) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER -> {
                    territorio.menu = true;
                    territorio.end = false;
                    Score.ResetScore();
                    break;
                }
            }
        }
    }
}
