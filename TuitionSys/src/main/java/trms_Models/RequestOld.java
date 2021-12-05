package trms_Models;

public class RequestOld {

	private int requestID;
	private int personID;
	private int originalAmount;
	private int adjustedAmount;
	private int eventID;
	private String status;
	private String employeeJustification;
	private String overrideJustification;
	private int fileID;
	
	public int getRequestID() {
		return requestID;
	}
	public int getPersonID() {
		return personID;
	}
	public int getOriginalAmount() {
		return originalAmount;
	}
	public int getAdjustedAmount() {
		return adjustedAmount;
	}
	public int getEventID() {
		return eventID;
	}
	public String getStatus() {
		return status;
	}
	public String getEmployeeJustification() {
		return employeeJustification;
	}
	public String getOverrideJustification() {
		return overrideJustification;
	}
	public int getFileID() {
		return fileID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public void setOriginalAmount(int originalAmount) {
		this.originalAmount = originalAmount;
	}
	public void setAdjustedAmount(int adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setEmployeeJustification(String employeeJustification) {
		this.employeeJustification = employeeJustification;
	}
	public void setOverrideJustification(String overrideJustification) {
		this.overrideJustification = overrideJustification;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", personID=" + personID + ", originalAmount=" + originalAmount
				+ ", adjustedAmount=" + adjustedAmount + ", eventID=" + eventID + ", status=" + status
				+ ", employeeJustification=" + employeeJustification + ", overrideJustification="
				+ overrideJustification + ", fileID=" + fileID + "]";
	}

	
}