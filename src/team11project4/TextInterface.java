package team11project4;
import java.io.Console;
import java.util.Date;

public class TextInterface {

	public TextInterface() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ProvidedServiceRecord s = new ProvidedServiceRecord();
		s.dateProvided = new Date();
		s.memberNumber = "1";
		s.providerNumber = "627122283";
		s.fee = 1111;
		s.comments = "comment";
		s.serviceCode = "1";
		s.writeRecordToDisk();
		
		 s = new ProvidedServiceRecord();
		s.dateProvided = new Date();
		s.memberNumber = "1";
		s.providerNumber = "627122283";
		s.fee = 1111;
		s.comments = "comment";
		s.serviceCode = "2";
		s.writeRecordToDisk();
	}

}
