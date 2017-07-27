package utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("add:"+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		String id=arg0.getSession().getId();
		System.out.println("del:"+id);
		SessionMap.removeSession(id);
	}

}
