package handlingDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cars {
	
	ResultSet rs = null;
	databaseConnection database = new databaseConnection();
	
	public void addData(String model ,String engine, String infotainment, String interiordes, String curloc,Integer availability,Integer distance) {
		Connection conn = database.connectDatabase();
		String query = "INSERT INTO car VALUES (NULL, '"+model+"', '"+engine+"' , '"+infotainment+"', '"+interiordes+"', '"+curloc+"', '"+availability+"', '"+distance+"');";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletWithId(Integer id){
		databaseConnection d = new databaseConnection();
		d.deletWithId("car", id);
	}
	
	public ResultSet getDatawithMultiOption(String[] searchedValues){
		databaseConnection c = new databaseConnection();
		String[] mainrow = {"id","model","engine","infotainment","interiordes","currloc",
				"availability","distance"};
		rs = c.getDatawithMultiOption("car",mainrow, searchedValues);
		return rs;
	}
	
	public void updateDatawithID(int id,String columname, String newValue) {
		databaseConnection c = new databaseConnection();
		c.updateDatawithID("car", id, columname, newValue);
	}
	
}
