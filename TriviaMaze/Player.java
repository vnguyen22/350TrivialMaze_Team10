
public class Player {
	private int posX;
	private int posY;
	public Player(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	public void movePlayer(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		if(posX < 0 || posX > 9) {
			System.out.println("Cannot move in that direction");
		}
		else {
			this.posX = posX;
		}
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		if(posY < 0 || posY > 9) {
			System.out.println("Cannot move in that direction");
		}
		else {
			this.posY = posY;
		}
	}
}
