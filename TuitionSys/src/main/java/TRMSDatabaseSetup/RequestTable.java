package TRMSDatabaseSetup;

import java.util.HashMap;
import java.util.Map;

import TRMSmodels.Event;
import TRMSmodels.Request;

/*
	int requestID;
	int personID;
	int eventID;
	String requestDate;
	int paidAmount;
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
	

 */


public class RequestTable {

	public static Map<Integer, Request> requestDBtable = new HashMap<Integer,Request>();
	
	public static Map<Integer, Event> eventDBtable = new HashMap<Integer,Event>();

	static {
	
		/*
		Request r1 = new Request(2701, 27, 2701, "08/01/2020", 300, "Would give me more technical credentials",
				" ","GradeNeeded",false,true,false, true,true,true, "DBG - John Doe's Pending Request"," ",0,0);
		Event e1 = new Event(2701, "A+ Certification", "Certification", "Acity", "Atime", "Adate", "Adescription",
				300, "PassFail","70");
				
		Request r2 = new Request(2702, 27, 2702, "01/15/2019", 250, "Would help me design web sites",
				" ","MoneyAwarded",false,true,false, true,true,true, "DBG - John Doe's Old Request"," ",0,0);
		Event e2 = new Event(2702, "Web Design 101", "University", "Bcity", "Btime", "Bdate", "Bdescription",
				313, "Letter","C");
		
		Request r3 = new Request(2703, 27, 2703, "06/27/2020", 150, "Help me prepare for the A+ test",
				" ","MoneyAwarded",false,true,false, true,true,true, "DBG - John Doe's This Year Approved Request"," ",0,0);				
		Event e3 = new Event(2703, "Get Ready For A+", "TestPrep", "Ccity", "Ctime", "Cdate", "Cdescription",
				200, "Numeric","70");
		
		Request r4 = new Request(2704, 27, 2704, "08/05/2020", 90, "Brush up on my C# Skills",
				" ","EmployeeSubmitted",false,true,false, true,false,false, "DBG - Charle's This Year Approved Request"," ",0,0);	
		Event e4 = new Event(2704, "C# Application Training", "TechTraining", "Dcity", "Dtime", "Ddate", "Ddescription",
				100, "Letter","B");
		
		Request r5 = new Request(3504, 35, 3504, "08/05/2020", 80, "Brush up on my Java Skills",
				" ","EmployeeSubmitted",false,true,false, true,true,true, "DBG - A quick test for John Doe's screen"," ",0,0);	
		Event e5 = new Event(3504, "Java for Beginners", "University", "Ecity", "Etime", "Edate", "Edescription",
				100, "Letter","C");
		
		requestDBtable.put(r1.getRequestID(), r1);
		requestDBtable.put(r2.getRequestID(), r2);
		requestDBtable.put(r3.getRequestID(), r3);
		requestDBtable.put(r4.getRequestID(), r4);
		requestDBtable.put(r5.getRequestID(), r5);
		
		
		eventDBtable.put(e1.getEventID(), e1);
		eventDBtable.put(e2.getEventID(), e2);
		eventDBtable.put(e3.getEventID(), e3);
		eventDBtable.put(e4.getEventID(), e4);
		eventDBtable.put(e5.getEventID(), e5);
		
	*/
		
	}
	
}
