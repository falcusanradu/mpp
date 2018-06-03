import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface IServices {

    boolean login(String username, String password, IObserver iObserver) throws RemoteException, SQLException;

    void logout(IObserver iObserver) throws RemoteException;

    void updateTableForOtherClients() throws RemoteException;

    List<Game> getAllGames() throws SQLException;

    boolean existsUserByUsername(String clientName) throws SQLException;

    boolean existsEnoughTickets(Integer idGame, Integer numberWantedTickets) throws SQLException;

    void updatenrTicketsAfterBuying(Integer idGame, Integer numberWantedTickets) throws SQLException;


}
