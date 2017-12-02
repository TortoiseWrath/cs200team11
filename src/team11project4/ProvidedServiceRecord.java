package team11project4;

import java.io.Serializable;
import java.util.Date;

public class ProvidedServiceRecord implements Serializable {
	
	private static final long serialVersionUID = 2609221788198234892L;
	
	public Date dateAdded = new Date();
	public Date dateProvided;
	public String providerNumber = "";
	public String memberNumber = "";
	public String serviceCode = "";
	public String comments = "";
	public int fee = -1;

	public ProvidedServiceRecord() {
	}
	
	public ProvidedServiceRecord(Date dp, String pn, String mn, String sc, String c, int f) {
		dateProvided = dp;
		providerNumber = pn;
		memberNumber = mn;
		serviceCode = sc;
		comments = c;
		fee = f;
	}
	
	public Boolean writeRecordToDisk() {
		ChocAnDataCenter db = new ChocAnDataCenter();
		
		//Add the service to the member.
		Member m = db.getMember(memberNumber);
		m.providedServices.add(this); //Add the provided service to the list in the database
		
		//Add the service to the provider.
		Provider p = db.getProvider(providerNumber);
		p.providedServices.add(this); //Add the provided service to the list in the database
		
		return db.updateMember(m) && db.updateProvider(p); //update the member and provider in the database
	}
	
	/**
	 * Copy constructor
	 * 
	 */
	public ProvidedServiceRecord(ProvidedServiceRecord r) {
		dateAdded = new Date(r.dateAdded.getTime());
		dateProvided = new Date(r.dateProvided.getTime());
		providerNumber = r.providerNumber;
		memberNumber = r.memberNumber;
		serviceCode = r.serviceCode;
		comments = r.comments;
		fee = r.fee;
	}
	
	/**
	 * Equals method
	 */
	public Boolean equals(ProvidedServiceRecord r) {
		return dateAdded.equals(r.dateAdded) &&
				dateProvided.equals(r.dateProvided) &&
				providerNumber.equals(r.providerNumber) &&
				memberNumber.equals(r.memberNumber) &&
				serviceCode.equals(r.serviceCode) &&
				comments.equals(r.comments) &&
				fee ==r.fee;
	}

}
