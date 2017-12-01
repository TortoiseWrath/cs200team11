package team11project4;

import java.util.ArrayList;

public class MemberReport {
	
	public String report;
	public String header; 

	public MemberReport(Member m) {
		header = m.memberNumber + " " + m.memberName;
		report = m.memberAddress + "\n" + m.memberCity + " " + m.memberState + " " + m.memberZip + "\n\n";
		report += "Status: " + m.memberStatus;
		for (ProvidedServiceRecord p : m.providedServices) {
			report += "providedService: " + p.serviceCode + " ";
			report += "provider: " + p.providerNumber + " ";
			report += "on: " + p.dateProvided;
			report += "for: $" + p.fee + " ";
			report += "posted: " + p.dateAdded + "\n";
			report += "-----comments: " + p.comments + "\n";
		}
	}
}