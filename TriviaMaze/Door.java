

public class Door implements Serializable{
	private boolean permaLocked;
	private boolean Locked;
	private String answer;
	public Door() {
		this.Locked = true;
	}
	public boolean isLocked() {
		return this.Locked;
	}
	public void setLocked() {
		this.Locked = true;
	}
	public void setUnlocked() {
		this.Locked = false;
	}
	public boolean isPermaLocked() {
		return permaLocked;
	}
	public void setPermaLocked(boolean permaLocked) {
		this.permaLocked = permaLocked;
	}
	public String getQuestion() {
		if(this.isLocked()) {
			this.answer = "abc";
			return "Question PlaceHolder";
		}
		else {
			return "You may pass";
		}
	}
	public boolean answerQustion(String ans) {
		if(ans.contentEquals(answer)) {
			return true;
		}
		else {
			return false;
		}
	}
}
