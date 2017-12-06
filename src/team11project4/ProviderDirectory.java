/**
 * @author Hunter Allen
 */
package team11project4;

public class ProviderDirectory {
	
	public String directory = "Services:\n\n";
	
	public ProviderDirectory() {
		ChocAnDataCenter db = new ChocAnDataCenter();
		for (ChocAnService s : db.dummyServices) {
			this.directory += s.serviceName + "\n";
			this.directory += "\tCode: " + s.serviceCode + "\n";
			this.directory += "\tFee " + new FormattedFee(s.serviceFee).getFormatted() + "\n\n";
		}
	}

	public ProviderDirectory(ChocAnDataCenter db) {
		for (ChocAnService s : db.dummyServices) {
			this.directory += s.serviceName + "/n";
			this.directory += "\tCode: " + s.serviceCode + "\n";
			this.directory += "\tFee: " + new FormattedFee(s.serviceFee).getFormatted() + "\n\n";
		}
	}

}
