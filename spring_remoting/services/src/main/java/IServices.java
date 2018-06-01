import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface IServices {
    void login(User user, IObserver client) throws RemoteException;

    void logout(User user, IObserver client) throws RemoteException;

    void updateTableForOtherClients() throws RemoteException;


    User login(String username, String password) throws SQLException;

    List<Game> getAllGames() throws SQLException;

    boolean existsUserByUsername(String clientName) throws SQLException;

    boolean existsEnoughTickets(Integer idGame, Integer numberWantedTickets) throws SQLException;

    void updatenrTicketsAfterBuying(Integer idGame, Integer numberWantedTickets) throws SQLException;


}
