import javafx.application.Application;
import javafx.stage.Stage;


public class TriviaMazeMain extends Application {

    private static TriviaMenu startMenu = new TriviaMenu();
    private static TriviaMaze_Graphic mazeScreen;
    private Maze theMaze;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startMenu.start();
        theMaze = new Maze(startMenu.getRowNum(), startMenu.getColNum());
        mazeScreen = new TriviaMaze_Graphic(startMenu.getRowNum(), startMenu.getColNum(),
                                            theMaze.getPlayer().getPosX(), theMaze.getPlayer().getPosY());
        mazeScreen.start(primaryStage);

    }
    public static void main(String[] args) {
        launch(args);
    }
}