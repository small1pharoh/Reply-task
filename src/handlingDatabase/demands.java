package handlingDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demands {
	ResultSet rs = null;
	databaseConnection database = new databaseConnection();
	
	public void addData(String pickuploc ,String dropoffloc, String earlistpick , String latestdrop, String carfeatures,int userid,int carid) {
		Connection conn = database.connectDatabase();
		String query = "INSERT INTO demands VALUES (NULL, '"+pickuploc+"', '"+dropoffloc+"' , '"+earlistpick+"', '"+latestdrop+"', '"+carfeatures+"', '"+userid+"', '"+carid+"');";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			System.out.println("result"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletWithId(Integer id){
		databaseConnection d = new databaseConnection();
		d.deletWithId("demands", id);
		}
	
	public ResultSet getDatawithMultiOption(String[] searchedValues){
		databaseConnection c = new databaseConnection();
		String[] mainrow = {"id","pickuploc","dropoffloc","earlistpick","latestdrop","carfeatures",
				"userid","carid"};
		rs = c.getDatawithMultiOption("demands",mainrow, searchedValues);
		return rs;
	}
	public void updateDatawithID(int id,String columname, String newValue) {
		databaseConnection c = new databaseConnection();
		c.updateDatawithID("demands", id, columname, newValue);
	}
	

}
