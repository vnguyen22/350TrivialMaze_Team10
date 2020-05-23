
public class Room {
	private boolean exit = false;
	private boolean entrance = true;
	private Door leftDoor = new Door();
	private Door rightDoor = new Door();
	private Door topDoor = new Door();
	private Door bottomDoor = new Door();
	
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
	public Door getLeftDoor() {
		return leftDoor;
	}
	public Door getRightDoor() {
		return rightDoor;
	}
	public Door getTopDoor() {
		return topDoor;
	}
	public Door getBottomDoor() {
		return bottomDoor;
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
