package team11project4;

public class FormattedFee {
	
	private int fee;
	
	public FormattedFee(int f) {
		fee = f;
	}
	
	public String getDollars() {
		return String.format("%d", fee/100);
	}
	
	public String getCents() {
		return String.format("%02d", fee%100);
	}
	
	public String getFormatted() {
		return "$" + getDollars() + "." + getCents();
	}

}
