public class Game {
    public static void main(String[] args) {
        Territorio territorio = new Territorio("Game");
        Score.RecoverFromFile();
        FileManager.ReadFromFile("Estatisticas");

        territorio.jogar();
    }
}