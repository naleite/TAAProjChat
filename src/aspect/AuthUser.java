package aspect;

import java.util.HashMap;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;


import auth.SampleLoginModule;

import com.sun.security.auth.callback.DialogCallbackHandler;

import server.ChatRoom;


public class AuthUser {
	private ChatRoom room;
	
	public void doAuth(){
		System.out.println("doAuth Aspect active");
		SampleLoginModule lc = null;
		try {
			lc = new SampleLoginModule();
			lc.setRoom(room);
			lc.initialize(new Subject(), new DialogCallbackHandler(), null,
					new HashMap());
		} catch (SecurityException se) {
			System.err.println("Cannot create LoginContext. "
					+ se.getMessage());
			System.exit(-1);
		}

		// the user has 3 attempts to authenticate successfully
		int i;
		for (i = 0; i < 3; i++) {
			try {

				// attempt authentication
				lc.login();
				break;

			} catch (LoginException le) {

				System.err.println("Authentication failed:");
				System.err.println("  " + le.getMessage());
				try {
					Thread.currentThread();
					Thread.sleep(3000);
				} catch (Exception e) {

				}

			}
		}

		if (i == 3) {
			System.out.println("Sorry");
			
			System.exit(-1);
		}
		System.out.println("Authentication succeeded!");
	}
	
	public void setRoom(ChatRoom room) {
		this.room = room;
	}
	
}
