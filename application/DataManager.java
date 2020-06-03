package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


//DataDataManager class is going to be responsible for saving and loading 
public class DataManager {
	
	
	
	//Java object serialization (writing) is done with the ObjectOutputStream to save data
	public static void savePlayer(Serializable data, String fileName) throws Exception {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
			oos.writeObject(data);
		}
		
	}
	//read Object data from output text file 
	public static Object loadPlayer(String fileName) throws Exception {
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}

}
