package TRMSservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TRMSDatabaseSetup.RequestTable;
import TRMSmodels.Event;


public class EventService {


		public static Event getEvent(int id) {
			// TODO Auto-generated method stub
			return RequestTable.eventDBtable.get(id);
		}
		
		public static List<Event> getAllEvents() {
			// TODO Auto-generated method stub
			Set<Integer> keys = RequestTable.eventDBtable.keySet();
			List<Event> EventList = new ArrayList<Event>();
			
			for(Integer key: keys) {
				EventList.add(RequestTable.eventDBtable.get(key));
			}
			return EventList;
			
		}

		public static void addEvent(Event e) {
			RequestTable.eventDBtable.put(e.getEventID(), e);
		}
	
}
