package TRMSmodels;

import java.util.ArrayList;
import java.util.List;

import TRMSservices.CategoryService;

public class HomeJson {
	
	Person user = new Person();
	List<Listing> requestList = new ArrayList<Listing>();
	
	public Person getUser() {
		return user;
	}
	public List<Listing> getRequestList() {
		return requestList;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	public void setRequestList(List<Listing> requestList) {
		this.requestList = requestList;
	}
	
	@Override
	public String toString() {
		return "HomeJson [user=" + user + ", requestList=" + requestList + "]";
	}
	
	public HomeJson(Person user, List<Listing> requestList) {
		super();
		this.user = user;
		this.requestList = requestList;
	}
	
	public HomeJson() {
		super();
	}
	
	

}
