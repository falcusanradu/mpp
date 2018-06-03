import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartClient {

    public static void main(String[] args) {

        try {
            /*String
            Registry registry = LocateRegistry.getRegistry("localhost");
            IChatServices server = (IChatServices) registry.lookup(name);*/

            ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-client.xml");
            IServices server = (IServices) factory.getBean("Service");
            System.out.println("Obtained a reference to remote server");
            ClientCtrl ctrl = new ClientCtrl(server);


            SwingGUIEclipse swingGUIEclipse = new SwingGUIEclipse(ctrl);
            swingGUIEclipse.frame.setVisible(true);

        } catch (Exception e) {
            System.err.println("Chat Initialization  exception:" + e);
            e.printStackTrace();
        }

    }
}