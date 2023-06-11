import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu {
    Territorio territorio = null;

    public Menu(Territorio territorio) {
        this.territorio = territorio;
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Verdana", Font.BOLD, 35));
        g2d.drawString("Racing Cars", 70, 50);
        g2d.drawString("Jogo por:", 80, 150);
        g2d.drawString("Guilherme Amadio", 10, 200);
        g2d.drawString("Diogo Zakovicz", 40, 250);

        g2d.drawString("Highscore: " + Score.Highscore(), 40, 350);
        g2d.drawString("Jogadas: " + Score.Jogadas(), 40, 400);

        g2d.drawString("Aperte espaço", 40, 500);
        g2d.drawString("para jogar", 70, 550);
    }

    public void keyPressed(KeyEvent e) {
        if (territorio.menu == true) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE -> {
                    territorio.menu = false;
                    territorio.game = true;
                    Score.Jogada();
                    break;
                }
            }
        }
    }
}
