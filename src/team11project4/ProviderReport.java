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
		header = p.providerNumber + " " + p.providerName;
		report = p.fullAddress() + "\n\n";
		report += "Services Provided:\n";
		for (ProvidedServiceRecord r : p.providedServices) {
			report += "providedService: " + r.serviceCode + " ";
			report += "member: " + r.memberNumber + " ";
			report += "on: " + r.dateProvided + " ";
			report += "for: $" + r.fee + " ";
			report += "posted: " + r.dateAdded + "\n";
			report += "-----comments: " + r.comments + "\n";
		}
	}

}
