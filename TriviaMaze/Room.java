
public class Room {
	private boolean exit = false;
	private boolean entrance = true;
	public Room() {
		this.exit = false;
		this.entrance = false;
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
	public String toString() {
		if(this.isEntrance()) {
			return " In";
		}
		if(this.isExit()) {
			return "Out";
		}
		return " X ";
		
	}
}
