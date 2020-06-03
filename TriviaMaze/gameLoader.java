import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class gameLoader {
	public gameLoader() {
		
	}
	public Maze loadMaze() {
		try {
			FileInputStream file = new FileInputStream("Maze.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			Maze m = (Maze)in.readObject();
			file.close();
			in.close();
			return m;
		}
		catch(IOException e) {
			System.out.println("Maze loading failed");
		}
		catch(ClassNotFoundException e) {
			System.out.println("class not found exception in loadMaze");
		}
		return null;
		
	}
}
