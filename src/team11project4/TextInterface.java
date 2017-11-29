package team11project4;
import java.io.Console;

public class TextInterface {

	public TextInterface() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocAnDataCenter db = new ChocAnDataCenter();
		Member testmember = new Member();
		testmember.memberName = "This is a member.";
		testmember.memberNumber = "1";
		//db.addMember(testmember);
		Member retrievedMember = db.getMember("1");
		System.out.println(retrievedMember.memberName);
	}

}
