package TRMSmodels;

public class Request {

	int requestID;
	int personID;
	int eventID;
	String requestDate;
	int refundAmount;
	String workReason;
	String overReason;
	String status;
	boolean ppNeeded;
	boolean gradeNeeded;
	boolean preApproved;
	
	boolean supervisorCanSee;
	boolean deptHeadCanSee;
	boolean benCoCanSee;
	
	String debugComment1;
	String debugComment2;
	int debugInt1;
	int debugInt2;
	
	
	public int getRequestID() {
		return requestID;
	}
	public int getPersonID() {
		return personID;
	}
	public int getEventID() {
		return eventID;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public int getRefundAmount() {
		return refundAmount;
	}
	public String getWorkReason() {
		return workReason;
	}
	public String getOverReason() {
		return overReason;
	}
	public String getStatus() {
		return status;
	}
	public boolean isPpNeeded() {
		return ppNeeded;
	}
	public boolean isGradeNeeded() {
		return gradeNeeded;
	}
	public boolean isPreApproved() {
		return preApproved;
	}
	public boolean isSupervisorCanSee() {
		return supervisorCanSee;
	}
	public boolean isDeptHeadCanSee() {
		return deptHeadCanSee;
	}
	public boolean isBenCoCanSee() {
		return benCoCanSee;
	}
	public String getDebugComment1() {
		return debugComment1;
	}
	public String getDebugComment2() {
		return debugComment2;
	}
	public int getDebugInt1() {
		return debugInt1;
	}
	public int getDebugInt2() {
		return debugInt2;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public void setRefundAmount(int paidAmount) {
		this.refundAmount = paidAmount;
	}
	public void setWorkReason(String workReason) {
		this.workReason = workReason;
	}
	public void setOverReason(String overReason) {
		this.overReason = overReason;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPpNeeded(boolean ppNeeded) {
		this.ppNeeded = ppNeeded;
	}
	public void setGradeNeeded(boolean gradeNeeded) {
		this.gradeNeeded = gradeNeeded;
	}
	public void setPreApproved(boolean preApproved) {
		this.preApproved = preApproved;
	}
	public void setSupervisorCanSee(boolean supervisorCanSee) {
		this.supervisorCanSee = supervisorCanSee;
	}
	public void setDeptHeadCanSee(boolean deptHeadCanSee) {
		this.deptHeadCanSee = deptHeadCanSee;
	}
	public void setBenCoCanSee(boolean benCoCanSee) {
		this.benCoCanSee = benCoCanSee;
	}
	public void setDebugComment1(String debugComment1) {
		this.debugComment1 = debugComment1;
	}
	public void setDebugComment2(String debugComment2) {
		this.debugComment2 = debugComment2;
	}
	public void setDebugInt1(int debugInt1) {
		this.debugInt1 = debugInt1;
	}
	public void setDebugInt2(int debugInt2) {
		this.debugInt2 = debugInt2;
	}
	
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", personID=" + personID + ", eventID=" + eventID + ", requestDate="
				+ requestDate + ", paidAmount=" + refundAmount + ", workReason=" + workReason + ", overReason="
				+ overReason + ", status=" + status + ", ppNeeded=" + ppNeeded + ", gradeNeeded=" + gradeNeeded
				+ ", preApproved=" + preApproved + ", supervisorCanSee=" + supervisorCanSee + ", deptHeadCanSee="
				+ deptHeadCanSee + ", benCoCanSee=" + benCoCanSee + ", debugComment1=" + debugComment1
				+ ", debugComment2=" + debugComment2 + ", debugInt1=" + debugInt1 + ", debugInt2=" + debugInt2 + "]\n";
	}
	public Request(int requestID, int personID, int eventID, String requestDate, int paidAmount, String workReason,
			String overReason, String status, boolean ppNeeded, boolean gradeNeeded, boolean preApproved,
			boolean supervisorCanSee, boolean deptHeadCanSee, boolean benCoCanSee, String debugComment1,
			String debugComment2, int debugInt1, int debugInt2) {
		super();
		this.requestID = requestID;
		this.personID = personID;
		this.eventID = eventID;
		this.requestDate = requestDate;
		this.refundAmount = paidAmount;
		this.workReason = workReason;
		this.overReason = overReason;
		this.status = status;
		this.ppNeeded = ppNeeded;
		this.gradeNeeded = gradeNeeded;
		this.preApproved = preApproved;
		this.supervisorCanSee = supervisorCanSee;
		this.deptHeadCanSee = deptHeadCanSee;
		this.benCoCanSee = benCoCanSee;
		this.debugComment1 = debugComment1;
		this.debugComment2 = debugComment2;
		this.debugInt1 = debugInt1;
		this.debugInt2 = debugInt2;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
