package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartServer {

	public static void main(String[] args)  {
		/*try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			System.err.println("Il y a deja un registre de lancer");
		}

		ChatRoomImpl room = new ChatRoomImpl();
		Naming.rebind("ChatRoom", room);
	}*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("server-config.xml");
		
	}
}

