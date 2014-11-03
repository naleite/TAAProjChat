package client;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
		//new Thread(new ChatUserImpl("essai1")).start();
		//ChatUser chatuser = new ChatUserImpl("essai1");
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"chat-configuration.xml"});
		ChatUser chatuser = (ChatUser) context.getBean("chatuser");
		//ChatRoom greetingService = (GreetingService)context.getBean("greetingService");
		new Thread(( ChatUserImpl)chatuser).start();
		
			
	}

}
