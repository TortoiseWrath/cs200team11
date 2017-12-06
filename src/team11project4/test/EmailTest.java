/**
 * JUnit Test for Email class
 * 
 * @author Hunter Allen
 */
package team11project4.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import team11project4.Email;

public class EmailTest {

	Email email;
	String subject = "Recipient";
	String body = "This is the body of the email.";
	
	@Before
	public void setUp() throws Exception {
		email = new Email(subject, null, body);
	}
	
	@Test
	public void testSendForSuccess() {//Should successfully send
		assertTrue(email.send());
	}
	
	@Test
	public void testSendForFailure() {//Should fail to send
		assertFalse(new Email(subject, null, null).send());
	}
	
	@Test
	public void testSubject() {
		assertTrue(subject.equals(email.subject));
	}
	
	@Test
	public void testBody() {
		assertTrue(body.equals(body));
	}
	

}
