import java.io.Serializable;

public class MazeSettings implements Serializable{
    
    private int playerPosX, playerPosY, mazeNumRow, mazeNumCol, exitX, exitY;
    
    private static MazeSettings mazeSettings;

    private MazeSettings(int px, int py, int row, int col, int ex, int ey){
        playerPosX = px; playerPosY = py;
        mazeNumRow = row; mazeNumCol = col;
        exitX = ex; exitY = ey;
        
    }

    public static MazeSettings createSettings(int px, int py, int row, int col, int ex, int ey){
        if (mazeSettings == null){
            mazeSettings = new MazeSettings(px, py, row, col, ex, ey);
            return mazeSettings;
        }
        else {
            return mazeSettings;
        }
    }
    
    public int getPlayerPosX(){
        return playerPosX;
    }
    
    public void setPlayerPosX(int i){
        playerPosX = i;
    }
    
    public int getPlayerPosY(){
        return playerPosY;
    }
    
    public void setPlayerPosY(int i){
        playerPosY = i;
    }
    
    public int getRowNum(){
        return mazeNumRow;
    }
    
    public void setRowNum(int i){
        mazeNumRow = i;
    }
    
    public int getNolNum(){
        return mazeNumCol;
    }
    
    public void setColNum(int i){
        mazeNumCol = i;
    }
    
    public int getExitX(){
        return exitX;
    }
    
    public void setExitX(int x){
        exitX = x;
    }

    public int getExitY(){
        return exitY;
    }
    
    public void setExitY(int y){
        exitY = y;
    }
}
