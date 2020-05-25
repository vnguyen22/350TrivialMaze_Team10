  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.Map;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;  

public class Main {

	public static void main(String[] args) throws Exception {
		
		/*QuestionManager qManager = new QuestionManager();
		ArrayList<Question> questionList = qManager.getQuestionList();
		
		ChoiceManager cManager = new ChoiceManager();

		for(Question q : questionList) {
			int question_id = q.getQuestionID();
			ArrayList<Choice> choiceListByQuestionID = cManager.getChoiceListByQuestionID(question_id);
			System.out.println(q.getQuestion_text());
			//System.out.println(choiceListByQuestionID);
			for(int i=0; i< choiceListByQuestionID.size();i++) {
				System.out.println(choiceListByQuestionID.get(i));
			}
		} */
		
        Object obj = new JSONParser().parse(new FileReader("mcSet1.json")); 
        JSONObject jo = (JSONObject) obj; 
        
        JSONArray ja = (JSONArray) jo.get("results"); 
        
     /*   for(int i=0; i < ja.size();i++) {
        	JSONObject object = (JSONObject)ja.get(i);
        	
        	String question_text = (String) object.get("question");
        	System.out.println("\n"+ i +". "+question_text);
        	System.out.println((String) object.get("correct_answer"));

        	
        	 JSONArray arr = (JSONArray) object.get("incorrect_answers"); 
             for (int j = 0; j < arr.size(); j++) {
                 System.out.println( arr.get(j));
             }
        	*/
        
        	
        //	int question_id = insertQuestion(question_text, 102);
        //	insertAnswer(question_id, (String) object.get("correct_answer"));
             
     /*       String question_text = (String) object.get("question");
         	int question_id = insertQuestion(question_text, 103);
         	insertAnswer(question_id, (String) object.get("correct_answer"));

         	
         	 JSONArray arr = (JSONArray) object.get("incorrect_answers"); 
              for (int j = 0; j < arr.size(); j++) {
                  insertChoice(question_id, (String) object.get("correct_answer"));
                  insertChoice(question_id, (String) arr.get(j));
              } 
             
        }  */
        
        QuestionGenerator qG= new QuestionGenerator();
        Question q = qG.generate();
        System.out.println(q);
		
        
        ChoiceManager cManager = new ChoiceManager();
		int question_id = q.getQuestionID();
		int category_id = q.getCategory_id();
		if(category_id == 102 ) {  //true false
			System.out.println("True");
			System.out.println("False");
			} else if (category_id == 103) { //multiple
				ArrayList<Choice> choiceListByQuestionID = cManager.getChoiceListByQuestionID(question_id);
				for(int i=0; i< choiceListByQuestionID.size();i++) {
					System.out.println(choiceListByQuestionID.get(i));
				}
			} else { //short ans
				//input user
			}

        
     //   System.out.println(qG.getQuestionList().size());
     //   System.out.println(qG.getQuestionUsed().size());
	}
	
	public static int insertQuestion(String question_text, int category_id)  {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
   		 String sql = "INSERT INTO Question(question_text,category_id) VALUES(?,?)";
   		int generatedKey = 0;
        try{
   		 conn = SqliteConnection.Connector();
   		 pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
   		 pstmt.setString(1, question_text);
   		 pstmt.setInt(2, category_id);
   		 pstmt.executeUpdate();

	   		ResultSet rs = pstmt.getGeneratedKeys(); 		
	   		if (rs.next()) {
	   		    generatedKey = rs.getInt(1);
	   		    
	   		}	   		
   		conn.close();
   		pstmt.close();
        }catch(Exception e) {
        	e.getMessage();
        }
        return generatedKey;
		
	}
	public static void insertAnswer(int question_id, String answer) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
   		 String sql = "INSERT INTO Answer(question_id, answer) VALUES(?,?)";
        try{
   		 conn = SqliteConnection.Connector();
   		 pstmt = conn.prepareStatement(sql);
   		 pstmt.setInt(1, question_id);
   		 pstmt.setString(2, answer);
   		 pstmt.executeUpdate();

   		 
   		conn.close();
   		pstmt.close();
        }catch(Exception e) {
        	e.getMessage();
        }
		
	}
	public static void insertChoice(int question_id, String choice) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
   		 String sql = "INSERT INTO Choices(question_id, choice) VALUES(?,?)";
        try{
   		 conn = SqliteConnection.Connector();
   		 pstmt = conn.prepareStatement(sql);
   		 pstmt.setInt(1, question_id);
   		 pstmt.setString(2, choice);
   		 pstmt.executeUpdate();

   		 
   		conn.close();
   		pstmt.close();
        }catch(Exception e) {
        	e.getMessage();
        }
	}

}