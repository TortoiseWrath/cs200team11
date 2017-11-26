package team11project4;

public class RecordUpdateController {
	
	ChocAnDataCenter db;

	public RecordUpdateController() {
		db = new ChocAnDataCenter();
	}
	
	public void updateRecord(Provider oldrecord, Provider newrecord) {
		db.updateProvider(oldrecord, newrecord);
	}
	
	public void updateRecord(Member oldrecord, Member newrecord) {
		db.updateMember(oldrecord, newrecord);
	}

}
