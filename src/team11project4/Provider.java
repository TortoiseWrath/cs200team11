package team11project4;

import java.io.Serializable;
import java.util.ArrayList;

public class Provider implements Serializable {
	
	private static final long serialVersionUID = 6143371899045034905L;
	
	public String providerNumber;
	public String providerName;
	public String providerAddress;
	public String providerCity;
	public String providerState;
	public String providerZip;
	public ArrayList<ProvidedServiceRecord> providedServices;

	public Provider() {
		// TODO Auto-generated constructor stub
	}
	
	public Provider(String number, String name, String address, String city, String state, String zip) {
		providerNumber = number;
		providerName = name;
		providerAddress = address;
		providerCity = city;
		providerState = state;
		providerZip = zip;
		providedServices = new ArrayList<ProvidedServiceRecord>();
	}

}
