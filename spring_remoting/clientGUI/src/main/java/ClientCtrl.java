import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClientCtrl extends UnicastRemoteObject implements IObserverNew, Serializable {

    // this is my server interface.
    private IServices server;

    private UserRepository userRepository = new UserRepository();
    private GameRepository gameRepository = new GameRepository();

    public ClientCtrl(IServices server) throws RemoteException {
        this.server = server;
    }

    public boolean login(String username, String password) throws SQLException {
        if (this.userRepository.login(username, password) != null) {
            return true;
        }
        return false;
    }

    public List<Game> getAllGames() throws SQLException {
        return this.gameRepository.getAllGames();
    }

    public boolean buyTicketsCondition(String clientName, Integer idGame, Integer numberWantedTickets) throws SQLException {
        if (this.userRepository.existsUserByUsername(clientName) && this.gameRepository
                .existsEnoughTickets(idGame, numberWantedTickets)) {
            return true;
        }
        return false;
    }

    public void buyTickets(String clientName, Integer idGame, Integer numberWantedTickets) throws SQLException, RemoteException {
        if (this.buyTicketsCondition(clientName, idGame, numberWantedTickets)) {
            this.gameRepository.updatenrTicketsAfterBuying(idGame, numberWantedTickets);
            this.refreshTable();
        }
    }

    public List<Game> sortByNrPlaces() throws SQLException {
        Comparator<Game> comparator = Comparator.comparing(Game::getTickets);
        return this.getAllGames().stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public void refreshTable() throws RemoteException {
        // TODO:
        System.out.println("TODO: refresh");
        this.server.wasTheTableUpdated();
    }
}