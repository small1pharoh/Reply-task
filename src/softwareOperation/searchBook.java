package softwareOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import handlingDatabase.cars;
import handlingDatabase.demands;
import objects.carsObject;
import objects.demandsObject;

public class searchBook {
	cars c = new cars();
	demands d = new demands();
	private carsObject carobj ;
	ArrayList<carsObject> carlist = new ArrayList<>();
	private demandsObject demobj;
	ArrayList<demandsObject> demlist = new ArrayList<>();
	
	
	public void searchCars(String[] searchedItems) {
		carlist.clear();
		ResultSet list = c.getDatawithMultiOption(searchedItems);
		try {
			while (list.next()) {
					carobj = new carsObject(list.getInt("id"),list.getString("model"),list.getString("engine"),
							list.getString("infotainment"),list.getString("interiordes"),list.getString("currloc"),
							list.getInt("availability"),list.getInt("distance"));
					carlist.add(carobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchdemands(String[] searchedItems) {
		demlist.clear();
		ResultSet list = d.getDatawithMultiOption(searchedItems);
		try {
			while (list.next()) {
					demobj = new demandsObject(list.getInt("id"),list.getString("pickuploc"),list.getString("dropoffloc"),
							list.getString("earlistpick"),list.getString("latestdrop"),list.getString("carfeatures"),
							list.getInt("userid"),list.getInt("carid"));
					System.out.println(list.getInt("userid"));
					demlist.add(demobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatedemands(String updemid, String updropoffloc, String uppicktime, String updroptime) {
		String[] columsname = {"dropoffloc","earlistpick","latestdrop"};
		String[] newValues = {updropoffloc,uppicktime,updroptime};
		for(int i = 0; i < columsname.length;i++)
			d.updateDatawithID(Integer.parseInt(updemid), columsname[i], newValues[i]);
	}
	
	
	public void setCarlist(ArrayList<carsObject> carlist) {
		this.carlist = carlist;
	}

	public void bookCars(String pickuploc ,String dropoffloc, String earlistpick , String latestdrop, String carfeatures,int userid,int carid) {
		d.addData(pickuploc, dropoffloc, earlistpick, latestdrop, carfeatures, userid, carid);
		c.updateDatawithID(carid, "availability", "0");
	}
	
	public void removedemands(int id,int carid) {
		d.deletWithId(id);
		c.updateDatawithID(carid, "availability", "1");
	}
	
	public ArrayList<carsObject> getCarlist() {
		return carlist;
	}

	public ArrayList<demandsObject> getDemlist() {
		return demlist;
	}

	public void setDemlist(ArrayList<demandsObject> demlist) {
		this.demlist = demlist;
	}

	

}
