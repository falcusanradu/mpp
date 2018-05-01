package service;

import model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import repository.GameRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    private UserRepository userRepository = new UserRepository();
    private GameRepository gameRepository = new GameRepository();

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

    public void buyTickets(String clientName, Integer idGame, Integer numberWantedTickets) throws SQLException {
        if (this.buyTicketsCondition(clientName, idGame, numberWantedTickets)) {
            this.gameRepository.updatenrTicketsAfterBuying(idGame, numberWantedTickets);
        }
    }

    public List<Game> sortByNrPlaces() throws SQLException {
        Comparator<Game> comparator = Comparator.comparing(Game::getTickets);
        return this.getAllGames().stream().sorted(comparator).collect(Collectors.toList());
    }
}
