package team11project4;

public class Member {
	
	public enum MemberStatus {
		ACTIVE,
		SUSPENDED
	}
	
	public String memberNumber;
	public String memberName;
	public MemberStatus memberStatus;
	public String memberAddress;
	public String memberCity;
	public String memberState;
	public String memberZip;

	public Member() {
		// TODO Auto-generated constructor stub
	}

}
