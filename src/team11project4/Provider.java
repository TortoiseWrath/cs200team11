package team11project4;

import java.io.Serializable;

public class Provider implements Serializable {
	
	private static final long serialVersionUID = 6143371899045034905L;
	
	public String providerNumber;
	public String providerName;
	public String providerAddress;
	public String providerCity;
	public String providerState;
	public String providerZip;

	public Provider() {
		// TODO Auto-generated constructor stub
	}
	
	public Provider(String number, String name, String address, String city, String state, String zip) {
		this.providerNumber = number;
		this.providerName = name;
		this.providerAddress = address;
		this.providerCity = city;
		this.providerState = state;
		this.providerZip = zip;
	}

}
