package team11project4;

public class Service {
	
	public String serviceCode;
	public String serviceName;
	public int serviceFee;

	/**
	 * A constructor for creating a new service object. Requires a string for the service's code and name.
	 * Also requires an int for the service's fee.
	 * 
	 * @param code	A string representing the service's code
	 * @param name	A string representing the service's name
	 * @param fee	An int representing the services's fee
	 */
	public Service(String code, String name, int fee) {
		this.serviceCode = code;
		this.serviceName = name;
		this.serviceFee = fee;
	}

}
