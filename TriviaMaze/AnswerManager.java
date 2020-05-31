import java.sql.*;
import java.util.*;
public class AnswerManager {
	private ArrayList<Answer> answerList = new ArrayList<Answer>();
	
	public AnswerManager() {
		Connection conn;
		conn = SqliteConnection.Connector();
		String answer = "select answer_id, question_id, answer from Answer;";
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(answer);
			
			while (rs.next()) {
				int answer_id = rs.getInt("answer_id");
				int question_id = rs.getInt("question_id");
				String answer_text = rs.getString("answer");
				Answer q = new Answer(answer_id, question_id, answer_text);
				answerList.add(q);
				
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}
	public Answer getAnswerByQuestionID(int question_id) {
		Answer ans = new Answer() ;

		for(Answer answer: this.answerList) {
			if(answer.getQuestionID() == question_id) {
				ans = answer;
			}
		}
		return ans;
	}
}
