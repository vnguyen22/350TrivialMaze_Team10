import java.util.Random;
import java.util.ArrayList;
//TODO Entrance and exit cannot spawn on each other. 
//TODO Exit only has 10% chance of spawning withing 1 square of the entrance
public class Maze {
	private Room[][] maze;
	private Room entrance = new Room();
	private Room exit = new Room();
	private int exitY;
	private int exitX;
	private int entranceY;
	private int entranceX;
	private int mazeSizeX;
	private int mazeSizeY;
	private Player player;
	
	public Maze(int sizeX, int sizeY) {
		if(sizeX > 10 || sizeY > 10 || sizeX < 2 || sizeY < 2) {
			throw new IllegalArgumentException("Maximum Size of Maze is 10X10 Minimum Size is 2x2");
		}
		this.mazeSizeX = sizeX;
		this.mazeSizeY = sizeY;
		this.generateEntranceAndExit();
		maze = new Room[sizeX][sizeY];
		
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				if(entranceX == j && entranceY == i) {
					entrance.setEntrance(true);
					maze[i][j] = entrance;
				}
				else if(exitX == j && exitY == i) {
					exit.setExit(true);
					maze[i][j] = exit;
				}
				else {
					maze[i][j] = new Room();
				}
			}
		}
		this.player = new Player(entranceX, entranceY);
	}
	public Room getPlayersRoom() {
		return maze[player.getPosX()][player.getPosY()];
	}
	
	//This simply generates random numbers for the entrance and exit locations that cannot complete. 
	private void generateEntranceAndExit() {
		ArrayList<Integer> randListY = new ArrayList<Integer>(mazeSizeY);
		ArrayList<Integer> randListX = new ArrayList<Integer>(mazeSizeX);
		
		for(int i = 1; i <= mazeSizeX - 1; i++) {
			randListX.add(i);
		}
		
		for(int i = 1; i <= mazeSizeY - 1; i++) {
			randListY.add(i);
		}
		Random rand = new Random();
		this.entranceX = randListX.remove(rand.nextInt(randListX.size()));
		this.entranceY = randListY.remove(rand.nextInt(randListY.size()));
		this.exitY = randListY.remove(rand.nextInt(randListY.size()));
		this.exitX = randListX.remove(rand.nextInt(randListX.size()));
	}

	public Room getExit() {
		return exit;
	}

	public int getExitX() {
		return exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public int getEntranceY() {
		return entranceY;
	}

	public int getEntranceX() {
		return entranceX;
	}
	public void drawMaze() {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				if(player.getPosX() == j && player.getPosY() == i) {
					System.out.print(" P ");
				}
				else {
					System.out.print(maze[i][j]);
				}
			}
			System.out.println();
		}
	}
	public Player getPlayer() {
		return player;
	}
	
 }
