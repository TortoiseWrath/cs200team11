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
	public final void testUpdateProviderProviderProvider() {
		fail("Not yet implemented");
	}

	@Test
	public final void testUpdateProviderProvider() {
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
	public final void testAddGetProvider() {
		Provider p = new Provider();
		p.providerName = "test provider";
		p.providerNumber = "67";
		db.addProvider(p);
		assertEquals("test provider", db.getProvider("67").providerName);
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
	public final void testPersistence() {
		testAddGetMember();
		db = new ChocAnDataCenter("testDB"); //read the file
		assertEquals("test member", db.getMember("67"));
	}

	@Test
	public final void testUpdateMemberMemberMember() {
		fail("Not yet implemented");
	}

	@Test
	public final void testUpdateMemberMember() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteMember() {
		fail("Not yet implemented");
	}
	
	@Test
	public final void testDeleteService() {
		fail("Not yet implemented");
	}

}
