/**
 * @athor Hunter Allen
 */
package team11project4;

import java.util.ArrayList;

public class MainAccountingProcedureController {
	
	private ChocAnDataCenter db = new ChocAnDataCenter();
	private SummaryReport summaryReport;
	private ArrayList<ProviderReport> providerReports;
	private ArrayList<MemberReport> memberReports;

	public MainAccountingProcedureController() {
		//Creating array list of provider reports to be e-mailed
		ProviderReportController prController = new ProviderReportController();
		providerReports = prController.getProviderReports();
		
		//Creating array list of member reports to be e-mailed
		MemberReportController mrController = new MemberReportController();
		memberReports = mrController.getMemberReports();
		
		//Creating summary report to be e-mailed
		summaryReport = new SummaryReport();
	}
	
	public Boolean runProcedure() {
		//Iterate through list of provider reports and save each one to a file titled with the provider's name
		for (ProviderReport r : this.providerReports) {
			Email emailProvider = new Email(r.recipient, null, r.header + r.report);
			emailProvider.send();
		}
		
		//Iterate through list of member reports and save each one to a file titled with the member's name
		for (MemberReport r : this.memberReports) {
			Email emailMember = new Email(r.recipient, null, r.header + r.report);
			emailMember.send();
		}
		
		//Save summary report to file called "SummaryReport"
		Email emailSummary = new Email("SummaryReport", null, this.summaryReport.report);
		emailSummary.send();
		
		//Next block writes total number of active providers, total services provided, and total fee to be paid
		int totalProviders = 0;
		int totalServices = 0;
		int totalFees = 0;
		//Iterate through list of providers and total the number of providers, services, and fees
		ArrayList<Provider> providerList = db.getProviderData();
		for (Provider p : providerList) {
			totalProviders += 1;
			for (ProvidedServiceRecord r : p.providedServices) {
				totalServices += 1;
				totalFees += r.fee;
			}
		}
		//Creating string to use as the body of the Email object that will save the file
		String mapData = "Main Accounting Procedure Data:\n\n";
		mapData += "Total Active Providers: " + totalProviders + "\n";
		mapData += "Total Services Provided: " + totalServices + "\n";
		mapData += "Total Fees: " + new FormattedFee(totalFees).getFormatted() + "\n";
		
		Email mapEmail = new Email("MAPData", null, mapData);
		mapEmail.send();
		
		return true;
	}

}
