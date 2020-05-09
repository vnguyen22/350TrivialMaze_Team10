import java.util.Random;

public class Maze {
	private Room[][] maze;
	private Room entrance;
	private Room exit;
	
	public Maze(int sizeX, int sizeY) {
		Random r = new Random();
		int entranceX = r.nextInt(sizeX);
		int entranceY = r.nextInt(sizeY);
		int exitX = r.nextInt(sizeX);
		int exitY = r.nextInt(sizeY);
		
		maze = new Room[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				if(entranceX == j && entranceY == i) {
					entrance.setEntrance(true);
					maze[i][j] = entrance;
				}
				else if(exitX == j && exitY == i) {
					entrance.setExit(true);
					maze[i][j] = exit;
				}
				else {
					maze[i][j] = new Room();
				}
			}
		}
	}
	
 }
