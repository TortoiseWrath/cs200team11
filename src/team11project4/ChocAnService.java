package team11project4;

import java.io.Serializable;

public class ChocAnService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4069702931803051311L;
	
	public String serviceCode = "";
	public String serviceName = "";
	public int serviceFee = -1;

	/**
	 * A constructor for creating a new service object. Requires a string for the service's code and name.
	 * Also requires an int for the service's fee.
	 * 
	 * @param code	A string representing the service's code
	 * @param name	A string representing the service's name
	 * @param fee	An int representing the services's fee
	 */
	public ChocAnService(String code, String name, int fee) {
		serviceCode = code;
		serviceName = name;
		serviceFee = fee;
	}
	
	public ChocAnService() {
		//null
	}
	
	/**
	 * Copy constructor
	 */
	public ChocAnService(ChocAnService s) {
		serviceCode = s.serviceCode;
		serviceName = s.serviceName;
		serviceFee = s.serviceFee;
	}
	
	/**
	 * Equals method
	 */
	public Boolean equals(ChocAnService s) {
		return serviceCode.equals(s.serviceCode) &&
				serviceName.equals(s.serviceName) &&
				serviceFee == s.serviceFee;
	}

}
