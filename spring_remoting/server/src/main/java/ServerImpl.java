import java.rmi.RemoteException;

public class ServerImpl implements IServices {

    private UserRepository userRepository;
    public ServerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public synchronized void wasTheTableUpdated() throws RemoteException {
        System.out.println("table must be updated -- server");
    }
}
