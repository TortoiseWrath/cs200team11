package team11project4;

import java.io.FileOutputStream;

public class Email {
	
	private String subject = "";
	private String to = "";
	private String body = "";

	public Email(String s, String t, String b) {
		subject = s;
		to = t;
		body = b;
	}
	
	public Boolean send() {
		//Not implemented as emails
		//Instead, save email to disk as "[Subject].txt"
		//and print "Email saved to [Subject].txt"
			
		try {
			FileOutputStream file = new FileOutputStream("reports/"+subject+".txt");
		    file.write(body.getBytes()); //write body to file
		    file.close(); //close file stream
		}
		catch (Exception e) { //Could not write file
			System.err.println("Error writing email to file");
			e.printStackTrace();
			return false; //failed
		}
		System.err.println("Email saved to "+subject+".txt");
	    return true; //succeeded
	}

}
