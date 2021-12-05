package TRMSmodels;

public class Person {

	int personID = 9999;
	String name = "NOBODY";
	int supervisorID = 0;
	int deptHeadID = 0;
	int benCoID = 0;
	String username = "nobodyusername";
	String password = "nobodypassword";
	int amountRemaining = -1;
	int amountAwarded = -1;
	
	
	public int getAmountAwarded() {
		return amountAwarded;
	}
	public void setAmountAwarded(int amountAwarded) {
		this.amountAwarded = amountAwarded;
	}
	public int getAmountRemaining() {
		return amountRemaining;
	}
	public void setAmountRemaining(int amountLeft) {
		this.amountRemaining = amountLeft;
	}
	public int getPersonID() {
		return personID;
	}
	public String getName() {
		return name;
	}
	public int getSupervisorID() {
		return supervisorID;
	}
	public int getDeptHeadID() {
		return deptHeadID;
	}
	public int getBenCoID() {
		return benCoID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}
	public void setDeptHeadID(int deptHeadID) {
		this.deptHeadID = deptHeadID;
	}
	public void setBenCoID(int benCoID) {
		this.benCoID = benCoID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [personID=" + personID + ", name=" + name + ", supervisorID=" + supervisorID + ", deptHeadID="
				+ deptHeadID + ", benCoID=" + benCoID + ", username=" + username + ", password=" + password
				+ ", amountLeft=" + amountRemaining + ", amountAwarded=" + amountAwarded + "]";
	}
	public Person(int personID, String name, int supervisorID, int deptHeadID, int benCoID, String username,
			String password, int amountLeft, int amountAwarded) {
		super();
		this.personID = personID;
		this.name = name;
		this.supervisorID = supervisorID;
		this.deptHeadID = deptHeadID;
		this.benCoID = benCoID;
		this.username = username;
		this.password = password;
		this.amountRemaining = amountLeft;
		this.amountAwarded = amountAwarded;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
