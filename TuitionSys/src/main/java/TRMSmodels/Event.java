package TRMSmodels;

public class Event {

	int eventID;
	String eventName;
	String eventType;
	String eventLocation;
	String eventTime;
	String eventDate;
	String eventDesc;
	int eventCost;
	String gradeType;
	String passingGrade;
	
	public int getEventID() {
		return eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public String getEventTime() {
		return eventTime;
	}
	public String getEventDate() {
		return eventDate;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public int getEventCost() {
		return eventCost;
	}
	public String getGradeType() {
		return gradeType;
	}
	public String getPassingGrade() {
		return passingGrade;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}
	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventType=" + eventType
				+ ", eventLocation=" + eventLocation + ", eventTime=" + eventTime + ", eventDate=" + eventDate
				+ ", eventDesc=" + eventDesc + ", eventCost=" + eventCost + ", gradeType=" + gradeType
				+ ", passingGrade=" + passingGrade + "]\n";
	}
	public Event(int eventID, String eventName, String eventType, String eventLocation, String eventTime,
			String eventDate, String eventDesc, int eventCost, String gradeType, String passingGrade) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventLocation = eventLocation;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
		this.eventDesc = eventDesc;
		this.eventCost = eventCost;
		this.gradeType = gradeType;
		this.passingGrade = passingGrade;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
