package userInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class inputVerification {

	public inputVerification() {
		super();
	}

	public String loginButton(String username) {
		String x = (username.equals("")) ? "Username can not be empty": "1" ;
		return x;
	}
	
	public String registerButton(String username, String gender, String age) {
		String x = (username.equals("")) ? "Username can not be empty": "1" ;
		if (x != "1") return x ;
		x = (gender.equals("")) ? "gender can not be empty": "1" ;
		if (x != "1") return x ;
		x = (age.equals("")) ? "age can not be empty": "1" ;
		if (x != "1") return x ;
		try{Integer.parseInt(age);}	catch(NumberFormatException e){return "age should be a number";}
		return x;
		}
	
	public String updateuserinfoButtom(String newage) {
		if (!newage.equals(""))
			try{Integer.parseInt(newage);}	catch(NumberFormatException e){return "age should be a number";}
		return "1";
	}
	
	public String bookButton(String sercarcurrloc, String sercardroploc, String sercarpicktime, String sercardroptime,String carid) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String x = (sercarcurrloc.equals("")) ? "Pickup location can not be empty": "1" ;
		if (x != "1") return x ;
		x = (sercardroploc.equals("")) ?  "Drop location can not be empty": "1" ;
		if (x != "1") return x ;
		x = (sercarpicktime.equals("")) ? "Pickup time can not be empty": "1" ;
		if (x != "1") return x ;
		try {sdf.parse(sercarpicktime);}catch(ParseException e){x = "Pickup time not valid the correct formate yyyy-MM-dd";}
		if (x != "1") return x ;
		x = (this.comparedate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),sercarpicktime) == 0) ? "Pickup time should not be before/same as current time": "1" ;
		if (x != "1") return x ;
		x = (sercardroptime.equals("")) ? "Drop time can not be empty" : "1" ;
		if (x != "1") return x ;
		try {sdf.parse(sercardroptime);}catch(ParseException e){x = "Drop time not valid the correct formate yyyy-MM-dd";}
		if (x != "1") return x ;
		x = (this.comparedate(sercarpicktime, sercardroptime) == 0) ? "Pickup time should not be after drop time": "1" ;
		if (x != "1") return x ;
		x = (carid.equals("")) ? "Car id can not be empty": "1" ;
		if (x != "1") return x ;
		try{Integer.parseInt(carid);}	catch(NumberFormatException e){x = "Car id should be a number";}
		if (x != "1") return x ;
		return x;
	}
	
	public String removedemButton(String demid) {
		System.out.println("555555555555555555");
		String x = "1";
		System.out.println("This is x= "+x);
		try{Integer.parseInt(demid);}	catch(NumberFormatException e){x = "Demand id should be a number";}
		System.out.println("This is x= "+x);
		return x;
	}
	public String updatedemButton(String updemid,String updropoffloc, String uppicktime, String updroptime) {
		String x = "1" ;
		x = (updemid.equals("")) ? "Demand id can not be empty": "1" ;
		if (x != "1") return x ;
		x = (updropoffloc.equals("")) ? "Drop location can not be empty": "1" ;
		if (x != "1") return x ;
		
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		
		try {sdf.parse(uppicktime);}catch(ParseException e){x = "Pickup time not valid the correct formate yyyy-MM-dd";}
		if (x != "1") return x ;
		x = (this.comparedate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),uppicktime) == 0) ? "Pickup time should not be before/same as current time": "1" ;
		if (x != "1") return x ;
	
	
		try {sdf.parse(updroptime);}catch(ParseException e){x = "Pickup time not valid the correct formate yyyy-MM-dd";}
		if (x != "1") return x ;
		x = (this.comparedate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),updroptime) == 0) ? "Pickup time should not be before/same as current time": "1" ;
		if (x != "1") return x ;
		
		x = (this.comparedate(uppicktime, updroptime) == 0) ? "Pickup time should not be after drop time": "1" ;
		if (x != "1") return x ;
		
		return x;
	}
	public String newCarButton(String carmod, String careng, String carinfot, String cardes, String carcurrloc) {
		String x = "1";
		x = (carmod.equals("")) ? "Car model can not be empty": "1" ;
		if (x != "1") return x ;
		x = (careng.equals("")) ? "Car engine can not be empty": "1" ;
		if (x != "1") return x ;
		x = (cardes.equals("")) ? "Car interiordes can not be empty": "1" ;
		if (x != "1") return x ;
		x = (carcurrloc.equals("")) ? "Car current location can not be empty": "1" ;
		if (x != "1") return x ;
		return x;
	}
	public String removeCarButton(String id) {
		String x = "1";
		try{Integer.parseInt(id);}	catch(NumberFormatException e){x = "Car id should be a number";}
		return x;
	}
	
	public int comparedate(String firstdate,String secanddate) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try {
			Date data1 = sdf.parse(firstdate);
			Date data2 = sdf.parse(secanddate);
			return data1.compareTo(data2) < 0 ? 1 : 0 ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return 0;
	}
	
}
