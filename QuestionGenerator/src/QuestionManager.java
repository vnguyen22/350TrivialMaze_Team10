import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionManager {
	private ArrayList<Question> questionList = new ArrayList<Question>();
	
	public QuestionManager() {
		Connection conn;
		conn = SqliteConnection.Connector();
		String ques1 = "select question_id, question_text, category_id from Question;";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ques1);

			// loop through the result set
			while (rs.next()) {
				int question_id = rs.getInt("question_id");
				String question_text = rs.getString("question_text");
				int category_id = rs.getInt("category_id");
				Question q = new Question(question_id, question_text, category_id);
				questionList.add(q);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	
}