import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Score {
    private static int score, highscore, jogadas;

    public static void RecoverFromFile() {
        highscore = FileManager.RecoverFromFile("HighscoreSave");
        jogadas = FileManager.RecoverFromFile("JogadasSave");
    }

    public static void Scored(int amount) {
        score += amount;

        if (score > highscore) {
            highscore = score;
            FileManager.SaveToFile("HighscoreSave", highscore);
        }
    }

    public static int ScoreGained() {
        return score;
    }

    public static void ResetScore() {
        score = 0;
    }

    public static int Highscore()
    {
        return highscore;
    }

    public static int Jogadas() {
        return jogadas;
    }

    public static void Jogada() {
        jogadas += 1;

        FileManager.SaveToFile("JogadasSave", jogadas);
    }
}
