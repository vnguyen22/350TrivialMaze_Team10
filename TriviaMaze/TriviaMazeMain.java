import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TriviaMazeMain extends Application{

    private static TriviaMenu startMenu = new TriviaMenu();
    private static TriviaMaze_Graphic mazeScreen;
    private Maze theMaze;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startMenu.show();
        theMaze = new Maze(startMenu.getRowNum(), startMenu.getColNum());
        mazeScreen = new TriviaMaze_Graphic(startMenu.getRowNum(), startMenu.getColNum(),
                                            theMaze.getPlayer().getPosX(), theMaze.getPlayer().getPosY());
        mazeScreen.show();
        mazeScreen.getScene().setOnKeyPressed(keyEvent -> onKeyPressed(keyEvent));

    }
    public static void main(String[] args) {
        launch(args);
    }
    
    private void onKeyPressed(KeyEvent keyEvent) {
        switch(keyEvent.getCode()){
            case UP:
                mazeScreen.setLabel("Direction: Up");
                break;
            case DOWN:
                mazeScreen.setLabel("Direction: Down");
                break;
            case LEFT:
                mazeScreen.setLabel("Direction: Left");
                break;
            case RIGHT:
                mazeScreen.setLabel("Direction: Right");
                break;
        }
    }
}