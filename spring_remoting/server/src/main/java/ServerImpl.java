import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ServerImpl implements IServices {

    private UserRepository userRepository = new UserRepository();
    private GameRepository gameRepository = new GameRepository();
    private List<User> loggedClients;


    public ServerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void login(User user, IObserver client) throws RemoteException {

    }

    @Override
    public void logout(User user, IObserver client) throws RemoteException {

    }

    @Override
    public synchronized void updateTableForOtherClients() throws RemoteException {
        System.out.println("table must be updated -- server");
    }


    /**
     * method thay are needed in the ClientCtrl
     */

    @Override
    public User login(String username, String password) throws SQLException {
        return this.userRepository.login(username, password);
    }

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
    }


}
