package handlingDatabase;
import java.sql.*;
public class databaseConnection {
	private static Connection conn = null;
	ResultSet rs = null;
	public Connection connectDatabase(){
		String userName = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/replytask?useSSL=false";
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void deletWithId(String tablename,Integer id){
		Connection conn = new databaseConnection().connectDatabase(); 
		String query = "DELETE from "+tablename+" where id='"+id+"';";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public ResultSet getDatawithMultiOption(String tablename,String[] mainrow,String[] searchedValues){
		Connection conn = new databaseConnection().connectDatabase(); 
		String queryhandling = mergeString(mainrow,searchedValues);
		String query = (!queryhandling.equals("")) ? "SELECT * FROM "+tablename+" Where "+queryhandling : "SELECT * FROM "+tablename;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
			
	}
	private String mergeString(String[] mainrow,String[] searchedValues) {
		String querysub = "";
		for(int i = 0; i < searchedValues.length;i++) {
			if (searchedValues[i].equals("")){
				
			}else {
				if(querysub.equals("")) {
					querysub = querysub + mainrow[i]+"='"+searchedValues[i]+"'";
				}else {
					querysub = querysub +" and " +mainrow[i]+"='"+searchedValues[i]+"'";
				}
			}
		}
		return querysub;
	}
	public void updateDatawithID(String tablename,int id,String columname, String newValue) {
		Connection conn = new databaseConnection().connectDatabase();
		String query = "UPDATE "+tablename+" SET "+columname+" = '"+newValue+"' WHERE id = '"+id+"';";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
