package team11project4;

	import java.util.ArrayList;

	public class ProviderReportController {
		
		private ArrayList<ProviderReport> reports = new ArrayList<ProviderReport>();
		private ArrayList<Provider> providers = new ArrayList<Provider>();
		private ChocAnDataCenter db;

		//Construct with a new data center object
		public ProviderReportController() {
			db = new ChocAnDataCenter();
		}
		
		//Construct with an existing data center object
		public ProviderReportController(ChocAnDataCenter dataCenter) {
			db = dataCenter;
		}

		private Boolean generateProviderReports() {
			providers = db.getProviderData();
			for(Provider p : providers) { //Iterate over providers
				ProviderReport r = new ProviderReport(p); //generate a provider report
				reports.add(r); //add it to the arraylist reports
			}
			return reports.size() > 0; //If there are provider reports, return TRUE; otherwise, return FALSE.
		}
		
		public ArrayList<ProviderReport> getProviderReports() {
			generateProviderReports();
			return reports;
		}
		
	}