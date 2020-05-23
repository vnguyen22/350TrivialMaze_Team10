import java.util.Scanner;



public class MainTester {
	public static void main(String[] args) {
		Maze maze = new Maze(10, 10);
			System.out.println("entX: " + maze.getEntranceX() + " entY: " + maze.getEntranceY());
			System.out.println("exX: " + maze.getExitX() + " exY: " + maze.getExitY());
			Scanner sc = new Scanner(System.in);
			maze.drawMaze();
			while(true) {
				if(maze.getPlayersRoom().isExit()) {
					System.out.println("You Win");
					break;
				}
				else {
					if(sc.hasNextInt()) {
						int i = sc.nextInt();
						if(i == 8) {
							maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()-1);
						}
						else if(i == 5) {
							maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()+1);
						}
						else if(i == 4) {
							maze.getPlayer().movePlayer(maze.getPlayer().getPosX()-1, maze.getPlayer().getPosY());
						}
						else if(i == 6) {
							maze.getPlayer().movePlayer(maze.getPlayer().getPosX()+1, maze.getPlayer().getPosY());
						}
					}
				}
				maze.drawMaze();
			}
	}
}
