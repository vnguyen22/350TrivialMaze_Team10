package TriviaMenu;

import java.io.Serializable;

public class MazeSettings implements Serializable{
    
    private int playerPosX, playerPosY, mazeNumRow, mazeNumCol;
    
    private static MazeSettings mazeSettings;

    private MazeSettings(int x, int y, int row, int col){
        this.playerPosX = x;
        this.playerPosY = y;
        this.mazeNumRow = row;
        this.mazeNumCol = col;
    }

    public static MazeSettings createSettings(int x, int y, int row, int col){
        if (mazeSettings == null){
            mazeSettings = new MazeSettings(x, y, row, col);
            return mazeSettings;
        }
        else {
            return mazeSettings;
        }
    }

}
