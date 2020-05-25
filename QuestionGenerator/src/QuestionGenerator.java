import java.util.*;

public class QuestionGenerator {
	
/*	for every question in n questions,
    display one question */
	private ArrayList<Question> questionList;
	private ArrayList<Question> questionUsed;
	
	public QuestionGenerator() {
		this.questionList = new ArrayList<Question>();
		this.questionUsed = new ArrayList<Question>();
		QuestionManager qManager = new QuestionManager();
		this.questionList = qManager.getQuestionList();
		Collections.shuffle(this.questionList);

		
	}

	public Question generate() {
	    Question q = questionList.get(0);
	    questionList.remove(0);
	    questionUsed.add(q);
	    return q;
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public ArrayList<Question> getQuestionUsed() {
		return questionUsed;
	}

}
