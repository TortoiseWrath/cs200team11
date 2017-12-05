package team11project4;

public class ProviderDirectory {
	
	public String directory = "Services:\n\n";

	public ProviderDirectory(ChocAnDataCenter db) {
		for (ChocAnService s : db.dummyServices) {
			directory += s.serviceName + "/n";
			directory += "\tCode: " + s.serviceCode + "\n";
			directory += "\tFee: " + s.serviceFee + "\n\n";
		}
	}

}
