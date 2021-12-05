package TRMStests;

public class MovieService {
	
	//functions used at debug and development time.
	
	public static int globalInteger = 3000;

	public static boolean movieAlreadyRun = false;
	
	public static int getNextID() {
		globalInteger+=1;
		return globalInteger;
	}

}
