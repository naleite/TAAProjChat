package command;

import java.rmi.RemoteException;

import client.ChatUI;
import client.User;
import server.ChatRoom;


public class CommandPost implements Commande {

	public CommandPost() {
		//this.room=room;
	}

	ChatRoom room = null;
	User user = null;
	ChatUI ui = null;

	@Override
	public void execute() {
		try {
			room.postMessage(user.getPseudo(), ui.getMessage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void setUser(User user) {
		this.user = user;
	}


	public void setUI(ChatUI ui2) {
		this.ui=ui2;
	}


	public ChatRoom getRoom() {
		return room;
	}


	public void setRoom(ChatRoom room) {
		this.room = room;
	}


	public ChatUI getUi() {
		return ui;
	}


	public void setUi(ChatUI ui) {
		this.ui = ui;
	}


	public User getUser() {
		return user;
	}

}
