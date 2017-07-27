package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

public class SessionMap {
	
	private static Map<String,HttpSession> sessionMap=new HashMap<String,HttpSession>();
	
	
	public static boolean isExist(String sessionID){
		return sessionMap.containsKey(sessionID);
	}
	
	public static void addSession(HttpSession session){
		if(null!=session){
			String id=session.getId();
			sessionMap.put(id, session);
		}
	}
	
	public static void removeSession(String sessionID){
		if(sessionID!=null){
			sessionMap.remove(sessionID);
		}
	}
	
	
	public static HttpSession getSession(String id){
		return sessionMap.get(id);
	}
	
}
