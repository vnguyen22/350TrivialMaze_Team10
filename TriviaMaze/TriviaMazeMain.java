import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TriviaMazeMain extends Application{

    private static TriviaMenu mStartMenu = new TriviaMenu();
    private static TriviaMaze_Graphic mMazeScreen;
    private static Maze mMaze;
    private static MazeSettings mSettings;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mStartMenu.show();
        mMaze = new Maze(mStartMenu.getRowNum(), mStartMenu.getColNum());
        mMazeScreen = new TriviaMaze_Graphic(mStartMenu.getRowNum(), mStartMenu.getColNum(),
                                            mMaze.getEntranceX(), mMaze.getEntranceY(),
                                            mMaze.getExitX(), mMaze.getExitY());
        mSettings = MazeSettings.createSettings(mMaze.getEntranceX(), mMaze.getEntranceY(),
                                                mStartMenu.getRowNum(), mStartMenu.getColNum(),
                                                mMaze.getExitX(), mMaze.getExitY());
        mMazeScreen.show();
    }
    
    public static TriviaMaze_Graphic getGraphic(){
        return mMazeScreen;
    }
    
    public static void setGraphic(TriviaMaze_Graphic g){
        mMazeScreen = g;
    }
    
    public static TriviaMenu getTriviaMenu(){
        return mStartMenu;
    }
    
    public static Maze getMaze(){
        return mMaze;
    }
    
    public static void setMaze(Maze m){
        mMaze = m;
    }
    
    public static MazeSettings getSettings(){
        return mSettings;
    }
    
    public static void setSettings(MazeSettings s){
        mSettings = s;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}