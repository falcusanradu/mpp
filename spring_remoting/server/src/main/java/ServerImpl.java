import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerImpl implements IServices {

    private UserRepository userRepository;
    private GameRepository gameRepository;
    private List<IObserver> loggedClients;
//    private List<AfterLoginEclipse> corespondingClass;


    public ServerImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.loggedClients = new ArrayList<>();
//        this.corespondingClass = new ArrayList<>();
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }


    @Override
    public synchronized boolean login(String username, String password, IObserver iObserver) throws RemoteException, SQLException {
        if (this.userRepository.login(username, password) != null) {
            this.loggedClients.add(iObserver);
//            this.corespondingClass.add(afterLoginEclipse);
            return true;
        }
        return false;
    }

    @Override
    public synchronized void logout(IObserver iObserver) throws RemoteException {
        this.loggedClients.remove(iObserver);
//        this.corespondingClass.add(afterLoginEclipse);
    }

    @Override
    public void updateTableForOtherClients() throws RemoteException {
        System.out.println("table must be updated -- server");
        ExecutorService executor = Executors.newFixedThreadPool(this.loggedClients.size());

        executor.execute(() -> {
            for (int i = 0; i < this.loggedClients.size(); i++) {
                try {
                    this.loggedClients.get(i).nofityClient();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        });
        executor.shutdown();

    }


    /**
     * method thay are needed in the ClientCtrl
     */


    @Override
    public List<Game> getAllGames() throws SQLException {
        return this.gameRepository.getAllGames();
    }

    @Override
    public boolean existsUserByUsername(String clientName) throws SQLException {
        return this.userRepository.existsUserByUsername(clientName);
    }

    @Override
    public boolean existsEnoughTickets(Integer idGame, Integer numberWantedTickets) throws SQLException {
        return this.gameRepository.existsEnoughTickets(idGame, numberWantedTickets);
    }

    @Override
    public void updatenrTicketsAfterBuying(Integer idGame, Integer numberWantedTickets) throws SQLException {
        this.gameRepository.updatenrTicketsAfterBuying(idGame, numberWantedTickets);
        try {
            this.updateTableForOtherClients();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
