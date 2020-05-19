import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		Connection conn;
		conn = SqliteConnection.Connector();
		
		QuestionManager qManager = new QuestionManager();
		ArrayList<Question> questionList = qManager.getQuestionList();
		
		ChoiceManager cManager = new ChoiceManager();
	//	ArrayList<Choice> choiceList = cManager.getChoiceList();

		for(Question q : questionList) {
			int question_id = q.getQuestionID();
			ArrayList<Choice> choiceListByQuestionID = cManager.getChoiceListByQuestionID(question_id);
			System.out.println(q.getQuestion_text());
			//System.out.println(choiceListByQuestionID);
			for(int i=0; i< choiceListByQuestionID.size();i++) {
				System.out.println(choiceListByQuestionID.get(i));
			}
		}
	}

	


}
