package TRMSmodels;

import java.util.List;

public class Listing {

	String eventName = "DummyEventName";
	
	String description = "DummyDescription";
	String requestDate = "DummyRequestDate";
	int cost = -1;
	int refund = -1;
	
	String eventLocation = "DummyEventLocation";
	String eventDate = "DummyEventDate";
	String eventTime = "DummyEventTime";
	String eventType = "DummyEventType";
	
	String workReason = "DummyWorkReason";
	String missedWork = "DummyMissedWork";
	
	String gradeFormat = "DummyGradeFormat";
	String passingGrade = "DummyPassingGrade";
	String gradeRecieved = "DummyGradeRecieved";
	boolean talkNeeded = false;
	
	String status = "DummyStatus";
	List<Message> messages;
	
	String supervisorName = "NOTHING";
	String deptHeadName = "NOTHING";
	String benCoName = "NOTHING";
	String ownerName = "NOTHING";
	
	int supervisorID = 0;
	int deptHeadID = 0;
	int benCoID = 0;
	int ownerID = 0;

	
	String debugComment1 = "nothing1";
	String userAction = "nothing2";
	int debugInt1 = -1001;
	int requestID = -1002;
	
	
	
	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getDebugComment1() {
		return debugComment1;
	}

	public String getUserAction() {
		return userAction;
	}

	public int getDebugInt1() {
		return debugInt1;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setDebugComment1(String debugComment1) {
		this.debugComment1 = debugComment1;
	}

	public void setUserAction(String debugComment2) {
		this.userAction = debugComment2;
	}

	public void setDebugInt1(int debugInt1) {
		this.debugInt1 = debugInt1;
	}

	public void setRequestID(int debugInt2) {
		this.requestID = debugInt2;
	}

	public String getEventName() {
		return eventName;
	}

	public String getDescription() {
		return description;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public int getCost() {
		return cost;
	}

	public int getRefund() {
		return refund;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public String getEventDate() {
		return eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public String getEventType() {
		return eventType;
	}

	public String getWorkReason() {
		return workReason;
	}

	public String getMissedWork() {
		return missedWork;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public String getGradeRecieved() {
		return gradeRecieved;
	}

	public boolean isTalkNeeded() {
		return talkNeeded;
	}

	public String getStatus() {
		return status;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setWorkReason(String workReason) {
		this.workReason = workReason;
	}

	public void setMissedWork(String missedWork) {
		this.missedWork = missedWork;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public void setGradeRecieved(String gradeRecieved) {
		this.gradeRecieved = gradeRecieved;
	}

	public void setTalkNeeded(boolean talkNeeded) {
		this.talkNeeded = talkNeeded;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
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

	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}

	public void setDeptHeadID(int deptHeadID) {
		this.deptHeadID = deptHeadID;
	}

	public void setBenCoID(int bencoID) {
		this.benCoID = bencoID;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getSupervisorName() {
		return supervisorName;
	}

	public String getDeptHeadName() {
		return deptHeadName;
	}

	public String getBenCoName() {
		return benCoName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public void setDeptHeadName(String deptHeadName) {
		this.deptHeadName = deptHeadName;
	}

	public void setBenCoName(String benCoName) {
		this.benCoName = benCoName;
	}

	
	public Listing(String eventName, String description, String requestDate, int cost, int refund, String eventLocation,
			String eventDate, String eventTime, String eventType, String workReason, String missedWork,
			String gradeFormat, String passingGrade, String gradeRecieved, boolean talkNeeded, String status,
			List<Message> messages, String debugComment1, String debugComment2, int debugInt1, int debugInt2) {
		super();
		this.eventName = eventName;
		this.description = description;
		this.requestDate = requestDate;
		this.cost = cost;
		this.refund = refund;
		this.eventLocation = eventLocation;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.workReason = workReason;
		this.missedWork = missedWork;
		this.gradeFormat = gradeFormat;
		this.passingGrade = passingGrade;
		this.gradeRecieved = gradeRecieved;
		this.talkNeeded = talkNeeded;
		this.status = status;
		this.messages = messages;
		this.debugComment1 = debugComment1;
		this.userAction = debugComment2;
		this.debugInt1 = debugInt1;
		this.requestID = debugInt2;
	}

	public Listing() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String ds = "Listing [eventName:" + eventName + ",\n description:" + description + ", requestDate:" + requestDate
				+ ", cost:" + cost + ", refund:" + refund + ",\n eventLocation:" + eventLocation + ", eventDate:"
				+ eventDate + ", eventTime:" + eventTime + ", eventType:" + eventType + ",\n workReason:" + workReason
				+ ", missedWork:" + missedWork + ",\n gradeFormat:" + gradeFormat + ", passingGrade:" + passingGrade
				+ ", gradeRecieved:" + gradeRecieved + ", talkNeeded:" + talkNeeded + ",\n -----------<<<<<<    status: " + status
				+ "     >>>>>>>>>>----------,\n messages:" + messages + "]\n"+ ", debugComment1=" + debugComment1 + ", userAction=" + userAction
				+", debugInt1=" + debugInt1 + ", debugInt2=" + requestID + "]\n\n";
		return ds;
	}
	
}
