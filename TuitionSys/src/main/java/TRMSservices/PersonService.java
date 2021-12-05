package TRMSservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TRMSDatabaseSetup.PersonTable;
import TRMSmodels.Person;

public class PersonService {

		public static Person personLoggedIn = null;
		
		public static int everyone = 9999;
		
		public static boolean Login (String username, String password) {
			
			//Login function
			//returns true if user is found, false if not found
			
			List<Person> people = PersonService.getAllPersons();
			
			for (Person p : people) {
				if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
					personLoggedIn = p;
					return true;
				}
					
			}
			
			return false;
			
		}
		
		public static void Logout () {
			personLoggedIn = null;
		}
	
		public static Person getPerson(int id) {
			// TODO Auto-generated method stub
			return PersonTable.personDBtable.get(id);
		}

		public static List<Person> getAllPersons() {
			// TODO Auto-generated method stub
			Set<Integer> keys = PersonTable.personDBtable.keySet();
			List<Person> personList = new ArrayList<Person>();
			
			for(Integer key: keys) {
				personList.add(PersonTable.personDBtable.get(key));
			}
			return personList;
		}
		
		//use ..Idnum to not have same function names as ..ID
		public static int getSupervisorID(int id) {
			return PersonTable.personDBtable.get(id).getSupervisorID();
		}
	
		public static int getDeptHeadID(int id) {
			return PersonTable.personDBtable.get(id).getDeptHeadID();
		}
	
		public static int getBenCoID(int id) {
			return PersonTable.personDBtable.get(id).getBenCoID();
		}
	
		public static int getRemainingMoney (int id) {
			return PersonTable.personDBtable.get(id).getAmountRemaining();
		}
		
		public static int getAwardedMoney (int id) {
			return PersonTable.personDBtable.get(id).getAmountAwarded();
		}
	
		public static void setRemainingMoney(int id, int amount) {
			PersonTable.personDBtable.get(id).setAmountRemaining(amount);
		}
		
		public static void setAwardedMoney(int id, int amount) {
			PersonTable.personDBtable.get(id).setAmountAwarded(amount);
		}
}
