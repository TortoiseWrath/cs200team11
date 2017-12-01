package team11project4;

import java.util.ArrayList;

public class MemberReportController {
	
	private ArrayList<MemberReport> reports;
	private ArrayList<Member> members;
	private ChocAnDataCenter db;

	//Construct with a new data center object
	public MemberReportController() {
		db = new ChocAnDataCenter();
	}
	
	//Construct with an existing data center object
	public MemberReportController(ChocAnDataCenter dataCenter) {
		db = dataCenter;
	}

	private Boolean generateMemberReports() {
		members = db.getMemberData();
		for(Member m : members) { //Iterate over members
			MemberReport r = new MemberReport(m); //generate a member report
			reports.add(r); //add it to the arraylist reports
		}
		return reports.size() > 0; //If there are member reports, return TRUE; otherwise, return FALSE.
	}
	
	public ArrayList<MemberReport> getMemberReports() {
		generateMemberReports();
		return reports;
	}
	
}
