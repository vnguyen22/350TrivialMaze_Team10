
public class Room {
	private boolean exit = false;
	private boolean entrance = true;
	public Room() {
		//TODO make a constructor
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	public boolean isEntrance() {
		return entrance;
	}
	public void setEntrance(boolean entrance) {
		this.entrance = entrance;
	}
}
