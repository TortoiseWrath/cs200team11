package team11project4;

import java.util.Date;

/**
 * 
 * 
 * @author sdgillen
 *
 */
public class BillForServicesController {
	
	private String memberNumber;
	private String providerNumber;
	private String serviceCode;
	public Date dateProvided;
	private int fee;
	private String comments;
	public ChocAnDataCenter db;

	/**
	 * Constructors
	 * Optional parameters
	 * datacenter: an existing ChocAnDataCenter object (will create a new one if not given)
	 * provider: the provider number (can be set with setProvider())
	 */
	public BillForServicesController() {
		db = new ChocAnDataCenter();
		comments = "";
	}
	public BillForServicesController(ChocAnDataCenter datacenter) {
		db = datacenter;
		comments = "";
	}
	public BillForServicesController(String provider) {
		providerNumber = provider;
		db = new ChocAnDataCenter();
		comments = "";
	}
	public BillForServicesController(ChocAnDataCenter datacenter, String provider) {
		providerNumber = provider;
		db = datacenter;
		comments = "";
	}
	
	/**
	 * Sets the member of the provided service to the member with member number n
	 * @param n the member number
	 */
	public void setMember(String n) {
		memberNumber = n;
	}
	
	/**
	 * Sets the provider of the provided service to the provider with provider number n
	 * @param n the provider number
	 */
	public void setProvider(String n) {
		providerNumber = n;
	}

	/**
	 * Sets the service provided to the service with service code n,
	 * then returns information on the service so the user can verify.
	 * @param n thet service code
	 * @return the name of the service if it exists
	 * @throws IllegalArgumentException if the service does not exist
	 */
	public String setService(String n) throws IllegalArgumentException {
		ChocAnService s = db.getService(n);
		if(s == null) {
			//If service does not exist
			throw new IllegalArgumentException();
		}
		
		//If service exists
		serviceCode = n;
		fee = s.serviceFee;
		return s.serviceName; //Return the name of the service
	}
	
	/**
	 * Sets the comments.
	 * This is optional; if not called, the comments field will remain empty. 
	 * @param c the comments
	 */
	public void setComments(String c) {
		comments = c;
	}
	
	/**
	 * Sets the date the service was provided.
	 * @param d the date on which the service was provided
	 */
	public void setDate(Date d) {
		dateProvided = d;
	}
	
	/**
	 * Creates the provided service record and saves it to the database
	 * This will not update the instance of the database in this object or its parent
	 * so must be the last method called.
	 * After calling this method, create a new database anywhere you need to use one.
	 * @return true on success, false on failure
	 */
	public Boolean write() {
		if (dateProvided == null) {
			System.err.println("Warning: date on which service provided not specified. Setting to today.");
			dateProvided = new Date();
		}
		ProvidedServiceRecord record = new ProvidedServiceRecord(dateProvided, providerNumber, memberNumber, serviceCode, comments, fee);
		return record.writeRecordToDisk();
	}
}
