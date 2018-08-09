package objects;

public class carsObject {
	private int carid;
	private String model;
	private String engine;
	private String infotainment;
	private String interiordes;
	private String curloc;
	private int availability;
	private int distance;
	
	
	public carsObject(int carid, String model, String engine, String infotainment, String interiordes, String curloc,
			int availability, int distance) {
		super();
		this.carid = carid;
		this.model = model;
		this.engine = engine;
		this.infotainment = infotainment;
		this.interiordes = interiordes;
		this.curloc = curloc;
		this.availability = availability;
		this.distance = distance;
	}
	public int getCarid() {
		return carid;
	}
	public String getModel() {
		return model;
	}
	public String getEngine() {
		return engine;
	}
	public String getInfotainment() {
		return infotainment;
	}
	public String getInteriordes() {
		return interiordes;
	}
	public String getCurloc() {
		return curloc;
	}
	public int getAvailability() {
		return availability;
	}
	public int getDistance() {
		return distance;
	}
	
	
}
