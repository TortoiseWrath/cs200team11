package team11project4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ChocAnDataCenter implements Serializable {

	private static String filename = "DATABASE"; //filename for the datacenter file
	
	private static final long serialVersionUID = 987413654643164165L;  // unique id for serializer
	
	private ArrayList<Service> services;
	private ArrayList<Member> members;
	private ArrayList<Provider> providers;

	public ChocAnDataCenter() {
		try { //Attempt to read the database from file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			ChocAnDataCenter storedData = (ChocAnDataCenter) in.readObject(); //This will not call the constructor
			
			services = storedData.getServiceData();
			members = storedData.getMemberData();
			providers = storedData.getProviderData();
			
			in.close();
			file.close();			
			storedData = null; //inform garbage collector we are done with it
		}
		catch (FileNotFoundException e) { //No database file
			// Empty ArrayLists for services, members, providers
			services = new ArrayList<Service>();
			members = new ArrayList<Member>();
			providers = new ArrayList<Provider>();
			
			save(); //make a new database file
			
			System.err.println("Created a database file "+filename);
		}
		catch (IOException e) {
			System.err.println("Error deserializing ChocAn Data Center");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.err.println("oh no");
			e.printStackTrace();
		}
	}
	
	private Boolean save() {
		try {
			FileOutputStream file = new FileOutputStream(filename);
		    ObjectOutputStream out = new ObjectOutputStream(file);
		    out.writeObject(this); //write the datacenter to the file
		    out.close(); //close object stream
		    file.close(); //close file stream
		}
		catch (Exception e) { //Could not write file
			System.err.println("Error serializing ChocAn Data Center");
			e.printStackTrace();
			return false; //failed
		}
	    return true; //succeeded
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
		return providers.add(provider) && save(); //add provider to ArrayList and save
	}
	
	public Boolean updateProvider(Provider oldrecord, Provider newrecord) {
		if (this.deleteProvider(oldrecord)) { //If old record successfully deleted
			return this.addProvider(newrecord) && save(); //add new provider to ArrayList and save
		}
		return false; //Old record not successfully deleted
	}
	
	public Boolean deleteProvider(Provider provider) {
		return providers.remove(provider) && save(); //remove provider from ArrayList and save
	}
	
	public Boolean addMember(Member member) {
		return members.add(member) && save();
	}
	
	public Boolean updateMember(Member oldrecord, Member newrecord) {
		if (this.deleteMember(oldrecord)) {
			return this.addMember(oldrecord) && save();
		}
		return false;
	}
	
	public Boolean deleteMember(Member member) {
		return members.remove(member) && save();
	}

}
