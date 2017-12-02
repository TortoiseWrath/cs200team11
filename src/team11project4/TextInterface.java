package team11project4;
import java.io.Console;

public class TextInterface {

	public TextInterface() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocAnDataCenter db = new ChocAnDataCenter();
		System.out.println(db);
		Member testmember = new Member();
		testmember.memberName = "This is a member.";
		testmember.memberNumber = "1";
		if(db.getMember("1") == null) db.addMember(testmember);
		Member retrievedMember = db.getMember("1");
		System.out.println(retrievedMember.memberName);
	}

}
