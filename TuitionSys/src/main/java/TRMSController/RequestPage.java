package TRMSController;

import java.util.ArrayList;
import java.util.List;

import TRMSmodels.Event;
import TRMSmodels.HomeJson;
import TRMSmodels.Listing;
import TRMSmodels.Person;
import TRMSmodels.Request;
import TRMSservices.CategoryService;
import TRMSservices.EventService;
import TRMSservices.MessageService;
import TRMSservices.PersonService;
import TRMSservices.RequestService;

public class RequestPage {

	public static void Login (String username, String password) {
		
		if (PersonService.Login(username, password)) 
			System.out.println(PersonService.personLoggedIn.getName()+" is logged in and has " 
					+   PersonService.personLoggedIn.getAmountAwarded()+" awarded this year, and "
					+  PersonService.personLoggedIn.getAmountRemaining()+" left available.");
			else
			System.out.println(username+" and "+password+" are not valid credentials");
	}
	
	public static void Logout() {
	
		System.out.println(PersonService.personLoggedIn.getName()+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^is logged out!^^^^^^^^^^^^^^^^^^^^^^^^^^");
		PersonService.Logout();
		
	}
	
	public static void ShowHomepage () {
		
		//Show header
		Person me = PersonService.personLoggedIn;
		int reqSup;
		int reqBenCo;
		
		System.out.println("++++++++++++"+me.getName()+"'s Homepage. This person has " 
				+  me.getAmountAwarded()+" awarded this year, and "
				+  me.getAmountRemaining()+" left available.+++++++++++++");
		
		//Get all of this person's request
		List<Request> myRequests = RequestService.GetMyRequests();
		List<Listing> myListings = new ArrayList<Listing>();
		Listing listItem;

		//Print out all of the listings;
		for (Request r : myRequests) {
			listItem = RequestService.CreateListing(r.getRequestID(), r.getEventID());

			//Determine if special fields need to be shown on the frontend, on a per-listing basis.
			
			//If the requesting employee is logged in, show a cancel button at all stages except for when the
			//money is awarded, instead of the ususal Decline button. A reason will not be required.
			if(me.getPersonID() == r.getPersonID() && !r.getStatus().equals("MoneyAwarded")) {
				listItem.setUserAction("ShowCancelButton");
				System.out.println(" > > > > > A cancel button should be shown for this listing. < < < < <");
			}
			
			//If the supervisor is logged in during the BenCoApproved stage, show the grade field
			//This will be flagged as "ShowGradeField" in DebugComment2.
			reqSup = PersonService.getSupervisorID(r.getPersonID());		
			if(me.getPersonID() == reqSup && r.getStatus().equals("BenCoApproved")) {
				listItem.setUserAction("ShowGradeField");
				System.out.println(" > > > > > The Passing Grade field should be shown for this listing. < < < < <");
			}
			
			//If the benefits coordinator is logged in during SupervisorApproved stage,
			//show the refund amount field for altering.
			//This will be flagged as "ShowRefundField" in DebugComment2
			reqBenCo = PersonService.getBenCoID(r.getPersonID());
			if(me.getPersonID() == reqBenCo && r.getStatus().equals("DeptHeadApproved")) {
				listItem.setUserAction("ShowRefundField");
				System.out.println(" > > > > > The Show Refund field should be shown for this listing. < < < < <");
			}
			
			myListings.add(listItem);
			
			System.out.println("Request ID: "+r.getRequestID()+
								" for "+PersonService.getPerson(r.getPersonID()).getName());
			System.out.println(listItem);
						

		}
		
		HomeJson homepage = new HomeJson();
		homepage.setUser(PersonService.personLoggedIn);
		homepage.setRequestList(myListings);
		System.out.println("REQUEST\nHOMEPAGE\nBEGIN\n");
		System.out.println(homepage);
		System.out.println("REQUEST\nHOMEPAGE\nEND\n");
		
	}

	public static void MakeNewRequest(Listing nl, int presetID) {
		
		RequestService.newRequest(nl, presetID);

	}

	public static void SendMessage (int toID, int reqID, String body) {
		
		MessageService.createMessage(toID, PersonService.personLoggedIn.getPersonID(), reqID, body);
	}
	
	public static void AcceptRequest(int reqID) {

		RequestService.AcceptRequest(reqID);
	
	}
	
	public static void UpdateGrade(int reqID, String grade) {
		
		RequestService.updateGrade(reqID, grade);
	}
	
	public static void AlterRefund(int reqID, int amount, String reason) {
		
		RequestService.alterRefund(reqID, amount, reason);
	}

	public static void DeclineRequest(int reqID, String reason) {
		
		RequestService.declineRequest(reqID, reason);
	}
	
}
