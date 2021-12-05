package TRMSservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TRMSDatabaseSetup.RequestTable;
import TRMSmodels.Event;
import TRMSmodels.Listing;
import TRMSmodels.Message;
import TRMSmodels.Person;
import TRMSmodels.Request;

public class RequestService {

	public static Request getRequest(int id) {
		// TODO Auto-generated method stub
		return RequestTable.requestDBtable.get(id);
	}

	public static List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		Set<Integer> keys = RequestTable.requestDBtable.keySet();
		List<Request> requestList = new ArrayList<Request>();
		
		for(Integer key: keys) {
			requestList.add(RequestTable.requestDBtable.get(key));
		}
		return requestList;
	}
	
	public static List<Request> GetMyRequests() {
		
		List<Request> allReq = RequestService.getAllRequests();
		List<Request> myReq = new ArrayList<Request>();
		List<Event> allEvent = EventService.getAllEvents();
		List<Event> myEvent = new ArrayList<Event>();
		
		int me = PersonService.personLoggedIn.getPersonID();
		
		for (Request r : allReq) {
			
			int owner = r.getPersonID();
			int see = 0;
			
			if (me == owner) see = 1;							//As the owner, I can see the request
			if (me == PersonService.getSupervisorID(owner))	//If I am the owner's supervisor...
				if (r.isSupervisorCanSee()) see = 1;			//and it has come to me, I can see it.
			if (me == PersonService.getDeptHeadID(owner))	//If I am the owner's department head...
				if (r.isDeptHeadCanSee()) see = 1;				//and it has come to me, I can see it.
			if (me == PersonService.getBenCoID(owner))		//If I am the benefits coordinator...
				if (r.isBenCoCanSee()) see = 1;					//and it has come to me, I can see it.
			
			if (see==1) {
				myReq.add(r);   //If I can see it, add it to the list
				myEvent.add(EventService.getEvent(r.getEventID()));
			}
		}

		return myReq;
	}

	public static Listing CreateListing(int requestID, int eventID) {
		
		Request r = RequestService.getRequest(requestID);
		Event e = EventService.getEvent(eventID);
		List<Message> messages = MessageService.getMyMessages(requestID);
		
		Listing theListing = new Listing (e.getEventName(),
							e.getEventDesc(), r.getRequestDate(), e.getEventCost(), r.getRefundAmount(),
							e.getEventLocation(), e.getEventDate(), e.getEventTime(), e.getEventType(),
							r.getWorkReason(), "No missed work", 
							e.getGradeType(), e.getPassingGrade(), "Pass", r.isPpNeeded(),
							r.getStatus(), messages,
							r.getDebugComment1(), r.getDebugComment2(), r.getDebugInt1(), r.getRequestID());

		//Set person's name
		theListing.setOwnerName(PersonService.getPerson(r.getPersonID()).getName());
		
		
		//Set names of chain of command, IF they can see. A value of "NOTHING" does NOT mean that person does not
		//exist. It just means that they do not show up in the front-end menu of message sending possibilities.
		
		theListing.setOwnerID(r.getPersonID());
		
		if(r.isSupervisorCanSee()) {
			System.out.println(">>>>>>>>>Supervisor");
			int rsid = PersonService.getSupervisorID(r.getPersonID());
			Person rs = PersonService.getPerson(rsid);
			theListing.setSupervisorName(rs.getName());
			theListing.setSupervisorID(rsid);
			System.out.println(">>>The supervisor of "+r.getPersonID()+" is "+rs.getName());
		}
		
		if(r.isDeptHeadCanSee()) {
			System.out.println(">>>>>>>>>DeptHead");
			int rdhid = PersonService.getDeptHeadID(r.getPersonID());
			Person rdh = PersonService.getPerson(rdhid);
			theListing.setDeptHeadName(rdh.getName());
			theListing.setDeptHeadID(rdhid);
			System.out.println(">>>The department head of of "+r.getPersonID()+" is "+rdh.getName());
		}
		
		if(r.isBenCoCanSee()) {
			System.out.println(">>>>>>>>>BenCo");
			int rbcid = PersonService.getBenCoID(r.getPersonID());
			Person rbc = PersonService.getPerson(rbcid);
			theListing.setBenCoName(rbc.getName());
			theListing.setBenCoID(rbcid);
			System.out.println(">>>The benco of "+r.getPersonID()+" is "+rbc.getName());
		}
		
		
		return theListing;
	}
	
	public static void addRequest (Request r) {
		
			RequestTable.requestDBtable.put(r.getRequestID(), r);

	}

	public static void changeStatus(int reqID, String newStatus) {
		
		//Change status and allow appropriate parties to see it.
		if (newStatus.equals("SupervisorApproved"))
			RequestTable.requestDBtable.get(reqID).setDeptHeadCanSee(true);
		
		if (newStatus.equals("DeptHeadApproved"))
			RequestTable.requestDBtable.get(reqID).setBenCoCanSee(true);
							
		RequestTable.requestDBtable.get(reqID).setStatus(newStatus);

	}
	
	public static void newRequest(Listing nl, int presetID) {
		// TODO Auto-generated method stub
		
		//Creates a new tuition refund request from the webform.
		//This requires creating both an event and a request.
		//Can be passed in a hard-wired ID for debugging.
		
		//Step 1: create a new event.
		/*
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
		 
		Event ne = new Event();
		ne.setEventID(presetID);
		ne.setEventName(nl.getEventName());
		ne.setEventType(nl.getEventType());
		ne.setEventLocation(nl.getEventLocation());
		ne.setEventTime(nl.getEventTime());
		ne.setEventDate(nl.getEventDate());
		ne.setEventDesc(nl.getDescription());
		ne.setEventCost(nl.getCost());
		ne.setGradeType(nl.getGradeFormat());
		ne.setPassingGrade(nl.getPassingGrade());
		EventService.addEvent(ne);
		
		// Step 2: create a new request
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
		*/
		
		Request nr = new Request();
		nr.setRequestID(presetID);
		nr.setPersonID(PersonService.personLoggedIn.getPersonID());
		nr.setEventID(presetID);
		nr.setRequestDate(nl.getRequestDate());
		
		//Set the refund amount. It is either the cost * percentage, or the remaining amount the person has.
		if(nl.getRefund()==-1) {
		int stdRef = CategoryService.getRefundAmount(nl.getEventType(), nl.getCost());
		int remRef = PersonService.getRemainingMoney(nr.getPersonID());
		int realRefund = stdRef;
		if (stdRef > remRef) realRefund = remRef;
		nr.setRefundAmount(realRefund);
		}
		else
			nr.setRefundAmount(nl.getRefund());
		
		nr.setWorkReason(nl.getWorkReason());
		nr.setOverReason("NONE - REQUEST IN PROGRESS");
		nr.setStatus("EmployeeSubmitted");
		nr.setPpNeeded(nl.isTalkNeeded());
		nr.setGradeNeeded(true);
		nr.setPreApproved(false);
		nr.setSupervisorCanSee(true);
		nr.setDeptHeadCanSee(false);
		nr.setBenCoCanSee(false);
		nr.setDebugComment1(nl.getDebugComment1());
		nr.setDebugComment2(nl.getUserAction());
		nr.setDebugInt1(nl.getDebugInt1());
		nr.setDebugInt2(nl.getRequestID());
		RequestService.addRequest(nr);
	
		//Add a message that a new request has been created
		MessageService.createMessage(nr.getPersonID(), 0, nr.getRequestID(), "A new request was created.");
		//System.out.println("----------------new request created-------------------------");
		//System.out.println(nr);
		//System.out.println("----------------new event created-------------------------");
		//System.out.println(ne);
		
		
		//int randomNum = ((int) (Math.random() * 100)) + 1;
	}
	
	public static void AcceptRequest(int reqID) {

		
		//Accepts a tuition request and changes the status, and money, accordingly
		
		Request req = RequestService.getRequest(reqID);
		String status = req.getStatus();
		
		int me = PersonService.personLoggedIn.getPersonID();	
		int reqMaker = req.getPersonID();
		int reqSup = PersonService.getSupervisorID(req.getPersonID());
		int reqDept = PersonService.getDeptHeadID(req.getPersonID());
		int reqBenCo = PersonService.getBenCoID(req.getPersonID());
		
		//Print out people related to this request.
		System.out.println(PersonService.getPerson(reqSup).getName() +" is "+PersonService.getPerson(req.getPersonID()).getName()+" 's Supervisor.");
		System.out.println(PersonService.getPerson(reqDept).getName() +" is "+PersonService.getPerson(req.getPersonID()).getName()+" 's Departmemt Head.");
		System.out.println(PersonService.getPerson(reqBenCo).getName() +" is "+PersonService.getPerson(req.getPersonID()).getName()+" 's Benefits Coordinator.");
		
		//If it is employee submitted, and I'm the supervisor, set the status to SupervisorApproved
		if(me == reqSup && status.equals("EmployeeSubmitted")) 
			RequestService.changeStatus(reqID,"SupervisorApproved");
		
		//If it is approved by the supervisor, and I'm the department head, set the status to DeptHeadApproved. 
		//This cascades over if the employee's supervisor is a department head.
		status = req.getStatus(); //refresh status for if supervisor = department head.
		if(me == reqDept && status.equals("SupervisorApproved"))
			RequestService.changeStatus(reqID,"DeptHeadApproved");
			
		//If it is approved by the department head, and I'm the benefits coordinator, set the status to BenCoApproved.
		//At this stage, the money is taken out of the user's REMAINING money account.
		//it is not in his awarded money account until his grade is approved.
		if(me == reqBenCo && status.equals("DeptHeadApproved")) {
			
			int money = req.getRefundAmount();
			int newMoney = PersonService.getRemainingMoney(reqMaker)-money;
			if (newMoney < 0) newMoney = 0;
			PersonService.setRemainingMoney(reqMaker, newMoney);	
			RequestService.changeStatus(reqID, "BenCoApproved");
		
		}
		
		//If it is awaiting a grade, and I'm the supervisor, set the status to MoneyAwarded. Now, the money
		//(and any adjustments) are taken out of the user's AWARDED money account.
		//all adjustments to the remaining money account are done in the BenCoApproved stage.
		if(me == reqSup && status.equals("BenCoApproved")) {
			
			int money = req.getRefundAmount();
			int newMoney = PersonService.getAwardedMoney(reqMaker)+money;
			if (newMoney < 0) newMoney = 0;
			PersonService.setAwardedMoney(reqMaker, newMoney);	
			RequestService.changeStatus(reqID, "MoneyAwarded");
					
		}
		
		//That's It! The whole chain of approvals from EmployeeSubmitted to AwardedMoney.
	
	}
	public static void updateGrade(int reqID, String grade) {
		
		MessageService.createMessage(RequestService.getRequest(reqID).getPersonID(),PersonService.personLoggedIn.getPersonID(), 
									reqID, "A passing grade of "+grade+" has been earned.");

	}

	public static void alterRefund(int reqID, int amount, String reason) {
		
		//If the refund is altered, do three things:
		
		//1.) Send a message to the employee the refund has been altered, and send the reason.
		MessageService.createMessage(RequestService.getRequest(reqID).getPersonID(), PersonService.personLoggedIn.getPersonID(), 
									reqID, "Your refund amount has been altered from "+RequestService.getRequest(reqID).getRefundAmount()
									+" to "+amount+" because "+reason);
		
		//2.) Change the refund amount
		RequestTable.requestDBtable.get(reqID).setRefundAmount(amount);
		
		//3.) If amount approved is greater than the amount the person has available, mark this event and its reason why
		// this message is visible to everyone
		Person reqMaker = PersonService.getPerson(RequestService.getRequest(reqID).getPersonID());
		if(amount > reqMaker.getAmountRemaining()) {
			RequestTable.requestDBtable.get(reqID).setOverReason(reason);
			MessageService.createMessage(PersonService.everyone, PersonService.personLoggedIn.getPersonID(), reqID, 
										"This request exceeds "+reqMaker.getName()+"'s available funds by $"+(amount-reqMaker.getAmountRemaining()));
		
		}
	}

	public static void declineRequest(int reqID, String reason) {
		
		//Decline or cancel the request. Call it "Declined" if it was by someone other than the request originator,
		//and call it "Cancelled" if it is by the request originator.
		Request req = RequestService.getRequest(reqID);
		if (PersonService.personLoggedIn.getPersonID() == RequestService.getRequest(reqID).getPersonID()) {
			RequestService.changeStatus(reqID, "Cancelled");
			MessageService.createMessage(PersonService.everyone, PersonService.personLoggedIn.getPersonID(), reqID, 
										"This request has been cancelled by "+PersonService.personLoggedIn.getName()+" because "+reason);
		}
		else {
			
			//If the request is being declined by the supervisor after the benco has approved it, then its likely because
			//the person got a poor grade/bad presentation on the event. the person who created it needs to be reimbursed 
			//their available money.			
			int reqSup = PersonService.getSupervisorID(req.getPersonID());	
			if(PersonService.personLoggedIn.getPersonID() == reqSup && req.getStatus().equals("BenCoApproved")) {
							int current = PersonService.getRemainingMoney(req.getPersonID());
							PersonService.setRemainingMoney(req.getPersonID(),current+req.getRefundAmount());
							System.out.println("OOPS! Somebody got a bad grade and had to get refunded!!!");
			}
				
			//Otherwise, just decline the request without any money changes.	
			RequestService.changeStatus(reqID, "Declined");
			MessageService.createMessage(PersonService.everyone, PersonService.personLoggedIn.getPersonID(), reqID, 
					"This request has been declined by "+PersonService.personLoggedIn.getName()+" because "+reason);
		}
	}
}