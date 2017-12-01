package team11project4;

import java.util.ArrayList;

public class EmailController {

	public EmailController() {
		// TODO Auto-generated constructor stub
	}
	
	private Boolean sendEmails(ArrayList<Email> emails) {
		Boolean success = true;
		for(Email e : emails) {
			success = success && e.send();
		}
		return success; //if all emails were sent successfully
	}
	
	public Boolean emailProviderReports(ArrayList<ProviderReport> reports) {
		ArrayList<Email> emails = new ArrayList<Email>();
		for(ProviderReport r : reports) {
			Email email = new Email(r.header, null, r.report);
			emails.add(email);
		}
		return sendEmails(emails);
	}
	
	public Boolean emailMemberReports(ArrayList<MemberReport> reports) {
		return false;
	}
	
	public Boolean emailSummaryReports(ArrayList<SummaryReport> reports) {
		return false;
	}
	
	public Boolean emailProviderDirectory(ProviderDirectory directory) {
		return false;
	}

}
