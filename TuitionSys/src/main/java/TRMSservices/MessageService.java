package TRMSservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import TRMSDatabaseSetup.MessageTable;
import TRMSmodels.Message;
import TRMSmodels.Request;
import TRMStests.MovieService;

public class MessageService {

	public static List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		Set<Integer> keys = MessageTable.messageDBtable.keySet();
		List<Message> MessageList = new ArrayList<Message>();
		
		for(Integer key: keys) {
			MessageList.add(MessageTable.messageDBtable.get(key));
		}
		return MessageList;
	}
	
	public static List<Message> getMyMessages(int reqID) {
		
		Set<Integer> keys = MessageTable.messageDBtable.keySet();
		List<Message> MessageList = new ArrayList<Message>();
		Message m;
		int me = PersonService.personLoggedIn.getPersonID();
				
		for(Integer key: keys) {
			
			m = MessageTable.messageDBtable.get(key);
						
			if (m.getRequestID() == reqID)									//If the requestID matches
				if (me == m.getMessageTo() || me == m.getMessageFrom() || m.getMessageTo() == PersonService.everyone)	//and the message is to or from the person logged in
					MessageList.add(m);										//add the message to the list.
		}
		return MessageList;
	}
	
	public static void createMessage(int toID, int fromID, int reqID, String body) {
		Message m = new Message();
		
		m.setMessageID(MovieService.getNextID());  //An automatic integer in the database will automatically set this field.
		m.setMessageTo(toID);
		m.setMessageFrom(fromID);
		m.setRequestID(reqID);
		m.setMessage(body);
		
		MessageTable.messageDBtable.put(m.getMessageID(),m);
		
	}
	
}
