package userInterface;
import java.util.ArrayList;

import objects.carsObject;
import objects.demandsObject;
import objects.userObject;
import softwareOperation.admin;
import softwareOperation.authentication;
import softwareOperation.searchBook;

public class buttonOperation {
	
	authentication aut = new authentication() ;
	searchBook ser = new searchBook();
	userObject userobj = null;
	searchBook s = new searchBook();
	ArrayList<carsObject> carlist = null;
	ArrayList<demandsObject> demlist = null;
	admin adm = new admin();
	
	public buttonOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String loginOperButton(String username) {
		if (this.checkLoginState())
			return "If you want to switch user, you should logout first";
		int r = aut.login(username);
		if (r == 0) return "User Not found";
		userobj = aut.getUserobj();
		return userobj.getUsername() +" is login successfully";
	}
	
	public String logoutOprButton() {
		if (!this.checkLoginState())
			return "You should login first";
		aut.setUserobj(null);
		userobj = null;
		return "1";
	}
	
	public String registerOperButton(String username, String gender, String age) {
		if (this.checkLoginState())
			return "For register you should logout first";
		String r = aut.register(username, gender, Integer.parseInt(age));
		if (r != "1") return r;
		return "New user is added successfully";
	}
	
	public String deregisterOperButton() {
		if (!this.checkLoginState())
			return "You should login first";
		String r = this.showdemOperButton();
		if (!r.equals("")) return "Can not delet user who has a demand"; 
		aut.deregister(userobj.getUserid());
		this.logoutOprButton();
		return "User removed successfully";
	}
	
	public String updateuserinfo(String updateuser,String updategender, String updateage) {
		if (!this.checkLoginState())
			return "You should login first";
		int agetext = (updateage.equals("")) ? 0 : Integer.parseInt(updateage) ;
		String r = aut.updateUserInfo(updateuser,updategender,agetext);
		if (r != "1") return r;
		this.logoutOprButton();
		return "User information are updated successfully relogin with you new information";
	}
	public String search(String sercarid, String sercarmod, String sercareng, String sercarinfot, String sercardes, String sercarcurrloc, String string7, String string8) {
		if (!this.checkLoginState())
			return "You should login first";
		String[] searchitemscars = {sercarid,sercarmod,sercareng,sercarinfot,sercardes,sercarcurrloc,"",""};
		String text = "";
		s.searchCars(searchitemscars);
		carlist = s.getCarlist();
		
		for (carsObject item : carlist) { 
			if(item.getAvailability() == 1)
				text = text + item.getCarid() + " " + item.getModel()+" "+item.getEngine()+" "+item.getAvailability()+"\n";
		}
		
		return text;
	}
	
	public String showdemOperButton() {
		if (!this.checkLoginState())
			return "You should login first";
		String[] searchitemsdems = {"","","","","","",String.valueOf(userobj.getUserid()),""};
		String text = "";
		s.searchdemands(searchitemsdems);
		demlist = s.getDemlist();
		
		for (demandsObject item : demlist) {
			text = text + item.getDemandid()+"  "+item.getCarid() + " " + item.getPickloc()+" "+item.getDroploc()+" "+item.getPicktime()+"\n" ;
		}
		
		return text;

	}
	
	public String bookOperButton(String sercarcurrloc, String sercardroploc, String sercarpicktime, String sercardroptime, String bocarid) {
		if (!this.checkLoginState())
			return "You should login first";
		for (carsObject item : carlist) { 
			if(item.getCarid() == Integer.parseInt(bocarid)) {
				ser.bookCars(item.getCurloc(), sercardroploc, sercarpicktime, sercardroptime,
						item.getInfotainment(),userobj.getUserid(), Integer.parseInt(bocarid));
				return "A new demand is created successfully";
			}
		}
		return "Invalid car ID";
	}
	public String removedemOperButton(String bodemandid) {
		if (!this.checkLoginState())
			return "You should login first";
		String x = "1" ;
		if (userobj.getState().equals("admin")){
			
			String[] searchitemsdems = {"","","","","","","",""};
			
			s.searchdemands(searchitemsdems);
			demlist = s.getDemlist();
			
			for (demandsObject item : demlist) {
				if (item.getDemandid() == Integer.parseInt(bodemandid)) {
					s.removedemands(Integer.parseInt(bodemandid),item.getCarid());
					return "Demand removed";
				}
			}
		}else {
			
			String[] searchitemsdems = {"","","","","","",String.valueOf(userobj.getUserid()),""};
			
			s.searchdemands(searchitemsdems);
			demlist = s.getDemlist();
			
			
			for (demandsObject item : demlist) {
				if (item.getUserid() == userobj.getUserid()  && item.getDemandid() == Integer.parseInt(bodemandid)) {
					s.removedemands(Integer.parseInt(bodemandid),item.getCarid());
					return "Demand removed";
				}
			}
		}
		if (x == "1")
			return "invalid demand Id";
		return x;
	}
	
	public String updatedemOperButton(String updemid, String updropoffloc, String uppicktime, String updroptime) {
		if (!this.checkLoginState())
			return "You should login first";
		String[] searchitemsdems = {"","","","","","",String.valueOf(userobj.getUserid()),""};
		
		s.searchdemands(searchitemsdems);
		demlist = s.getDemlist();
		
		
		for (demandsObject item : demlist) {
			if (item.getUserid() == userobj.getUserid()  && item.getDemandid() == Integer.parseInt(updemid)) {
				s.updatedemands(updemid,updropoffloc,uppicktime,updroptime);
				return "Demand updated successfully";
			}
		}
		return "Invalid demand ID";
	}
	public String newCarOperButton(String carmod, String careng, String carinfot, String cardes, String carcurrloc) {
		if (!this.checkLoginState())
			return "You should login first";
		adm.addNewCar(carmod,careng,carinfot,cardes,carcurrloc,1,0);
		return "New car is added";
	}
	public String removeCarOperButton(String removecarid) {
		if (!this.checkLoginState())
			return "You should login first";
		this.search("", "", "", "", "", "", "", "");
		for (carsObject item : carlist) { 
			if(item.getCarid() == Integer.parseInt(removecarid) && item.getAvailability() == 1) {
				adm.removeCar(Integer.parseInt(removecarid));
				System.out.println("######################################");
				System.out.println("#######   "+item.getCarid()+"      ########");

				return "A car is removed";
			}
		}
		return "Can not delet car who has a demand"; 
	}
	
	private boolean checkLoginState() {
		try {
			userobj.getUserid();
			return true;
		} catch(NullPointerException e) {
		    return false;
		}
		
	}

	public userObject getUserobj() {
		return userobj;
	}

	public ArrayList<carsObject> getCarlist() {
		return carlist;
	}

	public ArrayList<demandsObject> getDemlist() {
		return demlist;
	}
	
	
}
