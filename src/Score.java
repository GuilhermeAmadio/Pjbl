import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Score {
    private static int score, highscore, jogadas;
    private static final String FILE_PATH = "SaveThings.txt";

    public static void ReadHighscoreFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line != null) {
                    highscore = Integer.parseInt(line);
                    System.out.println("Score lido do arquivo: " + highscore);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void SaveHighscoreToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(Integer.toString(score));
            writer.close();
            System.out.println("Score salvo no arquivo: " + highscore);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        linhas.set(2, Integer.toString(highscore));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Scored(int amount) {
        score += amount;

        if (score > highscore) {
            highscore = score;
            //SaveHighscoreToFile();
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

    public static void Jogada() {
        jogadas += 1;
    }
}
