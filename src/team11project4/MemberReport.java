package team11project4;

import java.util.ArrayList;

public class MemberReport {
	
	public String memberReport;

	public MemberReport() {
		//Clear previous report
		memberReport = "";
		String temp;
		ChocAnDataCenter Center = null;
		ArrayList<Member> memberList = Center.getMemberData();
		ArrayList<ProvidedServiceRecord> provServiceList = null;
		//Iterate through members
		
		for (Member m: memberList) {
			temp = "";
			temp += m.memberNumber + " " + m.memberName + " " + m.memberAddress + " " + m.memberCity " " + m.memberState " " + m.memberZip + " ";
			temp += "Status: " m.memberStatus;
			for (ProvidedServiceRecord p: provServiceList) {
				temp += "providedService: " + p.serviceCode + " ";
				temp += "provider: " + p.providerNumber + " ";
				temp += "on: " + p.dateProvided;
				temp += "for: $" + p.fee + " ";
				temp += "posted: " + p.dateAdded + "\n";
				temp += "-----comments: " + p.comments + "\n";
			}
			memberReport += temp;
		}
	}
}