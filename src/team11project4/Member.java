package team11project4;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -504491935584440369L;

	public enum MemberStatus {
		ACTIVE, SUSPENDED
	}

	public String memberNumber;
	public String memberName;
	public MemberStatus memberStatus;
	public String memberAddress;
	public String memberCity;
	public String memberState;
	public String memberZip;
	public ArrayList<ProvidedServiceRecord> providedServices;

	/**
	 * Constructor for creating new a new member object. Requires a string for each of the member's name,
	 * address, city, state, and zip code. Also requires a MemberStatus type for the member's status.
	 * 
	 * @param number	A string representing the member's unique number
	 * @param name		A string representing the member's name
	 * @param address	A string representing the member's address
	 * @param city		A string representing the member's city
	 * @param state		A string representing the member's state
	 * @param zip		A string representing the member's zip code
	 * @param status	The status of the member. Can be either MemberStatus.ACTIVE or MemberStatus.SUSPENDED
	 */
	public Member(String number, String name, String address, String city, String state, String zip,
			MemberStatus status) {
		memberNumber = number;
		memberName = name;
		memberAddress = address;
		memberCity = city;
		memberState = state;
		memberZip = zip;
		memberStatus = status;
		providedServices = new ArrayList<ProvidedServiceRecord>();
	}
	
	public Member() {
		//null
	}

}
