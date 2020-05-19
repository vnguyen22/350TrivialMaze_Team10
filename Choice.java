
public class Choice {
	private int choice_id; 
	private int question_id;
	private String choice;
	
	public Choice(int choice_id, int question_id, String choice) {
		super();
		this.choice_id = choice_id;
		this.question_id = question_id;
		this.choice = choice;
	}

	public int getChoice_id() {
		return choice_id;
	}

	public void setChoice_id(int choice_id) {
		this.choice_id = choice_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	@Override
	public String toString() {
		return choice;
	}
	
	
	
	

}
