package TRMSDatabaseSetup;

import java.util.HashMap;
import java.util.Map;

import TRMSmodels.Message;

public class MessageTable {

	public static Map<Integer, Message> messageDBtable = new HashMap<Integer,Message>();

	static {
		
		Message m1 = new Message(3501, 27, 0, 7701, "This is only a test for Request 2701 to 27");
		Message m2 = new Message(3502, 0, 27, 7701, "This is only a test for Request 2701 from 27");
		Message m3 = new Message(3503, 27, 27, 7702, "This is only a test for Request 2702 self 27");
		Message m4 = new Message(3504, 0, 0, 7703, "This is only a test for Request 2703 not 27");
		

		
		messageDBtable.put(m1.getMessageID(), m1);
		messageDBtable.put(m2.getMessageID(), m2);
		messageDBtable.put(m3.getMessageID(), m3);
		messageDBtable.put(m4.getMessageID(), m4);
		
	
	}
	
	
}
