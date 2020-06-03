import java.util.ArrayList;

public class Question {
	private int questionID; 
	private String question_text;
	private int category_id;
	
	
	public Question(int questionID, String question_text, int category_id) {
		super();
		this.questionID = questionID;
		this.question_text = question_text;
		this.category_id = category_id;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
	public void displayChoices() {
		int question_id = getQuestionID();
		int category_id = getCategory_id();
		ChoiceManager cManager = new ChoiceManager();
		if(category_id == 102) { //TrueFale question
			System.out.println("True");
			System.out.println("False");
		} else if (category_id ==  103) { //Multiple choice question
			ArrayList<Choice> choiceListByQuestionID = cManager.getChoiceListByQuestionID(question_id);
			for(int i=0; i< choiceListByQuestionID.size();i++)  {
				System.out.println(choiceListByQuestionID.get(i));
			}
			
		} else { //short answer
			//user input only
		}
	}
	
	@Override
	public String toString() {
	/*	return "  QuestionID=" + questionID + ", question_text=" + question_text + ", category_id="
				+ category_id + "\n"; */
		return question_text;
	}
	
	
	
	

}