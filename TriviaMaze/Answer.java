
public class Answer {
	private int answerID;
	private int questionID;
	private String answer;
	
	public Answer(int answerID, int questionID, String answer) {
		super();
		this.answerID = answerID;
		this.questionID = questionID;
		this.answer = answer;
	}
	public Answer() {
		
	}
	public int getAnswerID() {
		return answerID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public String getAnswer() {
		return answer;
	}
	@Override
	public String toString() {
		return answer;
	}
	

}
