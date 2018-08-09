package softwareOperation;

import java.sql.ResultSet;
import java.sql.SQLException;


import handlingDatabase.users;
import objects.userObject;

public class authentication {
	
	private userObject userobj;
	users u = new users();
	//searchBook s = new searchBook();
	
	public int login(String username) {
		String[] usernamearray = {"",username,"","","",""};
		ResultSet userfind = u.getDatawithMultiOption(usernamearray);
		try {
			if (userfind.next() ) {
				userobj = new userObject(userfind.getInt("id"),userfind.getString("name"),
						userfind.getString("gender"),userfind.getInt("age"),userfind.getString("state"));
				return 1;
			}else {		
				return 0;	
			}
		} catch (SQLException e) {
			return 0;
		}
	}
	
	
	public void logout() {
		this.setUserobj(null);
	}
	

	
	public String register(String name, String gender, int age) {
		String[] usernamearray = {"",name,"","","",""};
		ResultSet userfind = u.getDatawithMultiOption(usernamearray);
		try {
			if (userfind.next() ) {
				return "Choose anther name users exist";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!gender.equals("Male") && !gender.equals("Female")){
			return "Gender Should be Male or Female";
		}
		if(age < 18  || age > 100 ) {
			return "illogical age shoud be between 18 and 100";
		}
		u.addData(name, gender, age, 0, "normal");
		return "1";
	}
	public String updateUserInfo(String name, String gender, int age) {
		if(!name.equals(this.getUserobj().getUsername()) && !name.equals("")) {
			String[] usernamearray = {"",name,"","","",""};
			ResultSet userfind = u.getDatawithMultiOption(usernamearray);
			try {
				if (userfind.next() ) {
					return "Choose anther name users exist";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			u.updateDatawithID(this.getUserobj().getUserid(), "name", name);
		}
		
		if(!gender.equals(this.getUserobj().getGender()) && !gender.equals("")) {
			if (!gender.equals("Male") && !gender.equals("Female")){
				return "Gender Should be Male or Female";
				
			}
			u.updateDatawithID(this.getUserobj().getUserid(), "gender", gender);
		}
		if(age !=  this.getUserobj().getAge() && age != 0) {
			if(age < 18  || age > 100 ) {
				return "illogical age shoud be between 18 and 100";
			}
			u.updateDatawithID(this.getUserobj().getUserid(), "age",  Integer.toString(age));
		}
		return "1";
	}
	
	
	
	public void deregister(int userid) {
		u.deletWithId(userid);
	}
	
	public userObject getUserobj() {
		return userobj;
	}

	public void setUserobj(userObject userobj) {
		this.userobj = userobj;
	}

	
}
