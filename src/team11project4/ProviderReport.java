/**
 * @author Hunter Allen (jhallen3@crimson.ua.edu)
 */
package team11project4;

public class ProviderReport {
	
	public String report;
	public String header;

	public ProviderReport(Provider p) {
		header = p.providerNumber + " " + p.providerName;
		report = p.fullAddress() + "\n\n";
		report += "Services Provided:\n";
	}

}
