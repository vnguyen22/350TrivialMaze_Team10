import java.util.*;

import java.io.Serializable;

public class Door implements Serializable{
	private boolean permaLocked;
	private boolean Locked;	
	
	public Door() {
		this.Locked = true;
		this.permaLocked = false;
	}
	public boolean isLocked() {
		return this.Locked;
	}
	public void setLocked() {
		this.Locked = true;
	} 
	
	public boolean isPermaLocked() {
		return this.permaLocked;
	}
	public void setPermaLocked(boolean permaLocked) {
		this.permaLocked = permaLocked;
	}
	public Question getQuestion() {

		if(this.isLocked()) {
			QuestionGenerator qGenerator= new QuestionGenerator();
	        Question question = qGenerator.generate();
	        return question;
		}else {
			return null;
		}
	}
	//answerQuestion : compare playerAnswer with the correct answer by question_id matched in the databse. If correct, return tre
	public boolean answerQuestion(int question_id, String playerAnswer) {
		AnswerManager aManager = new AnswerManager();
		Answer correctAns = aManager.getAnswerByQuestionID(question_id);
		if(playerAnswer.equalsIgnoreCase(correctAns.getAnswer())) {
			return true;
		} else {
			return false;
		}
	}
