package softwareOperation;

import handlingDatabase.cars;

public class admin {
	cars c = new cars();
	public void addNewCar(String model ,String engine, String infotainment, String interiordes, String curloc,Integer availability,Integer distance) {
		
		c.addData(model, engine, infotainment, interiordes, curloc, availability, distance);
		
	}
	
	public void removeCar(int id) {
		c.deletWithId(id);
	}
	
	
}
