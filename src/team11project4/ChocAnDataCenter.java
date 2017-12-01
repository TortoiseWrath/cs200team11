package team11project4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author sdgillen
 *
 * This class implements a persistent database of services, members, and providers
 * stored in the file "DATABASE" on disk as a serialized object.
 *
 */
public class ChocAnDataCenter implements Serializable {

	private static String filename = "DATABASE"; //filename for the datacenter file
	
	private static final long serialVersionUID = 987413654643164165L;  // unique id for serializer
	
	private ArrayList<Service> services;
	private ArrayList<Member> members;
	private ArrayList<Provider> providers;

	/**
	 * Constructor reads the database from the file.
	 * If there is no database file, it creates one.
	 */
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
			System.out.println(services);
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
	
	/**
	 * Save the current state of the database object to the database file.
	 * 
	 * @return true on success, false on failure
	 */
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
	
	/**
	 * gets the service with service number serviceNumber from the database
	 * @param serviceNumber the serviceNumber of the service to get
	 * @return Service, null if none match
	 */
	public Service getService(String serviceNumber) {
		for (Service s : services) { //Iterate over services
			if(s.serviceCode.equals(serviceNumber)) return s; //Look for one with matching code
		}
		return null; //No matching service
	}
	
	/**
	 * gets the member with the member number memberNumber from the database
	 * @param memberNumber the memberNumber of the member to get
	 * @return Member, null if none match
	 */
	public Member getMember(String memberNumber) {
		for (Member m : members) {
			if(m.memberNumber.equals(memberNumber)) return m;
		}
		return null; //No matching member
	}
	
	/**
	 * gets the provider with the provider number providerNumber from the database
	 * @param providerNumber the providerNumber of the provider to get
	 * @return Provider, null if none match
	 */
	public Provider getProvider(String providerNumber) {
		for (Provider p : providers) {
			if(p.providerNumber.equals(providerNumber)) return p;
		}
		return null; //No matching provider
	}
	
	/**
	 * Get the complete list of services in the database
	 * @return the list of services
	 */
	public ArrayList<Service> getServiceData() {
		return services;
	}
	
	/**
	 * Get the complete list of members in the database
	 * @return the list of members
	 */
	public ArrayList<Member> getMemberData() {
		return members;
	}
	
	/**
	 * Get the complete list of providers in the database
	 * @return the list of providers
	 */
	public ArrayList<Provider> getProviderData() {
		return providers;
	}
	
	/**
	 * get the eft data
	 * @return
	 */
	public EFT getEFTData() {
		return null;
	}
	
	/**
	 * write the eft report to the database
	 * @param report the EFT report to write
	 * @return true on success, false on failure
	 */
	public Boolean writeEFTReport(EFTReport report) {
		return false;
	}
	
	/**
	 * add a provider to the database
	 * @param provider the Provider to add
	 * @return true on success, false on failure
	 */
	public Boolean addProvider(Provider provider) {
		return providers.add(provider) && save(); //add provider to ArrayList and save
	}
	
	/**
	 * update a provider in the database
	 * @param oldrecord an unmodified Provider from the database 
	 * (optional; if only one Provider given, update the Provider with the same provider number)
	 * @param newrecord the Provider with which to replace the old Provider record
	 * @return true on success, false on failure
	 */
	public Boolean updateProvider(Provider oldrecord, Provider newrecord) {
		if (this.deleteProvider(oldrecord)) { //If old record successfully deleted
			return this.addProvider(newrecord) && save(); //add new provider to ArrayList and save
		}
		return false; //Old record not successfully deleted
	}
	public Boolean updateProvider(Provider newrecord) {
		Provider oldrecord = getProvider(newrecord.providerNumber);
		return updateProvider(oldrecord, newrecord);
	}
	
	/**
	 * delete a provider from the database
	 * @param provider the unmodified Provider record to delete
	 * @return true on success, false on failure
	 */
	public Boolean deleteProvider(Provider provider) {
		return providers.remove(provider) && save(); //remove provider from ArrayList and save
	}
	
	/**
	 * add a member to the database
	 * @param member the Member to add
	 * @return true on success, false on failure
	 */
	public Boolean addMember(Member member) {
		return members.add(member) && save();
	}
	
	/**
	 * update a member in the database
	 * @param oldrecord an unmodified Member from the database
	 * (optional; if only one Member given, update the Member with the same member number)
	 * @param newrecord the Member with which to replace the old Member record
	 * @return true on success, false on failure
	 */
	public Boolean updateMember(Member oldrecord, Member newrecord) {
		if (this.deleteMember(oldrecord)) {
			return this.addMember(oldrecord) && save();
		}
		return false;
	}
	public Boolean updateMember(Member newrecord) {
		Member oldrecord = getMember(newrecord.memberNumber);
		return updateMember(oldrecord, newrecord);
	}
	
	/**
	 * delete a member from the database
	 * @param member the unmodified Member record to delete
	 * @return true on success, false on failure
	 */
	public Boolean deleteMember(Member member) {
		return members.remove(member) && save();
	}

}
