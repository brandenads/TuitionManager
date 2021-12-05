package TRMSservlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TRMSController.TRMSController;
import TRMStests.Movie;
import TRMStests.MovieService;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//This method will delegate other methods on the 
		//controller layer of our application to process the request.
		//a router, or a delegator.
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch(uri) {
		
		case "/TuitionSys/showHomepage.do": {
			TRMSController.showHomepage(request, response);
			break;
		}
		case "/TuitionSys/makeRequest.do": {
			TRMSController.makeRequest(request, response);
			break;
		}
		case "/TuitionSys/login.do": {
			TRMSController.login(request, response);
			break;
		}
		case "/TuitionSys/logout.do": {
			TRMSController.logout(request, response);
			break;
		}
		case "/TuitionSys/sendMessage.do": {
			TRMSController.sendMessage(request, response);
			break;
		}
		case "/TuitionSys/declineRequest.do": {
			TRMSController.declineRequest(request, response);
			break;
		}
		case "/TuitionSys/approveRequest.do": {
			TRMSController.approveRequest(request, response);
			break;
		}
		
		
		
		
		case "/TuitionSys/movie.do": {
			if(MovieService.movieAlreadyRun==false) Movie.runMovie();
			MovieService.movieAlreadyRun=true;
			break;
		}
		case "/TuitionSys/getPokemon.do": {
			TRMSController.getPokemon(request, response);
			break;
		}
		case "/TuitionSys/addPokemon.do": {
			TRMSController.addPokemon(request, response);
			break;
		}
		case "/TuitionSys/allPokemon.do": {
			TRMSController.getAllPokemon(request, response);
			break;
		}
		default: {
			//Should be 404 in production
			response.sendError(418,"I'm a little teapot.");
		}
		
		

		}
	}
}
