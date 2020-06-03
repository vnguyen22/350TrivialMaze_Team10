import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChoiceManager {
	//ChoiceManager class will put choice database into ArrayList for easy accessing
	private ArrayList<Choice> choiceList = new ArrayList<Choice>();
	
	public ChoiceManager() {
		Connection conn;
		conn = SqliteConnection.Connector();
		String ques1 = "select choice_id, choice, question_id from Choices;";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ques1);

			// loop through the result set
			while (rs.next()) {
				int choice_id = rs.getInt("choice_id");
				String choices = rs.getString("choice");
				int question_id = rs.getInt("question_id");
				Choice choice = new Choice(choice_id,question_id, choices);
				choiceList.add(choice);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<Choice> getChoiceList() {
		return choiceList;
	}
	public ArrayList<Choice> getChoiceListByQuestionID(int question_id) {
		ArrayList<Choice> choiceListByQuestionId = new ArrayList<Choice>();
		for(Choice choice : this.choiceList) {
			if(choice.getQuestion_id() == question_id) {
				choiceListByQuestionId.add(choice);
			}
		}
		return choiceListByQuestionId;
	}

}