import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClientCtrl extends UnicastRemoteObject implements IObserver, Serializable {


    // this is my server interface.
    private IServices server;

    private static AfterLoginEclipse afterLoginEclipse;

    public ClientCtrl(IServices server) throws RemoteException {
        this.server = server;
    }

    public boolean login(String username, String password) throws RemoteException, SQLException {
        return this.server.login(username, password, this);
    }

    public void logout() throws RemoteException {
        this.server.logout(this);
    }

    public List<Game> getAllGames() throws SQLException {
        return this.server.getAllGames();
    }

    public boolean buyTicketsCondition(String clientName, Integer idGame, Integer numberWantedTickets) throws SQLException {
        if (this.server.existsUserByUsername(clientName) && this.server
                .existsEnoughTickets(idGame, numberWantedTickets)) {
            return true;
        }
        return false;
    }

    public void buyTickets(String clientName, Integer idGame, Integer numberWantedTickets) throws SQLException, RemoteException {
        if (this.buyTicketsCondition(clientName, idGame, numberWantedTickets)) {
            this.server.updatenrTicketsAfterBuying(idGame, numberWantedTickets);
        }
    }

    public List<Game> sortByNrPlaces() throws SQLException {
        Comparator<Game> comparator = Comparator.comparing(Game::getTickets);
        return this.getAllGames().stream().sorted(comparator).collect(Collectors.toList());
    }


    @Override
    public void nofityClient() throws RemoteException {
        try {
            this.afterLoginEclipse.refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public AfterLoginEclipse getAfterLoginEclipse() {
        return afterLoginEclipse;
    }

    public void setAfterLoginEclipse(AfterLoginEclipse afterLoginEclipse) {
        this.afterLoginEclipse = afterLoginEclipse;
    }
}