public class Score {
    private static int score, highscore;

    public static void Scored(int amount) {
        score += amount;

        if (score > highscore) {
            highscore = score;
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
}
