package team11project4;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import team11project4.Member.MemberStatus;

public class MemberTest {

	@Test
	public final void testEqualsMember() {
		Member m1 = new Member();
		Member m2 = new Member(m1); //make sure you can copy empty members
		assertTrue(m1.equals(m2));
		
		m1.memberAddress = "Member Address";
		m1.memberCity = "Member City";
		m1.memberName = "Member Name";
		m1.memberNumber = "0003";
		m1.memberState = "Member State";
		m1.memberStatus = MemberStatus.ACTIVE;
		m1.memberZip = "0a0a0";
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"3","003","30303","",4));
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"3","0003","30303","",4));
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"33","0003","30305","",4));
		assertFalse(m1.equals(m2)); //make sure they are not the same now
		
		m2 = new Member(m1);
		m2.providedServices.remove(1);
		assertFalse(m1.equals(m2)); //make sure they are not the same anymore
		
		m2.providedServices.add(m1.providedServices.get(1)); //move the second service to the end
		assertTrue(m1.equals(m2)); //make sure they are the same again
		
	}

}
