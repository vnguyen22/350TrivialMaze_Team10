import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class gameSaver {
	public gameSaver() {
		
	}
	public void saveMaze(Maze m) {
		try
		{
			FileOutputStream file = new FileOutputStream("Maze.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);			
			out.writeObject(m);
			
			out.close();
			file.close();
		}
		catch(IOException e) {
			System.out.println("Error Saving Maze");
		}
	}
}
