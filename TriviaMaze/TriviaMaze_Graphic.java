import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Gingervitis
 */
public class TriviaMaze_Graphic extends Application {
    
    private Canvas mCanvas = new Canvas(500, 500);
    private int rowNum, colNum, playX, playY;

    public TriviaMaze_Graphic(int row, int col, int x, int y){
        this.rowNum = row;
        this.colNum = col;
        this.playX = x; 
        this.playY = y;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(mCanvas);
        this.drawMaze(rowNum, colNum, playX, playY);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Trivia Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void drawMaze(int numCols, int numRows, int playX, int playY){
        GraphicsContext gc = mCanvas.getGraphicsContext2D();
        gc.save();
        gc.translate(mCanvas.getWidth()*0.2, mCanvas.getHeight()*0.2);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2.0);
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                gc.strokeLine(0, 0, 0, 30);
                gc.strokeLine(0, 0, 30, 0);
                gc.strokeLine(30, 0, 30, 30);
                gc.strokeLine(0, 30, 30, 30);
                gc.translate(30, 0);
            }//end j
            gc.translate(-(30*numCols), 30);
        }//end i
        gc.restore();
        gc.translate(playX*30, playY*30);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
