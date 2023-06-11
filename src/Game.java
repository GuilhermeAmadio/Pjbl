public class Game {
    //classes: game, lataria (abstrata), player, collision, collision score, enemy, spawnEnemy, score, end/start
    //player e collision score extends collision
    //player e enemy extends lataria (modelo predefinido, muda cor)
    //highscore save
    //menu= nomes, nome do jogo, highscore

    public static void main(String[] args) {
        Territorio territorio = new Territorio("Game");
        //Score.ReadHighscoreFromFile();
        ReadFile.ReadFromFile();

        territorio.jogar();
    }
}