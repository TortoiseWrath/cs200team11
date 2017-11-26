package team11project4;

import java.util.Date;

public class ProvidedServiceRecord {
	
	public Date dateAdded;
	public Date dateProvided;
	public String providerNumber;
	public String memberNumber;
	public String serviceCode;
	public String comments;
	public int fee;

	public ProvidedServiceRecord() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean writeRecordToDisk() {
		return false;
	}

}
