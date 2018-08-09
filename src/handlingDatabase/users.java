package handlingDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class users {
	ResultSet rs = null;
	databaseConnection database = new databaseConnection();
	public void addData(String name ,String gender, int age, int demandNum, String state) {
		Connection conn = database.connectDatabase();
		String query = "INSERT INTO users VALUES (NULL, '"+name+"', '"+gender+"' , '"+age+"', '"+demandNum+"', '"+state+"');";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletWithId(Integer id){
	databaseConnection d = new databaseConnection();
	d.deletWithId("users", id);
	}
	public void updateDatawithID(int id,String columname, String newValue) {
		databaseConnection c = new databaseConnection();
		c.updateDatawithID("users", id, columname, newValue);
	}
	
	public ResultSet getDatawithMultiOption(String[] searchedValues){
		databaseConnection c = new databaseConnection();
		String[] mainrow = {"id","name","gender","age","demandnum","state"};
		rs = c.getDatawithMultiOption("users",mainrow, searchedValues);
		return rs;
	}
	
	

}
