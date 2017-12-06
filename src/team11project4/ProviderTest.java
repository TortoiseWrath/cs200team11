package team11project4;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class ProviderTest {

	@Test
	public final void testEqualsprovider() {
		Provider m1 = new Provider();
		Provider m2 = new Provider(m1); //make sure you can copy empty providers
		assertTrue(m1.equals(m2));
		
		m1.providerAddress = "provider Address";
		m1.providerCity = "provider City";
		m1.providerName = "provider Name";
		m1.providerNumber = "0003";
		m1.providerState = "provider State";
		m1.providerZip = "0a0a0";
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"3","003","30303","",4));
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"3","0003","30303","",4));
		m1.providedServices.add(new ProvidedServiceRecord(new Date(),"33","0003","30305","",4));
		assertFalse(m1.equals(m2)); //make sure they are not the same now
		
		m2 = new Provider(m1);
		m2.providedServices.remove(1);
		assertFalse(m1.equals(m2)); //make sure they are not the same anymore
		
		m2.providedServices.add(m1.providedServices.get(1)); //move the second service to the end
		assertTrue(m1.equals(m2)); //make sure they are the same again
		
	}

}
