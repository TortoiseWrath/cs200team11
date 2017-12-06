package team11project4;

public class MemberReport {
	
	public String report;
	public String header; 
	public String recipient;

	public MemberReport(Member m) {
		recipient = m.memberName;
		header = m.memberName + "\n" + m.memberNumber + "\n";
		report = m.memberAddress + "\n" + m.memberCity + " " + m.memberState + " " + m.memberZip + "\n\n";
		report += "Status: " + m.memberStatus;
		for (ProvidedServiceRecord p : m.providedServices) {
			report += "Service Recieved: " + p.serviceCode + " ";
			report += "Provider: " + p.providerNumber + " ";
			report += "Date: " + p.dateProvided;
			report += "Fee: $" + p.fee + " ";
			report += "Posted: " + p.dateAdded + "\n";
			report += "Comments: " + p.comments + "\n";
		}
	}
}