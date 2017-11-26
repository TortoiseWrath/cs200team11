package team11project4;

public class Member {
	
	public enum MemberStatus {
		ACTIVE,
		SUSPENDED
	}
	
	String memberNumber;
	String memberName;
	MemberStatus memberStatus;
	String memberAddress;
	String memberCity;
	String memberState;
	String memberZip;

	public Member() {
		// TODO Auto-generated constructor stub
	}

}
