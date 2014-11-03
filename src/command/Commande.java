package command;

import client.User;

public interface Commande {
	void execute();
	void setUser(User u);
}
