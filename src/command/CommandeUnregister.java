package command;

import java.rmi.RemoteException;

import client.User;
import server.ChatRoom;


public class CommandeUnregister implements Commande {

	ChatRoom room = null;
	User user = null;
	
	public CommandeUnregister() {
	//this.room=room;
	}

	@Override
	public void execute() {
		try {
			room.unsubscribe(user.getPseudo());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	public ChatRoom getRoom() {
		return room;
	}

	public void setRoom(ChatRoom room) {
		this.room = room;
	}

}
