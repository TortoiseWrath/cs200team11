package team11project4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChocAnDataCenterTest {
	
	ChocAnDataCenter db;

	@Before
	public void setUp() throws Exception {
		db = new ChocAnDataCenter("testDB");
		db.clear(); //in case there is residue in the file
	}

	@Test
	public final void testClear() {
		testAddGetMember();
		testAddGetProvider();
		db.clear();
		//There should be no members or providers.
		assertEquals(db.getMemberData().size(), 0);
		assertEquals(db.getProviderData().size(), 0);
	}
	
	

	@Test
	public final void testGetServiceData() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetMemberData() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetProviderData() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public final void testGetEFTData() {
		fail("Not yet implemented");
	}

	@Test
	public final void testWriteEFTReport() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public final void testAddGetMember() {
		Member m = new Member();
		m.memberName = "test member";
		m.memberNumber = "67";
		db.addMember(m);
		assertEquals("test member", db.getMember("67").memberName);
	}

	@Test
	public final void testUpdateMemberMemberMember() {
		testAddGetMember();
		Member m1 = db.getMember("67");
		Member m2 = m1;
		m2.memberZip = "00109";
		db.updateMember(m1, m2);
		assertEquals("00109", db.getMember("67").memberZip);
		
		//also test updating the member number
		m2.memberNumber = "42";
		db.updateMember(m1, m2);
		assertEquals("00109", db.getMember("42").memberZip); //the new member exists
		assertEquals(null, db.getMember("67")); //the old member does not
	}

	@Test
	public final void testUpdateMemberMember() {
		testAddGetMember();
		Member m = db.getMember("67");
		m.memberZip = "V0H 1H0";
		db.updateMember(m);
		assertEquals("V0H 1H0", db.getMember("67").memberZip);
		
		//also test update the member number - should fail
		m.memberNumber = "58";
		assertEquals(db.updateMember(m), false);
	}

	@Test
	public final void testDeleteMember() {
		testAddGetMember();
		Member m = db.getMember("67");
		db.deleteMember(m);
		assertEquals(db.getMember("67"), null);
	}
	
	

	@Test
	public final void testAddGetProvider() {
		Provider p = new Provider();
		p.providerName = "test provider";
		p.providerNumber = "67";
		db.addProvider(p);
		assertEquals("test provider", db.getProvider("67").providerName);
	}

	@Test
	public final void testUpdateProviderProviderProvider() {
		testAddGetProvider();
		Provider p1 = db.getProvider("67");
		Provider p2 = db.getProvider("67");
		p2.providerZip = "99150";
		db.updateProvider(p1, p2);
		assertEquals(db.getProvider("67").providerZip, "99150");
		
		//also test updating the provider number
		p2.providerNumber = "102";
		db.updateProvider(p1, p2);
		assertEquals(db.getProvider("102").providerZip, "99150"); //the new provider exists
		assertEquals(db.getProvider("67"), null); //and the old one does not
	}

	@Test
	public final void testUpdateProviderProvider() {
		testAddGetProvider();
		Provider p = db.getProvider("67");
		p.providerZip = "35487";
		db.updateProvider(p);
		assertEquals(db.getProvider("67").providerZip, "35487");
		
		//also test updating the provider number - should fail
		p.providerNumber = "4";
		db.updateProvider(p);
		assertEquals(db.updateProvider(p), false);
	}

	@Test
	public final void testDeleteProvider() {
		testAddGetProvider();
		Provider p = db.getProvider("67");
		db.deleteProvider(p);
		assertEquals(db.getProvider("67"), null);
	}
	
	
	
	@Test
	public final void testAddGetService() {
		Service s = new Service();
		s.serviceCode = "67";
		s.serviceName = "test service";
		db.addService(s);
		assertEquals("test service", db.getService("67").serviceName);
	}
	
	@Test
	public final void testDeleteService() {
		testAddGetService();
		Service s = db.getService("67");
		db.deleteService(s);
		assertEquals(db.getService("67"), null);
		fail("Not yet implemented");
	}
	
	@Test
	public final void testPersistence() {
		testAddGetMember();
		db = new ChocAnDataCenter("testDB"); //read the file
		assertEquals("test member", db.getMember("67").memberName);
	}

}
