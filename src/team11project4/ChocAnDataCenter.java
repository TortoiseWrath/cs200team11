package team11project4;

import java.util.ArrayList;

public class ChocAnDataCenter {
	
	private ArrayList<Service> services;
	private ArrayList<Member> members;
	private ArrayList<Provider> providers;

	public ChocAnDataCenter() {
		//TODO persistence
		
		// Empty ArrayLists for services, members, providers
		services = new ArrayList<Service>();
		members = new ArrayList<Member>();
		providers = new ArrayList<Provider>();
	}
	
	private Boolean save() {
		return true; //TODO: persistence
	}
	
	public Service getService(String serviceNumber) {
		for (Service s : services) { //Iterate over services
			if(s.serviceCode == serviceNumber) return s; //Look for one with matching code
		}
		return null; //No matching service
	}
	
	public Member getMember(String memberNumber) {
		for (Member m : members) {
			if(m.memberNumber == memberNumber) return m;
		}
		return null; //No matching member
	}
	
	public Provider getProvider(String providerNumber) {
		for (Provider p : providers) {
			if(p.providerNumber == providerNumber) return p;
		}
		return null; //No matching provider
	}
	
	public ArrayList<Service> getServiceData() {
		return services;
	}
	
	public ArrayList<Member> getMemberData() {
		return members;
	}
	
	public ArrayList<Provider> getProviderData() {
		return providers;
	}
	
	public EFT getEFTData() {
		return null;
	}
	
	public Boolean writeEFTReport(EFTReport report) {
		return false;
	}
	
	public Boolean addProvider(Provider provider) {
		return providers.add(provider) && this.save(); //add provider to ArrayList and save
	}
	
	public Boolean updateProvider(Provider oldrecord, Provider newrecord) {
		if (this.deleteProvider(oldrecord)) { //If old record successfully deleted
			return this.addProvider(newrecord) && this.save(); //add new provider to ArrayList and save
		}
		return false; //Old record not successfully deleted
	}
	
	public Boolean deleteProvider(Provider provider) {
		return providers.remove(provider) && this.save(); //remove provider from ArrayList and save
	}
	
	public Boolean addMember(Member member) {
		return members.add(member) && this.save();
	}
	
	public Boolean updateMember(Member oldrecord, Member newrecord) {
		if (this.deleteMember(oldrecord)) {
			return this.addMember(oldrecord) && this.save();
		}
		return false;
	}
	
	public Boolean deleteMember(Member member) {
		return members.remove(member) && this.save();
	}

}
