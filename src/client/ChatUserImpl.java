package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import server.ChatRoom;
import auth.SampleLoginModule;

import com.sun.security.auth.callback.DialogCallbackHandler;

import command.CommandPost;
import command.Commande;
import command.CommandeUnregister;


public class ChatUserImpl extends UnicastRemoteObject implements ChatUser,Runnable,
		 User {
	private ChatRoom room=null;

	private String pseudo=null;

	private String name=null ;

	private ChatUI ui=null;

	public ChatUserImpl() throws RemoteException {
		super(); // Appel au constructeur de UnicastRemoteObject
		//this.name=name;
		/*try {
			//this.room = (ChatRoom) Naming.lookup("rmi://localhost/ChatRoom");
		} catch (Exception e) {

			e.printStackTrace();
			System.exit(0);
		}
		//this.createIHM();
		// this.requestPseudo();
*/	}

	/*public void createIHM() {
		Commande unreg = new CommandeUnregister();
		unreg.setUser(this);
		Commande post = new CommandPost();
		post.setUser(this);
		ui = new ChatUI();
		((CommandPost) post).setUI(ui);
	}*/

	@Override
	public void displayMessage(String message) throws RemoteException {
		ui.displayMessage(message);
	}

	@Override
	public void run() {
		try {
			//auth();
			this.pseudo = ui.requestPseudo();
			this.room.subscribe(this, this.pseudo);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPseudo() {
		return pseudo;
	}

	public ChatRoom getRoom() {
		return room;
	}

	public void setRoom(ChatRoom room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public ChatUI getUi() {
		return ui;
	}

	public void setUi(ChatUI ui) {
		this.ui = ui;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

/*	private void auth(){
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
	}*/

}