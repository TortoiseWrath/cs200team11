/**
 * @author Hunter Allen (jhallen3@crimson.ua.edu)
 */
package team11project4;

public class ProviderReport {
	
	public String report;
	public String header;
	public String recipient;

	public ProviderReport(Provider p) {
		recipient = p.providerName;
		header = p.providerName + "\n" + p.providerNumber;
		report = p.fullAddress() + "\n\n";
		report += "Services Provided:\n";
		for (ProvidedServiceRecord r : p.providedServices) {
			report += "Service Provided: " + r.serviceCode + " ";
			report += "Member: " + r.memberNumber + " ";
			report += "Date: " + r.dateProvided + " ";
			report += "For: $" + r.fee + " ";
			report += "Posted: " + r.dateAdded + "\n";
			report += "Comments: " + r.comments + "\n";
		}
	}

}
