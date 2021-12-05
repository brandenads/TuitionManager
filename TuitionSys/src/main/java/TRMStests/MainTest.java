package TRMStests;

import TRMSController.RequestPage;
import TRMSmodels.Listing;

public class MainTest {

		//@Test
		public void cmenu_mainTest () { 
		
		
		//This class runs a "movie" of the TRMS in action. Used to develop and test the backend.
		
		//=====================ACT 0: Setting up the Database for the first time========================
		Listing nl = new Listing();	
		
		//John Doe logs in.
		RequestPage.Login("johndoeuser", "johndoepassword");
		//John Doe makes a request.
		nl.setEventName("Kaplan's's A+ Certification Training Course");
		nl.setDescription("A course to help get ready for the A+");
		nl.setRequestDate("08/01/2020");
		nl.setCost(300);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Aurora, Colorado");
		nl.setEventDate("03/10/2020");
		nl.setEventTime("9:30 AM");
		nl.setEventType("Test Prep Course");
		nl.setWorkReason("I am always called on to be Mr. Fix it. This will help me!");
		nl.setMissedWork("NONE");
		nl.setGradeFormat("Pass/Fail");
		nl.setPassingGrade("PASS");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(false);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("CURTAINS - John Doe's old request for getting the A+ Certification");
		RequestPage.MakeNewRequest(nl, 2701);
		RequestPage.ShowHomepage();
		//John Doe logs out.
		RequestPage.Logout();
		
		//Robert Logs in (JohnDoe's Supervisor)
		RequestPage.Login("robertuser", "robertpassword");
		//Robert accepts John Doe's request for the A+
		RequestPage.AcceptRequest(2701);
		//Robert makes a new request
		nl.setEventName("Being an Effective Manager");
		nl.setDescription("A seminar to help supervisors to be their best");
		nl.setRequestDate("07/15/2020");
		nl.setCost(400);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Denver, Colorado");
		nl.setEventDate("10/20/2020");
		nl.setEventTime("9:30 AM");
		nl.setEventType("Seminar");
		nl.setWorkReason("I just got my review from the Department Head, and he says to brush up on some skills");
		nl.setMissedWork("Two days 10/20 and 10/21");
		nl.setGradeFormat("Presentation");
		nl.setPassingGrade("PASS");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(true);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("CURTAINS - Robert makes a request for management training.");
		RequestPage.MakeNewRequest(nl, 2718);
		RequestPage.ShowHomepage();	
		//Robert Logs out.
		RequestPage.Logout();
		
		//John Doe Logs back in
		RequestPage.Login("johndoeuser", "johndoepassword");		
		//John Doe checks his homepage. Should see his request supervisor approved.
		System.out.println("/////////////////BELOW: A+ Request should be supervisor accepted.////////////////////////////////////////////////////////////");
		RequestPage.ShowHomepage();
		//John Doe Logs out.
		RequestPage.Logout();
		
		//Daniel Logs in (JohnDoe's Department Head)
		RequestPage.Login("danieluser", "danielpassword");
		//Daniel accepts john doe's request for the A+
		RequestPage.AcceptRequest(2701);
		//Daniel makes a new request.
		nl.setEventName("MGMT 450 - Organization Structure and Design");
		nl.setDescription("A course about how organizations can be better designed");
		nl.setRequestDate("08/01/2020");
		nl.setCost(800);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Denver, Colorado");
		nl.setEventDate("10/20/2020");
		nl.setEventTime("4:55 PM");
		nl.setEventType("University Course");
		nl.setWorkReason("I need to restructure my organization for better productivity.");
		nl.setMissedWork("NONE");
		nl.setGradeFormat("Letter Grade");
		nl.setPassingGrade("B+");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(true);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("CURTAINS - Daniel makes a request to take a college course.");
		RequestPage.MakeNewRequest(nl, 2705);
		RequestPage.ShowHomepage();	
		//Daniel logs out.
		RequestPage.Logout();
		
		//John Doe Logs back in
		RequestPage.Login("johndoeuser", "johndoepassword");
		//John Doe checks his homepage. Should see his request supervisor approved.
		System.out.println("/////////////////BELOW: A+ Request should be department head approved.////////////////////////////////////////////////////////////");
		RequestPage.ShowHomepage();
		//John Doe Logs out.
		RequestPage.Logout();
		
		//Timothy Logs in (JohnDoe's Benefits Coordinator)
		RequestPage.Login("timothyuser", "timothypassword");
		//Timothy accepts john doe's request for the A+
		System.out.println("- - - - - - - - - Timothy's Homepage  - - - - - - - - - -");
		RequestPage.ShowHomepage();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		RequestPage.AlterRefund(2701, 280, "This is a really good program");
		RequestPage.AcceptRequest(2701);
		//Timothy makes a new request.
		nl.setEventName("SalesForce Coding, Configuring, and Maintenance");
		nl.setDescription("Technical training on how SalesForce software is used");
		nl.setRequestDate("07/30/2020");
		nl.setCost(500);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Colorado Springs, Colorado");
		nl.setEventDate("10/21/2020");
		nl.setEventTime("8:00 AM");
		nl.setEventType("Technical Training");
		nl.setWorkReason("My position as a Benefits Coordinater requires extensive usage of SalesForce");
		nl.setMissedWork("NONE");
		nl.setGradeFormat("Percentage");
		nl.setPassingGrade("75");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(false);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("CURTAINS - Timothy takes a course to learn about sales force.");
		RequestPage.MakeNewRequest(nl, 2710);
		//Timothy logs out.
		RequestPage.Logout();
		
		//John Doe Logs back in
		RequestPage.Login("johndoeuser", "johndoepassword");
		//John Doe checks his homepage. Should see his request supervisor approved.
		System.out.println("/////////////////BELOW: A+ Request should be benefits coordianator approved.////////////////////////////////////////////");
		System.out.println("/////////////////BELOW: AND money taken out of his remaining account.///////////////////////////////////////////");
		RequestPage.ShowHomepage();
		//John Doe sends a message about his passing grade to his supervisor.
		RequestPage.SendMessage(35, 2701, "I recieved a passing grade of 95% on my A+ training");
		//John Doe Logs out.
		RequestPage.Logout();
		
		//Robert Logs in (JohnDoe's Supervisor for approving grade)
		RequestPage.Login("robertuser", "robertpassword");
		System.out.println("- - - - - - - - - Robert's Homepage  - - - - - - - - - -");
		RequestPage.ShowHomepage();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		RequestPage.UpdateGrade(2701, "95%");
		//Robert accepts John Doe's request for the A+
		RequestPage.AcceptRequest(2701);
		//Robert Logs out.
		RequestPage.Logout();
		
		//John Doe Logs back in
		RequestPage.Login("johndoeuser", "johndoepassword");
		//John Doe checks his homepage. Should see his request supervisor approved.
		System.out.println("/////////////////BELOW: A+ Request should be money awarded.////////////////////////////////////////////");
		System.out.println("/////////////////BELOW: AND money added to his awarded account.///////////////////////////////////////////");
		RequestPage.ShowHomepage();
		//John Doe Logs out.
		RequestPage.Logout();
		
		
		
	
		
		
		
		
		
		
		
		
		
		System.out.println("/////////////////////////////////////////////////////////////////////////////");
		System.out.println("/////////////////////////////////////////////////////////////////////////////");
		System.out.println("/////////////////////////////////////////////////////////////////////////////");
		//======================ACT 1: Employees Logging In for the First Time=========================
		
		//----------------------Scene 1: A standard employee logs in------------------------------------
		
		//John Doe Logs in
		//RequestPage.Login("johndoeusername", "johndoepassword");   //Failed attempt.
		//RequestPage.Login("robertuser", "robertpassword");  //Succeed
		RequestPage.Login("johndoeuser", "johndoepassword"); 
		//John Doe looks at the requests in his account.
		RequestPage.ShowHomepage();
		//He wants to create a request.
		nl.setEventName("IEEE Web Design Conference");
		nl.setDescription("An international conference of Web Designers");
		nl.setRequestDate("08/03/2020");
		nl.setCost(2000);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Cleveland");
		nl.setEventDate("09/20/2020");
		nl.setEventTime("10:00 AM");
		nl.setEventType("Seminar");
		nl.setWorkReason("Helps me be a better/faster web designer!");
		nl.setMissedWork("NONE");
		nl.setGradeFormat("Presentation");
		nl.setPassingGrade("PASS");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(true);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("ACT 1 SCENE 1 - John Doe creates a new request to attend the IEEE");
		//John Doe makes a new request
		RequestPage.MakeNewRequest(nl, 2706);
		//John Doe views his homepage
		RequestPage.ShowHomepage();
		//John Doe logs out.
		RequestPage.Logout();
		
		//Patrick Logs back in
		RequestPage.Login("patrickuser", "patrickpassword");
		//Patrick makes a new request
		nl.setEventName("Presidents and CEO's Roundtable");
		nl.setDescription("A yearly meeting of high-ranking officials.");
		nl.setRequestDate("08/11/2020");
		nl.setCost(3000);
		nl.setRefund(-1);  //set on backend
		nl.setEventLocation("Cleveland, Ohio");
		nl.setEventDate("08/20/2020");
		nl.setEventTime("10:00 AM");
		nl.setEventType("Other");
		nl.setWorkReason("Allows me to network and discuss with other company officials.");
		nl.setMissedWork("NONE");
		nl.setGradeFormat("Presentation");
		nl.setPassingGrade("PASS");
		nl.setGradeRecieved("NONE - REQUEST IN PROGRESS");
		nl.setTalkNeeded(true);
		nl.setStatus("EmployeeSubmitted");
		nl.setDebugComment1("ACT 1 SCENE 1 - Patricks makes a request to go to a yearly business owner's convention");
		RequestPage.MakeNewRequest(nl, 2709);
		//Patrick looks at his homepage
		RequestPage.ShowHomepage();
		//Patrick logs out.
		RequestPage.Logout();
	
}
}
