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
							if(maze.getPlayersRoom().getTopDoor().isLocked()) {
								System.out.println(maze.getPlayersRoom().getTopDoor().getQuestion());
								if(maze.getPlayersRoom().getTopDoor().answerQustion(sc.next())) {
									maze.getPlayersRoom().getTopDoor().setUnlocked();
									maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()-1);
									if(maze.getPlayersRoom().isExit()) {
										System.out.println("you win");
										break;
									}
								}
								else {
									maze.getPlayersRoom().getTopDoor().setPermaLocked(true);
									System.out.println("Wrong Answer Door is permaLocked");
								}
							}
							else {
								maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()-1);
							}
							
						}
						else if(i == 5) {
							if(maze.getPlayersRoom().getBottomDoor().isLocked()) {
								System.out.println(maze.getPlayersRoom().getBottomDoor().getQuestion());
								if(maze.getPlayersRoom().getBottomDoor().answerQustion(sc.next())) {
									maze.getPlayersRoom().getBottomDoor().setUnlocked();
									maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()+1);
									if(maze.getPlayersRoom().isExit()) {
										System.out.println("you win");
										break;
									}
								}
								else {
									maze.getPlayersRoom().getBottomDoor().setPermaLocked(true);
									System.out.println("Wrong Answer Door is permaLocked");
								}
							}
							else {
								maze.getPlayer().movePlayer(maze.getPlayer().getPosX(), maze.getPlayer().getPosY()+1);
							}
							
						}
						else if(i == 4) {
							if(maze.getPlayersRoom().getLeftDoor().isLocked()) {
								System.out.println(maze.getPlayersRoom().getLeftDoor().getQuestion());
								if(maze.getPlayersRoom().getLeftDoor().answerQustion(sc.next())) {
									maze.getPlayersRoom().getLeftDoor().setUnlocked();
									maze.getPlayer().movePlayer(maze.getPlayer().getPosX() - 1, maze.getPlayer().getPosY());
								}
								else {
									maze.getPlayersRoom().getLeftDoor().setPermaLocked(true);
									System.out.println("Wrong Answer Door is permaLocked");
								}
							}
							else {
								maze.getPlayer().movePlayer(maze.getPlayer().getPosX() - 1, maze.getPlayer().getPosY());
							}
							
							
						}
						else if(i == 6) {
							if(maze.getPlayersRoom().getRightDoor().isLocked()) {
								System.out.println(maze.getPlayersRoom().getRightDoor().getQuestion());
								if(maze.getPlayersRoom().getRightDoor().answerQustion(sc.next())) {
									maze.getPlayersRoom().getRightDoor().setUnlocked();
									maze.getPlayer().movePlayer(maze.getPlayer().getPosX() + 1, maze.getPlayer().getPosY());
									if(maze.getPlayersRoom().isExit()) {
										System.out.println("you win");
										break;
									}
								}
								else {
									maze.getPlayersRoom().getRightDoor().setPermaLocked(true);
									System.out.println("Wrong Answer Door is permaLocked");
								}
							}
							else {
								maze.getPlayer().movePlayer(maze.getPlayer().getPosX() + 1, maze.getPlayer().getPosY());
							}
							
							
						}
						else if(i == 0) {
							//maze.drawMaze();
							System.out.println();
							gameSaver gs = new gameSaver();
							gs.saveMaze(maze);
							gameLoader gl = new gameLoader();
							maze = gl.loadMaze();
							System.out.println();
							maze.drawMaze();
							System.out.println();
						}
					}
				}
				maze.drawMaze();
				System.out.println(maze.getPlayersRoom().isExit());
				System.out.println();
			}
	}
}
