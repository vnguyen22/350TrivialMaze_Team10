package application;

import java.io.Serializable;


/*In order to save game, we need to keep track of player information.
 * Idea: we create a sale single SaveData class implements Serializable and this is not going to act as component in our game.
 *This class can be serialized, which simply means we will be able to save it in a file
 * 
 */

public class PlayerData implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public String usernameField;
	public String passwordField;
//	public float[] playerPositionX;
//	public float[] playerPositionY;
	//Later on we can modify and add more field we can save more information of player as we wish

}
