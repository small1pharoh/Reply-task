package objects;

public class demandsObject {
	private int demandid;
	private String pickloc;
	private String droploc;
	private String picktime;
	private String droptime;
	private String carfeat;
	private int userid;
	private int carid;
	public demandsObject(int demandid, String pickloc, String droploc, String picktime, String droptime, String carfeat,
			int userid, int carid) {
		super();
		this.demandid = demandid;
		this.pickloc = pickloc;
		this.droploc = droploc;
		this.picktime = picktime;
		this.droptime = droptime;
		this.carfeat = carfeat;
		this.userid = userid;
		this.carid = carid;
	}
	public int getDemandid() {
		return demandid;
	}
	public String getPickloc() {
		return pickloc;
	}
	public String getDroploc() {
		return droploc;
	}
	public String getPicktime() {
		return picktime;
	}
	public String getDroptime() {
		return droptime;
	}
	public String getCarfeat() {
		return carfeat;
	}
	public int getUserid() {
		return userid;
	}
	public int getCarid() {
		return carid;
	}
	
	
	
}
