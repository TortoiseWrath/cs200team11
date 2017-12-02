package team11project4;

import java.io.Serializable;
import java.util.ArrayList;

public class Provider implements Serializable {
	
	private static final long serialVersionUID = 6143371899045034905L;
	
	public String providerNumber = "";
	public String providerName = "";
	public String providerAddress = "";
	public String providerCity = "";
	public String providerState = "";
	public String providerZip = "";
	public ArrayList<ProvidedServiceRecord> providedServices = new ArrayList<ProvidedServiceRecord>();

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
	}

	/**
	 * Copy constructor
	 */
	public Provider(Provider p) {
		providerNumber = p.providerNumber;
		providerName = p.providerName;
		providerAddress = p.providerAddress;
		providerCity = p.providerCity;
		providerState = p.providerState;
		providerZip = p.providerZip;
		for(ProvidedServiceRecord r : p.providedServices) {
			providedServices.add(new ProvidedServiceRecord(r));
		}
	}
	
	/**
	 * Equals method
	 */
	public Boolean equals(Provider p) {
		return providerNumber.equals(p.providerNumber) &&
				providerName.equals(p.providerName) &&
				providerAddress.equals(p.providerAddress) &&
				providerCity.equals(p.providerCity) &&
				providerState.equals(p.providerState) &&
				providerZip.equals(p.providerZip) &&
				providedServices.equals(p.providedServices);
	}
	
}
