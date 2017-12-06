/**
 * Class that creates a summary report to be sent to managers.
 * 
 * @author Hunter Allen
 * 
 */
package team11project4;

public class SummaryReport {
	
	public String report;
	private ChocAnDataCenter db;

	/**
	 * Constructor with no parameters for creating SummaryReport objects.
	 */
	public SummaryReport() {
		this.db = new ChocAnDataCenter();
		this.report = "Summary Report\n\n";
		
		int totalServices = 0; int totalFee = 0;
		for (Provider p : db.getProviderData()) {
			this.report += "Provider Name: " + p.providerName + "\n";
			this.report += "Provider Number: " + p.providerNumber + "\n";
			for (ProvidedServiceRecord s : p.providedServices) {
				totalServices += 1;
				totalFee += s.fee;
			}
			this.report += "\tTotal Services: " + totalServices + "\n";
			this.report += "\tTotal Fee: " + totalFee + "\n";
		}
	}

	/**
	 * Constructor for creating SummaryReport objects. Takes a ChocAnDataCenter object as a parameter.
	 * Uses the ChocAnDataCenter to write all of the number of services provided by each provider
	 * and the fee due to be paid to them.
	 * 
	 * @param db ChocAnDataCenter object used to get the data to write the report
	 */
	public SummaryReport(ChocAnDataCenter db) {
		this.db = db;
		this.report = "Summary Report\n\n";
		
		int totalServices = 0; int totalFee = 0;
		for (Provider p : db.getProviderData()) {
			this.report += "Provider Name: " + p.providerName + "\n";
			this.report += "Provider Number: " + p.providerNumber + "\n";
			for (ProvidedServiceRecord s : p.providedServices) {
				totalServices += 1;
				totalFee += s.fee;
			}
			this.report += "\tTotal Services: " + totalServices + "\n";
			this.report += "\tTotal Fee: " + totalFee + "\n";
		}
	}

}
