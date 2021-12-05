/*
package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.models.Pokemon;
import com.revature.service.PokemonService;
import com.revature.service.PokemonServiceImpl;
*/

package TRMSController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import PokeModels.Pokemon;
import PokeServices.PokemonService;
import PokeServices.PokemonServiceImpl;
import TRMSmodels.HomeJson;
import TRMSmodels.Listing;
import TRMSmodels.Message;
import TRMSmodels.Person;
import TRMSmodels.Request;
import TRMSservices.MessageService;
import TRMSservices.PersonService;
import TRMSservices.RequestService;
import TRMStests.Movie;
import TRMStests.MovieService;

public class TRMSController {

	public static PokemonService ps = new PokemonServiceImpl();
	public static Gson gson = new Gson();
	//public static boolean movieAlreadyRun = false;
	
	public static void showHomepage(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Person me = PersonService.personLoggedIn;
		
		System.out.println("<><><><><><><><><><><><><><><>"+PersonService.personLoggedIn);
		
		int reqSup;
		int reqBenCo;
		
		//System.out.println("++++++++++++"+me.getName()+"'s Homepage. This person has " 
		//		+  me.getAmountAwarded()+" awarded this year, and "
		//		+  me.getAmountRemaining()+" left available.+++++++++++++");
		
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
			listItem.setUserAction("nothing3");
			if(me.getPersonID() == r.getPersonID() && !r.getStatus().equals("MoneyAwarded")) {
				listItem.setUserAction("ShowCancelButton");
				//System.out.println(" > > > > > A cancel button should be shown for this listing. < < < < <");
			}
			
			//If the supervisor is logged in during the BenCoApproved stage, show the grade field
			//This will be flagged as "ShowGradeField" in DebugComment2.
			reqSup = PersonService.getSupervisorID(r.getPersonID());		
			if(me.getPersonID() == reqSup && r.getStatus().equals("BenCoApproved")) {
				listItem.setUserAction("ShowGradeField");
				//System.out.println(" > > > > > The Passing Grade field should be shown for this listing. < < < < <");
			}
			
			//If the benefits coordinator is logged in during SupervisorApproved stage,
			//show the refund amount field for altering.
			//This will be flagged as "ShowRefundField" in DebugComment2
			reqBenCo = PersonService.getBenCoID(r.getPersonID());
			if(me.getPersonID() == reqBenCo && r.getStatus().equals("DeptHeadApproved")) {
				listItem.setUserAction("ShowRefundField");
				//System.out.println(" > > > > > The Show Refund field should be shown for this listing. < < < < <");
			}
			
			myListings.add(listItem);
			
			//System.out.println("Request ID: "+r.getRequestID()+
			//					" for "+PersonService.getPerson(r.getPersonID()).getName());
			//System.out.println(listItem);
			//System.out.println(listItem.getUserAction()+" "+listItem.getRequestID());
						

		}
		
		HomeJson homepage = new HomeJson();
		homepage.setUser(PersonService.personLoggedIn);
		homepage.setRequestList(myListings);
		//System.out.println("REQUEST----------------FROM\nHOMEPAGE------------------THE\nBEGIN---------------WEB\n");
		//System.out.println(homepage);
		//System.out.println("REQUEST-----------------FROM\nHOMEPAGE-----------------THE\nEND-----------------WEB\n");
		
		//System.out.println("This shows the homepage.");
		//System.out.println(MovieService.getNextID()+" "+MovieService.movieAlreadyRun);
		//System.out.println(myListings.get(0).getUserAction());
		//System.out.println(myListings.get(1).getUserAction());
		//System.out.println(homepage.getRequestList().get(0).getUserAction());
		//System.out.println(homepage.getRequestList().get(1).getUserAction());
		response.getWriter().append(gson.toJson(homepage));
		
	}
	
	public static void makeRequest(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		Listing incoming = gson.fromJson(request.getReader(), Listing.class);
		
		System.out.println("#################################################################");
		System.out.println(incoming);
		System.out.println("#################################################################");
		RequestService.newRequest(incoming, MovieService.getNextID());
		
	}
	
	public static void login(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		Person whoLoggedIn = gson.fromJson(request.getReader(), Person.class);
		
		System.out.println("#############someobody is trying to login.####################################################");
				
		PersonService.Login(whoLoggedIn.getUsername(),whoLoggedIn.getPassword());

	}
	
	
	public static void logout(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		//Person whoLoggedIn = gson.fromJson(request.getReader(), Person.class);
		
		System.out.println("#############someobody is trying to log          out.####################################################");
				
		PersonService.Logout();

	}
	
	public static void sendMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("@@@@@@@@@@@@@@@@@someobody is sending a message.####################################################");
		
		Message envelope = gson.fromJson(request.getReader(), Message.class);
		
		MessageService.createMessage(envelope.getMessageTo(), envelope.getMessageFrom(), envelope.getRequestID(), envelope.getMessage());
	}

	
	public static void declineRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("-------------------somebody is declining a request.-----------------------------------");
		
		Message envelope = gson.fromJson(request.getReader(), Message.class);
		
		RequestService.declineRequest(envelope.getRequestID(), envelope.getMessage());
		
	}
	
	
	public static void approveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++somebody is accepting a request.++++++++++++++++++++++++++++++");
		
		Message envelope = gson.fromJson(request.getReader(), Message.class);
		
		//If the refund has been altered, change the refund and send a message, but do NOT change the status of the request.		
		if (envelope.getMessageTo() != 9999) {

			RequestService.alterRefund(envelope.getRequestID(), envelope.getMessageTo(), envelope.getMessage());
		}
		
		//If the refund amount has not been altered, just accept the request.
		if (envelope.getMessageTo() == 9999) {

			RequestService.AcceptRequest(envelope.getRequestID());
		}
	}
	
	
	
	
	
	public static void getPokemon(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("This is the getPokemon method in the Controller.");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		Pokemon p = ps.getPokemon(id);

		if (p != null)
			response.getWriter().append(gson.toJson(p));
		else
			response.getWriter().append("{}");
	}

	public static void addPokemon(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("This is the addPokemon method in the Controller.");
	
		//Let's use a Request Body, since this
		//should be a POST request
		Pokemon p = gson.fromJson(request.getReader(), Pokemon.class);
		
		//Call service to add Pokemon
		ps.addPokemon(p);
		
		//System.out.println("Before the getwriter....");
		response.getWriter().append(gson.toJson(p));

		//System.out.println("I am trying to use a redirect to go to the pokemon viewer.");
		//response.setContentType("text/html");
		//response.sendRedirect("pokemonviewer.html");

		//response.sendRedirect("http://www.google.com");
		
	
		System.out.println("This should be at the pokemon viewer - done in Frontend.");
		
	}
	
	public static void getAllPokemon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("This is the getAllPokemon method in the Controller.");
		List<Pokemon> pokeList = ps.getAllPokemon();
		
		response.getWriter().append(gson.toJson(pokeList));
		
	}







}

