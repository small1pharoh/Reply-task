package objects;

public class userObject {
	private int userid;
	private String username;
	private String gender;
	private int age;
	private String state;
	
	
	public userObject(int userid, String username, String gender, int age, String state) {
		super();
		this.userid = userid;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.state = state;
	}


	public int getUserid() {
		return userid;
	}


	public String getUsername() {
		return username;
	}


	public String getGender() {
		return gender;
	}


	public int getAge() {
		return age;
	}


	public String getState() {
		return state;
	}
	
	
}
