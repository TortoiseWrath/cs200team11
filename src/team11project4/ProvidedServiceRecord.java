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
		// TODO Auto-generated constructor stub
	}
	
	public Boolean writeRecordToDisk() {
		ChocAnDataCenter db = new ChocAnDataCenter();
		Member oldMember = db.getMember(memberNumber);
		Member newMember = db.getMember(memberNumber);
		return db.updateMember(oldMember, newMember);
	}

}
