package team11project4;

import java.io.Serializable;
import java.util.Date;

public class ProvidedServiceRecord implements Serializable {
	
	private static final long serialVersionUID = 2609221788198234892L;
	
	public Date dateAdded;
	public Date dateProvided;
	public String providerNumber;
	public String memberNumber;
	public String serviceCode;
	public String comments;
	public int fee;

	public ProvidedServiceRecord() {
		dateAdded = new Date();
	}
	
	public ProvidedServiceRecord(Date dp, String pn, String mn, String sc, String c, int f) {
		dateAdded = new Date();
		dateProvided = dp;
		providerNumber = pn;
		memberNumber = mn;
		serviceCode = sc;
		comments = c;
		fee = f;
	}
	
	public Boolean writeRecordToDisk() {
		ChocAnDataCenter db = new ChocAnDataCenter();
		Member m = db.getMember(memberNumber);
		m.providedServices.add(this); //Add the provided service to the list in the database
		return db.updateMember(m); //update the member in the database
	}

}
