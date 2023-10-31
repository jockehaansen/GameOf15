public class GameWindow {

    public GameWindow() {
        TileGenerator t = new TileGenerator();
        t.hasPlayerWon(t.testList(t.game));
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
