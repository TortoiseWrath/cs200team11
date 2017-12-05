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
	public Boolean equals(Provider pr) {
		Boolean equal = providerNumber.equals(pr.providerNumber) &&
				providerName.equals(pr.providerName) &&
				providerAddress.equals(pr.providerAddress) &&
				providerCity.equals(pr.providerCity) &&
				providerState.equals(pr.providerState) &&
				providerZip.equals(pr.providerZip);
		if (!equal) return false; //skip next step
		for(ProvidedServiceRecord p : providedServices) { //iterate over providedservices on left side
			Boolean contained = false;
			//look for p in rhs
			for (ProvidedServiceRecord q : pr.providedServices) { //iterate over provided services on right side
				if(p.equals(q)) { //rhs contains lhs
					contained = true;
					break; //stop looking for p
				}
			}
			if(!contained) return false; //if p is not in rhs
		}
		for(ProvidedServiceRecord p : pr.providedServices) { //iterate over providedservices on right side
			Boolean contained = false;
			//look for p in lhs
			for (ProvidedServiceRecord q : providedServices) { //iterate over provided services on left side
				if(p.equals(q)) { //lhs contains rhs
					contained = true;
					break; //stop looking for p
				}
			}
			if(!contained) return false; //if p is not in lhs
		}
		return true; //not not equal
	}
	
	public String fullAddress() {
		return this.providerAddress + "\n" + this.providerCity + " " + this.providerState + " " + this.providerZip;
	}
	
}
