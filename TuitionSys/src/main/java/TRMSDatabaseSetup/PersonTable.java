package TRMSDatabaseSetup;

import java.util.HashMap;
import java.util.Map;

import TRMSmodels.Person;


public class PersonTable {

	public static Map<Integer, Person> personDBtable = new HashMap<Integer,Person>();

	static {
		/*
		Person p1 = new Person(27, "JohnDoe", 35, 48, 68, "johndoeuser", "johndoepassword", 1000, 0);
		Person p2 = new Person(35, "Robert", 48, 48, 68, "robertuser", "robertpassword", 1000, 0);
		Person p3 = new Person(48, "Daniel", 59, 59, 68, "danieluser", "danielpassword",1000, 0);
		Person p4 = new Person(59, "Patrick", 59, 59, 68, "patrickuser", "patrickpassword",1000, 0);
		Person p5 = new Person(68, "Timothy", 48, 48, 59, "timothyuser", "timothypassword",1000, 0);
		Person p6 = new Person(72, "Alex", 35, 48, 68, "alexuser", "alexpassword",1000, 0); //Alex is solely for testing.
		Person p7 = new Person(0, "[System]", 0, 0, 0, "systemuser", "systempassword",1000, 0);
		*/
		
		
		Person p1 = new Person(27, "JohnDoe", 35, 48, 68, "j", "j", 1000, 0);
		Person p2 = new Person(35, "Robert", 48, 48, 68, "r", "r", 1000, 0);
		Person p3 = new Person(48, "Daniel", 59, 59, 68, "d", "d",1000, 0);
		Person p4 = new Person(59, "Patrick", 72, 72, 68, "p", "p",1000, 0);
		Person p5 = new Person(68, "Timothy", 48, 48, 59, "t", "t",1000, 0);
		Person p6 = new Person(72, "Alex", 35, 48, 68, "a", "a",1000, 0); //Alex is solely for testing.
		Person p7 = new Person(0, "[System]", 0, 0, 0, "s", "s",1000, 0);
		
		
		personDBtable.put(p1.getPersonID(), p1);
		personDBtable.put(p2.getPersonID(), p2);
		personDBtable.put(p3.getPersonID(), p3);
		personDBtable.put(p4.getPersonID(), p4);
		personDBtable.put(p5.getPersonID(), p5);
		personDBtable.put(p6.getPersonID(), p6);
		personDBtable.put(p7.getPersonID(), p7);
		
		
	}
	
	
}
