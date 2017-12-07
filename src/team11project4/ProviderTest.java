package team11project4;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class ProviderTest {

	@Test
	public final void sanityTest1() {
		Provider m1 = new Provider();
		Provider m2 = new Provider(m1);
		assertTrue(m1.equals(m2)); //Just making sure both methods create Provider
	}
	
	@Test
	public final void failCheck() {
		Provider m1 = new Provider();
		Provider m2 = new Provider(m1);
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
	}
	
	@Test
	public final void passCheck() {
		Provider m1 = new Provider();
		Provider m2 = new Provider(m1);
		m2.providedServices.add(new ProvidedServiceRecord(new Date(), "1", "101", "33221", "", 4));
		m2.providedServices.add(new ProvidedServiceRecord(new Date(), "2", "202", "22334", "", 4));
		m1.providedServices.add(m2.providedServices.get(1));
		assertFalse(m1.equals(m2)); //Makes sure it's different
		m2.providedServices.remove(0);
		assertTrue(m1.equals(m2)); //Makes sure they are the same after changes
	}

}
